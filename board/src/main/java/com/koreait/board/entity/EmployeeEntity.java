package com.koreait.board.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.koreait.board.dto.request.humanResource.PostHumanResourceRequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // 게터 세터 
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Employee") // 엔티티로 쓰겠다는 것
@Table(name = "Employee") // 어떤 테이블을 가리키는가?
public class EmployeeEntity {
    @Id // 아래변수다 PK이기 때문에 ID를 걸어둬야함
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 숫자 자동 부여 어노테이션 // 오토인크리먼트되도록 지원해놨다는 뜻
    private int employeeNumber; //? 사원번호
    //? 직급
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

    
    public EmployeeEntity(PostHumanResourceRequestDto dto){
        this.position = dto.getPosition();
        this.name = dto.getName();
        this.age = dto.getAge();
        this.gender = dto.getGender();
        this.academicAbility = dto.getAcademicAbility();
        this.birth = dto.getBirth();
        this.telNumber = dto.getTelNumber();
        this.address = dto.getAddress();
        this.addressDetail = dto.getAddressDetail();
        this.joinDate = dto.getJoinDate();
        this.resignationDate = dto.getResignationDate();
        this.department = dto.getDepartment();
        this.annualIncome = dto.getAnnualIncome();
        this.note = dto.getNote();

    }



}
