package com.orbitRise.backend.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "USR")
public class Usr {

    @Id
    private String usrId;       //영문명 /사용자 ID

    @Column(nullable = false)
    private String usrNm;       //사용자 이름

    @Column(nullable = false)
    private String pwd;         //비밀번호

    @Column(nullable = false)
    private String email;       //이메일

    @Column(nullable = false)
    private String introUrl;    //깃허브나 블로그

    @Column(nullable = false)
    private String intro;       //자기소개

    @Column(nullable = false)
    private String mainDev;     //개발분류  : 백엔드/프론트엔드/풀스텍/빅데이터/DBA/AI

    @Column(nullable = false)
    private String careerOpenYn;//경력 공개여부 Y/N

    @Column(nullable = false)
    private LocalDateTime regDtm;      //

    @Column(nullable = false)
    private LocalDateTime updDtm;      //

    @Column(nullable = false)
    private String delYn;       //탈퇴 여부 Y/N

    @PrePersist
    public void onCreate() {
        this.regDtm = LocalDateTime.now();
        this.updDtm = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.updDtm = LocalDateTime.now();
    }

    public String getUsrId() {
        return usrId;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    public String getUsrNm() {
        return usrNm;
    }

    public void setUsrNm(String usrNm) {
        this.usrNm = usrNm;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIntroUrl() {
        return introUrl;
    }

    public void setIntroUrl(String introUrl) {
        this.introUrl = introUrl;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getMainDev() {
        return mainDev;
    }

    public void setMainDev(String mainDev) {
        this.mainDev = mainDev;
    }

    public String getCareerOpenYn() {
        return careerOpenYn;
    }

    public void setCareerOpenYn(String careerOpenYn) {
        this.careerOpenYn = careerOpenYn;
    }

    public LocalDateTime getRegDtm() {
        return regDtm;
    }

    public void setRegDtm(LocalDateTime regDtm) {
        this.regDtm = regDtm;
    }

    public LocalDateTime getUpdDtm() {
        return updDtm;
    }

    public void setUpdDtm(LocalDateTime updDtm) {
        this.updDtm = updDtm;
    }

    public String getDelYn() {
        return delYn;
    }

    public void setDelYn(String delYn) {
        this.delYn = delYn;
    }
}
