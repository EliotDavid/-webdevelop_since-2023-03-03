package com.koreait.board.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.board.common.ApiMappingPattern;
import com.koreait.board.dto.request.department.PostDepartmentRequestDto;
import com.koreait.board.dto.request.department.PostDepartmentResponseDto;
import com.koreait.board.dto.response.ResponseDto;
import com.koreait.board.dto.response.department.GetAllDepartmentListResponseDto;
import com.koreait.board.service.DepartmentService;

@RestController
@RequestMapping(ApiMappingPattern.DEPARTMENT) // 링크 적는 곳 / 어차피 변수는 값을 불러와서 그 값이 대체함 
public class DepartmentController {
    
    @Autowired private DepartmentService departmentService;


    private static final String POST_DEPARTMENT = "/";
    private static final String GET_ALL_DEPARTMENT_LIST = "/all";
    // POST http://localhost:4040/apis/department/
    @PostMapping(POST_DEPARTMENT)
    public ResponseDto<PostDepartmentResponseDto> postDepartment(@Valid @RequestBody PostDepartmentRequestDto requestbody){
        ResponseDto<PostDepartmentResponseDto> response = departmentService.postDepartment(requestbody);
        return response;
    }

    @GetMapping(GET_ALL_DEPARTMENT_LIST)
    public ResponseDto<List<GetAllDepartmentListResponseDto>> getAllDepartmentList(){ // List는 java.util에 있는거 import해야함
        ResponseDto<List<GetAllDepartmentListResponseDto>> response = departmentService.getAllDepartmentList();
        return response; 

    }

}
