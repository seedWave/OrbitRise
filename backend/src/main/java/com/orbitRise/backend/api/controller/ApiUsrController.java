package com.orbitRise.backend.api.controller;

import com.orbitRise.backend.DTO.SignUpRequestDTO;
import com.orbitRise.backend.service.UsrService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/orbitRise/usr")
@RequiredArgsConstructor
public class ApiUsrController {

    private final UsrService usrService;

    @GetMapping("/login")
    public String login() {
        return "/orbitRise/login"; // templates/login.html (Thymeleaf 기준)
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@Valid @RequestBody SignUpRequestDTO dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // 에러 메시지 추출
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            return ResponseEntity.badRequest().body(errorMsg);
        }

        usrService.signUp(dto);
        return ResponseEntity.ok("회원가입 성공!");
    }
}
