package com.koreait.board.dto.request.department;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 

// RequestDto에서는 AllArgs를 아예 안쓴다고 함 
// 그 이유 설명해줬는데 다시 물어보기
public class PostDepartmentRequestDto {
    
    // 이 녀석에 대해서 필수값이 입력되었는지 확인하고 길이가 맞는지 확인을 해야함
    
    @NotBlank
    @Length(min = 0, max = 5) // 데이터베이스에서 가변길이를 정해줘서 여기도 가변길이를 정해줌 : 그러면 여기서는 String(문자열)의 길이가 5이상 못 적겠네 그걸로 길이 판단해서 잘못입력했다든지 잘 입력됬다든지 판단하겠네
    private String departmentCode;
    
    @NotBlank
    @Length(min = 0, max = 50)
    private String name;

    @Min(1) // 여기는 notnull이 올 수 없다고 함 : 데이터타입이 int라서 // 제로값이 1이상으로
    private int cheif;
    
    @NotBlank
    private String telNumber;

}
