package com.koreait.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.board.common.constant.ResponseMessage;
import com.koreait.board.dto.request.humanResource.PostHumanResourceRequestDto;
import com.koreait.board.dto.request.humanResource.PostHumanResourceResponseDto;
import com.koreait.board.dto.response.ResponseDto;
import com.koreait.board.dto.response.humanResource.GetHumanResourceResponseDto;
import com.koreait.board.entity.EmployeeEntity;
import com.koreait.board.repository.DepartmentRepository;
import com.koreait.board.repository.EmployeeRepository;



@Service
public class HumanResourceService {
    
    @Autowired private EmployeeRepository employeeRepository;
    @Autowired private DepartmentRepository departmentRepository;


    public ResponseDto<PostHumanResourceResponseDto> postHumanResource(PostHumanResourceRequestDto dto){

        PostHumanResourceResponseDto data = null;

        String telNumber = dto.getTelNumber();
        String departmentCode = dto.getDepartment(); // 얘가 입력이 되지 않았다면 null이 들어온다고 함 (필수 해제를 하면 / 당연히 null이 들어옴)

        try{
            boolean hasTelNumber = employeeRepository.existsByTelNumber(telNumber);
            if (hasTelNumber) return ResponseDto.setFail(ResponseMessage.EXIST_PHONE_NUMBER);

            if(departmentCode != null){ // 부서코드가 null이 아니라면이라는 의미
                boolean hasDepartment = departmentRepository.existsById(departmentCode); // 입력한 부서코드가 우리가 관리하고 있는 부서코드인지 확인하는건 어디 테이블에서 가져오냐? Department 테이블에서 가져와야함
                if(!hasDepartment) return ResponseDto.setFail(ResponseMessage.NOT_EXIST_DEPARTMENT_CODE); // 존재하지 않는다면 그런 부서코드가 없다고 에러메세지 던져주기
            }

            EmployeeEntity employeeEntity = new EmployeeEntity(dto); 
            employeeRepository.save(employeeEntity);

            data = new PostHumanResourceResponseDto(employeeEntity);


        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFail(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess("success", data);
    }

    public ResponseDto<GetHumanResourceResponseDto> getHumanResource(int employeeNumber){

        GetHumanResourceResponseDto data = null;

        try{
            //boolean hasEmployee = employeeRepository.existsById(employeeNumber); // 먼저 검사해서
            //if(!hasEmployee) return ResponseDto.setFail("존재 X");
            //EmployeeEntity employeeEntity = employeeRepository.findById(employeeNumber).get();

            EmployeeEntity employeeEntity = employeeRepository.findByEmployeeNumber(employeeNumber); 
            if(employeeEntity == null) return ResponseDto.setFail(ResponseMessage.NOT_EXIST_EMPLOYEE_NUMBER);
            data = new GetHumanResourceResponseDto(employeeEntity);
        } catch (Exception exception) { // 데이터베이스에러에 대한 공간
            exception.printStackTrace();
            return ResponseDto.setFail(ResponseMessage.DATABASE_ERROR); // 위에 try catch에서는 Database Error라고 적었는데 여기서는 Data error라고 적은 이유는 같
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

}
