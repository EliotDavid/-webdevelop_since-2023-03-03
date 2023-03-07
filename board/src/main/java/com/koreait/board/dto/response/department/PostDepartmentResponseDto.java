package com.koreait.board.dto.response.department;

import com.koreait.board.entity.DepartmentEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDepartmentResponseDto {
    
    private String departmentCode;
    private String name;
    private int chief;
    private String telNumber;


    // 그리고 생성자 하나 추가로 만듬
    // 그리고 ()에다가 DepartmentEntity를 넣어줌 

    public PostDepartmentResponseDto(DepartmentEntity departmentEntity){
        this.departmentCode = departmentEntity.getDepartmentCode();
        this.name = departmentEntity.getName();
        this.chief = departmentEntity.getCheif();
        this.telNumber = departmentEntity.getTelNumber();
    }
}
