package com.orbitRise.backend.service;

import com.orbitRise.backend.DTO.SignUpRequestDTO;
import com.orbitRise.backend.entity.Usr;
import com.orbitRise.backend.repository.UsrRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UsrService {

    private UsrRepository usrRepository;
    private PasswordEncoder passwordEncoder;

    public UsrService(UsrRepository usrRepository, PasswordEncoder passwordEncoder) {
        this.usrRepository = usrRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void signUp(SignUpRequestDTO dto) {
        Usr user = new Usr();
        user.setUsrId(dto.getUsrId());
        user.setUsrNm(dto.getUsrNm());
        user.setPwd(passwordEncoder.encode(dto.getPwd())); // 암호화!
        user.setEmail(dto.getEmail());
        user.setIntroUrl(dto.getIntroUrl());
        user.setIntro(dto.getIntro());
        user.setMainDev(dto.getMainDev());
        user.setCareerOpenYn(dto.getCareerOpenYn());
        user.setDelYn("N");
        user.setRegDtm(LocalDateTime.now());
        user.setUpdDtm(LocalDateTime.now());

        usrRepository.save(user);
    }

}
