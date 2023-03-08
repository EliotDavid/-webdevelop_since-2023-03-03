package com.koreait.board.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.koreait.board.dto.request.department.PostDepartmentRequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // 보통 엔티티에는 게터만 존재하고 세터는 넣을 수 없는거로 알고 있었는데 데이터베이스에서 엔티티에 접근해서 그 엔티티의 정보들을 갖고 와서 비교하려고 할 때, 어쨌든 엔티티의 정보와 일치하는지 확인하려고 할 때는 
      // 무조건 게터가 있어야되는거고 그리고 변경사항이 있을 때도 엔티티에도 적용시켜줘야되기 때문에 엔티티에도 결국 생성자로 엔티티의 필드변수에 값을 변경을 하든 뭘 하든 세터의 기능과 동일하기 때문에 
      // 세터의 기능이 적용되어있다고 볼 수 있어서 엔티티에도 세터가 있어야함 
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DepartmentEntity {
    @Id // PK에게 걸어주는 어노테이션
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String departmentCode; //? 부서코드
    //? 부서명
    private String name;
    //? 부서장 이름 
    private int cheif;
    //? 부서전화번호
    private String telNumber;

    public DepartmentEntity(PostDepartmentRequestDto dto){
        this.departmentCode = dto.getDepartmentCode();
        this.name = dto.getName();
        this.cheif = dto.getCheif();
        this.telNumber = dto.getTelNumber();
    }    
}
