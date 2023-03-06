package com.koreait.board.dto.request.humanResource;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
// @AllArgsConstructor : 여기서는 이거 안쓴다고 함 왜 안 쓰는거지?
public class postHumanResourceRequestDto {

    // 사번빼고 전부다 복사해왔는데 사번은 왜 빼고 복사해온거지?
    
    
    // 직급 : 필수입력사항
    @NotBlank
    @Length(min=0, max=5) // 길이 설정
    private String position;

    @NotBlank
    @Length(min=0, max=10)
    private String name;

    
    @Range(min=0, max=120)
    private int age;

    @NotBlank
    @Length(min=0, max=5)
    private String gender; //? 성별
   
    

    //? 학력
    @NotBlank
    @Length(min=0, max=10)
    private String academicAbility;


    //? 생년월일
    @NotBlank
    private String birth;


    //?휴대전화번호
    @NotBlank
    private String telNumber;
   
    //? 주소
    @NotBlank
    private String address;
    
    //? 상세주소
    @NotBlank
    private String addressDetail;
    
    //? 입사일
    @NotBlank
    private String joinDate;

    //? 퇴사일
    private String resignationDate;
    
    //? 부서
    @NotBlank
    @Length(min=0, max=5)
    private String department;

    //? 연봉
    @Min(0)
    private int annualIncome;

    //? 비고
    private String note;
}
