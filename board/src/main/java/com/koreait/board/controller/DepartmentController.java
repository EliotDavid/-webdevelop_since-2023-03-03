package com.koreait.board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.board.common.ApiMappingPattern;
import com.koreait.board.dto.request.department.PostDepartmentRequestDto;
import com.koreait.board.dto.request.department.PostDepartmentResponseDto;
import com.koreait.board.dto.response.ResponseDto;

@RestController
@RequestMapping(ApiMappingPattern.DEPARTMENT) // 링크 적는 곳 / 어차피 변수는 값을 불러와서 그 값이 대체함 
public class DepartmentController {
    
    //@Autowired private DepartmentService;


    private static final String POST_DEPARTMENT = "/";


    @PostMapping(POST_DEPARTMENT)
    public ResponseDto<PostDepartmentResponseDto> postDepartment(@Valid @RequestBody PostDepartmentRequestDto requestbody){
        return null;
    }

}
