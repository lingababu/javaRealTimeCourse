package com.CounsellorPortal.sImpl;

import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CounsellorPortal.DTO.CounsellorDto;
import com.CounsellorPortal.entity.Counsellor;
import com.CounsellorPortal.repo.CounsellorRepo;
import com.CounsellorPortal.sInterfaces.CounsellorSI;

@Service
public class CounsellorSImpl implements CounsellorSI {

	@Autowired
	private CounsellorRepo counsellorRepo;

	@Override
	public boolean counsellorRegister(CounsellorDto counsellorDto) {

		Counsellor counsellor = new Counsellor();

		BeanUtils.copyProperties(counsellorDto, counsellor);

		Counsellor savedEntity = counsellorRepo.save(counsellor);

		return savedEntity.getCounsellorId() != null;
	}

	@Override
	public CounsellorDto counsellorLogin(String email, String password) {

		Counsellor counsellorEntry = counsellorRepo.findByEmailAndPassword(email, password);

		if (counsellorEntry != null) {

			CounsellorDto cDto = new CounsellorDto();

			BeanUtils.copyProperties(counsellorEntry, cDto);

			return cDto;
		}

		return null;
	}

	@Override
	public boolean isEmailUnique(String email) {

		Optional<Counsellor> checkEmail = counsellorRepo.findByEmail(email);

		if (checkEmail.isPresent()) {

			return false; 
		}

		return true;

	}
}
