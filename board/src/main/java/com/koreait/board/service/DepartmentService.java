package com.koreait.board.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.board.common.constant.ResponseMessage;
import com.koreait.board.dto.request.department.PostDepartmentRequestDto;
import com.koreait.board.dto.request.department.PostDepartmentResponseDto;
import com.koreait.board.dto.response.ResponseDto;
import com.koreait.board.dto.response.department.GetAllDepartmentListResponseDto;
import com.koreait.board.entity.DepartmentEntity;
import com.koreait.board.entity.EmployeeEntity;
import com.koreait.board.repository.DepartmentRepository;
import com.koreait.board.repository.EmployeeRepository;

@Service
public class DepartmentService {

    @Autowired EmployeeRepository employeeRepository;
    @Autowired public DepartmentRepository departmentRepository;
    
    public ResponseDto<PostDepartmentResponseDto> postDepartment(PostDepartmentRequestDto dto){

        
        PostDepartmentResponseDto data = null;
        int chiefEmployeeNumber = dto.getCheif(); // chief는 부서장 아닌가?
        try{
            // 입력된 사번이 존재하는지 안 하는지부터 검증해줘야됨
            boolean hasEmployee = employeeRepository.existsById(chiefEmployeeNumber); // 여기서 chiefEmployeeNumber가 뭘 의미하는거지?
            if(!hasEmployee) return ResponseDto.setFail(ResponseMessage.NOT_EXIST_EMPLOYEE_NUMBER);

            DepartmentEntity departmentEntity = new DepartmentEntity(dto);
            departmentRepository.save(departmentEntity);
            data = new PostDepartmentResponseDto(departmentEntity);
        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFail(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    public ResponseDto<List<GetAllDepartmentListResponseDto>> getAllDepartmentList(){
        
        List<GetAllDepartmentListResponseDto> data = new ArrayList<GetAllDepartmentListResponseDto>();

        try{
            
            List<DepartmentEntity> departmentList = departmentRepository.findAll(); // 얘는 전체 다 반환해주는 애임
            data = GetAllDepartmentListResponseDto.copyList(departmentList); 
           
        } catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.setFail(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

}
