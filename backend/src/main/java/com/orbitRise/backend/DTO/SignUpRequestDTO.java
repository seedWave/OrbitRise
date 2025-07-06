package com.orbitRise.backend.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class SignUpRequestDTO {

    // 사용자 ID (Primary Key)
    @NotBlank(message = "사용자 ID는 필수입니다.")
    private String usrId; // 예: doa123

    // 이름
    @NotBlank(message = "이름은 필수입니다.")
    private String usrNm;

    // 비밀번호
    @NotBlank(message = "비밀번호는 필수입니다.")
    @Size(min = 6, message = "비밀번호는 최소 6자 이상이어야 합니다.")
    private String pwd;

    // 이메일 (Unique)
    @NotBlank(message = "이메일은 필수입니다.")
    @Email(message = "이메일 형식이 올바르지 않습니다.")
    private String email;

    // 깃허브/블로그 URL (Optional)
    private String introUrl;

    // 자기소개 (Optional)
    private String intro;

    // 주요 개발분야 (개발분류: 백엔드/프론트엔드/풀스텍/빅데이터/DBA/AI)
    @NotBlank(message = "주요 개발 분야는 필수입니다.")
    private String mainDev;

    // 경력 공개 여부 (기본값 'N')
    private String careerOpenYn = "N";

    // 탈퇴 여부 (기본값 'N') - 회원가입 시 굳이 입력 안 받아도 됨
    private String delYn = "N";

    // 생성자, getter/setter 생략 가능 (Lombok 쓰면 @Data 등으로 처리)
}
