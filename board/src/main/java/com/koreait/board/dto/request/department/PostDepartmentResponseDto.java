package com.koreait.board.dto.request.department;

import com.koreait.board.entity.DepartmentEntity;

public class PostDepartmentResponseDto {

    private String departmentCode;
    private String name;
    private int cheif;
    private String telNumber;
    
    public PostDepartmentResponseDto(DepartmentEntity departmentEntity) {
        this.departmentCode = departmentEntity.getDepartmentCode();
        this.name = departmentEntity.getName();
        this.cheif = departmentEntity.getCheif();
        this.telNumber = departmentEntity.getTelNumber();
    }
    
}
