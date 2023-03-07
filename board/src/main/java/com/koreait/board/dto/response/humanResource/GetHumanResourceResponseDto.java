package com.koreait.board.dto.response.humanResource;

import com.koreait.board.entity.EmployeeEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetHumanResourceResponseDto { // 반환형 DtO
    private int employeeNumber;
    
    private String position;

  
    
    private String name;

    
    private int age;

   
   
    private String gender; //? 성별
   
    

    //? 학력
    
    
    private String academicAbility;


    //? 생년월일

    private String birth;


    //?휴대전화번호
    
    private String telNumber;
   
    //? 주소
   
    private String address;
    
    //? 상세주소
    
    private String addressDetail;
    
    //? 입사일
    
    private String joinDate;

    //? 퇴사일
    private String resignationDate;
    
    //? 부서
    
   
    private String department;

    //? 연봉
  
    private int annualIncome;

    //? 비고
    private String note;



    public GetHumanResourceResponseDto(EmployeeEntity employeeEntity){
        this.employeeNumber = employeeEntity.getEmployeeNumber();
        this.position = employeeEntity.getPosition();
        this.name = employeeEntity.getName();
        this.age = employeeEntity.getAge();
        this.gender = employeeEntity.getGender();
        this.academicAbility = employeeEntity.getAcademicAbility();
        this.birth = employeeEntity.getBirth();
        this.telNumber = employeeEntity.getTelNumber();
        this.address = employeeEntity.getAddress();
        this.addressDetail = employeeEntity.getAddressDetail();
        this.joinDate = employeeEntity.getJoinDate();
        this.resignationDate = employeeEntity.getResignationDate();
        this.department = employeeEntity.getDepartment();
        this.annualIncome = employeeEntity.getAnnualIncome();
        this.note = employeeEntity.getNote();
    }
}
