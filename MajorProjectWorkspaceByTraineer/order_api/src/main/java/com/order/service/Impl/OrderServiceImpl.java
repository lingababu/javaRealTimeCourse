package com.order.service.Impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.order.dto.AddressDto;
import com.order.dto.CustomerDto;
import com.order.dto.OrderDto;
import com.order.dto.OrderItemDto;
import com.order.dto.OrderRequestDto;
import com.order.dto.OrderResponseDto;
import com.order.entity.Address;
import com.order.entity.Customer;
import com.order.entity.OrderItem;
import com.order.entity.Orders;
import com.order.repo.AddressRepo;
import com.order.repo.CustomerRepo;
import com.order.repo.OrderItemRepo;
import com.order.repo.OrderRepo;
import com.order.service.OrderService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;

@Service
public class OrderServiceImpl implements OrderService {


	@Autowired
	private RazorpayClient razorpayClient;
	
	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private AddressRepo addressRepo;

	@Autowired
	private OrderRepo orderRepo;

	@Autowired
	private OrderItemRepo orderItemRepo;

	@Value("${razorpay.key.id}")
	private String razorpayKey;

	@Value("${razorpay.secret}")
	private String razorpaySecret;


	@Override
	public OrderResponseDto createOrder(OrderRequestDto orderRequestDto) throws Exception {		
		
		// create razorpay order
		JSONObject razorpayOrderRequest = new JSONObject();
		
		BigDecimal amount = orderRequestDto.getOrder().getTotalPrice().multiply(new BigDecimal(100));
		
		razorpayOrderRequest.put("amount", amount.intValue());
		razorpayOrderRequest.put("currency", "INR");
		razorpayOrderRequest.put("receipt", orderRequestDto.getCustomer().getEmail());
		this.razorpayClient = new RazorpayClient(razorpayKey, razorpaySecret);
		Order orderCreated = razorpayClient.orders.create(razorpayOrderRequest);

		// save customer details
		CustomerDto customerDto = orderRequestDto.getCustomer();
		Customer customer = new Customer();
		Optional<Customer> customerDetails = customerRepo.findByEmail(customerDto.getEmail());

		if (customerDetails.isEmpty()) {

			BeanUtils.copyProperties(customerDto, customer);

			customer = customerRepo.save(customer);
		} else {

			customer = customerDetails.get();
		}

		// save address
		AddressDto addressDto = orderRequestDto.getAddress();
		Address address = new Address();
		address.setCustomer(customer);
		BeanUtils.copyProperties(addressDto, address);
		Address savedAddress = addressRepo.save(address);

		// save order
		OrderDto orderDto = orderRequestDto.getOrder();
		Orders orders = new Orders();
		String orderTrackingNumber = generateTrackingNumber();
		orders.setOrderTrackingNumber(orderTrackingNumber);
		orders.setRazorPayOrderId(orderCreated.get("id"));
		orders.setEmail(orderDto.getEmail());
		orders.setOrderStatus(orderCreated.get("status"));
		orders.setTotalPrice(orderDto.getTotalPrice());
		orders.setTotalQuantity(orderDto.getTotalQuantity());
		orders.setAddress(savedAddress);
		orders.setCustomer(customer);
		Orders savedOrder = orderRepo.save(orders);

		// retrive all the orders list
		List<OrderItemDto> orderItemsList = orderRequestDto.getOrderItems();

		orderItemsList.forEach(t -> {

			OrderItem orderItem = new OrderItem();

			BeanUtils.copyProperties(t, orderItem);

			orderItem.setOrders(savedOrder);

			orderItemRepo.save(orderItem);

		});

		OrderResponseDto response = new OrderResponseDto();

		response.setOrderStatus(orderCreated.get("status"));
		response.setOrderTrackingNumber(savedOrder.getOrderTrackingNumber());
		response.setRazorPayOrderId(orderCreated.get("id"));

		return response;
	}

	@Override
	public OrderResponseDto updateOrder(OrderDto orderDto) {

		OrderResponseDto response = new OrderResponseDto();

		Optional<Orders> orderEntity = orderRepo.findById(orderDto.getOrderId());

		if (orderEntity.isPresent()) {
			Orders order = orderEntity.get();
			order.setOrderStatus(orderDto.getOrderStatus());

			orderRepo.save(order);

			response.setRazorPayOrderId(order.getRazorPayOrderId());
			response.setOrderStatus(order.getOrderStatus());
			response.setOrderTrackingNumber(order.getOrderTrackingNumber());

		}

		return response;
	}

	@Override
	public List<OrderDto> retriveOrderDetailsBy(String email) {

		List<OrderDto> ordersList = new ArrayList<>();

		List<Orders> entityList = orderRepo.findByEmail(email);

		if (!entityList.isEmpty()) {

			entityList.forEach(t -> {
				OrderDto orderDto = new OrderDto();
				BeanUtils.copyProperties(t, orderDto);
				ordersList.add(orderDto);
			});

		}

		return ordersList;
	}

	private String generateTrackingNumber() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyymmddhhmmss");

		String timestamp = sdf.format(new Date());

		String randomUIID = UUID.randomUUID().toString().substring(0, 5).toUpperCase();

		return "OD_" + timestamp + "_" + randomUIID;

	}

}
