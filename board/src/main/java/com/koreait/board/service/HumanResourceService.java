package com.koreait.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.board.dto.request.humanResource.postHumanResourceRequestDto;
import com.koreait.board.dto.request.humanResource.postHumanResourceResponseDto;
import com.koreait.board.dto.response.ResponseDto;
import com.koreait.board.entity.EmployeeEntity;
import com.koreait.board.repository.DepartmentRepository;
import com.koreait.board.repository.EmployeeRepository;

@Service
public class HumanResourceService {
    
    @Autowired private EmployeeRepository employeeRepository;
    @Autowired private DepartmentRepository departmentRepository;


    public ResponseDto<postHumanResourceResponseDto> postHumanResource(postHumanResourceRequestDto dto){

        String telNumber = dto.getTelNumber();

        try{
            boolean hasTelNumber = employeeRepository.existByTelNumber(telNumber);
            if (hasTelNumber) return ResponseDto.setFail("Existed Telephone Number");

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFail("Database Error!");
        }

        postHumanResourceResponseDto data = new postHumanResourceResponseDto();

        return ResponseDto.setSuccess("success", data);
    }

}
