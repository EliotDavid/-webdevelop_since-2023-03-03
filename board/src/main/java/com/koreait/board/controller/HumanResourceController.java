package com.koreait.board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.board.dto.request.humanResource.postHumanResourceRequestDto;
import com.koreait.board.dto.request.humanResource.postHumanResourceResponseDto;
import com.koreait.board.dto.response.ResponseDto;
import com.koreait.board.service.HumanResourceService;

@RestController // 이렇게 써주면 서버사이드 렌더링을 할 때 쓰는 컨트롤러라고 함 
            // 우리는 웹서버 따로 만들고 was 따로 만들고 database 따로 만드는데 
            // 화면에 controller 해주는거를 react로 따로 만들어 관리하는 것을 csr이라고 함
            
            //일반 Controller는 GetMapping 으로 접근했을 때 html 파일로 뿌려주려고 할 때 쓰는거고
            // 지금은 다른 방식으로 뷰에 쏘아주는 구조를 짜고 있어서 RestController를 써야함

@RequestMapping("/apis/hr") // 특정한 패턴에 대해서 요청받을 적에 이 단위로 처리하겠다는 어노테이션
public class HumanResourceController {
    
    @Autowired private HumanResourceService humanResourceService;
    
    @PostMapping("/") // 이건 왜 바로 post로 받는거지? 먼저 getmaaping()에서 ()안의 url로 접속하면 getmapping메서드가 실행되어서 그 메서드의 return값으로 회원가입을 입력할 수 있는 페이지로 return해주고 그 다음 클라이언트가 회원가입 입력사항을 다 입력하면 각 변수들을 인자로 post로 받아서 postmapping된 메서드가 실행되는거 아닌가? 
    public ResponseDto<postHumanResourceResponseDto> postHumanResource(@Valid @RequestBody postHumanResourceRequestDto requestbody){ // 클라이언트로부터 받을 데이터를 인자에 넣어주면 됨
                                 // 클라이언트에게 돌려줄 자리 : return
                                 // post를 통해서 들어오면(입력받으면) request라하는 body에 담아져서 들어온다고 함
                                 // get은 url에 붙어서 들어옴
                                 // 
        ResponseDto<postHumanResourceResponseDto> response = humanResourceService.postHumanResource(requestbody);

        return response;

    }

}
