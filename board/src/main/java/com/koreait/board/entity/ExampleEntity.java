package com.koreait.board.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//# @Entity(name="엔티티명")
//? 데이터베이스 테이블에 상응하는 Entity class를 지정해주는 어노테이션임
//? ORM이 해당 어노테이션으로 작성된 class를 특정 테이블에 매핑되도록 함
//# @Table(name="테이블명")
 //? 해당 Entity의 테이블명을 지정하기 위한 어노테이션
 //? @Table을 추가하지 않으면 @Entity의 엔티티명을 따라 테이블명을 지정함 
//# @Builder
//? 빌더 패턴을 생성해주는 lombok 어노테이션
///? 빌더 패턴 : 생성자로 특정한 필드를 지정해서 지정된 필드들만 초기화하는 것이 아니고 생성하는 순간에 초기화할 필드를 지정해서 인스턴스를 생성해주는 패턴임
//? 사용방법 : 클래스명.builder().필드명(초기화할 데이터)[...].build(); 


@Table(name = "Example") 
@Entity(name = "Example") 
@Data // Getter, Setter, 생성자를 대체하는 어노테이션이라는데 맞나?
@Builder
@NoArgsConstructor // Bean 생성자를 만들었다는 뜻이라고 하는데 무슨 말인지 잘 모르겠음
@AllArgsConstructor 
public class ExampleEntity {
    

    //# @ID 
    //? 해당 필드를 Primary Key로 지정함
    @Id
    //# @GenerateValue(...)
    //? 필드의 값을 자동으로 생성해주기 위한 어노테이션임
    // strategy = GenerationType.IDENTITY
    //? AUTO_INCREMENT 전략 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer prime;
    private String comment;
    private int number;




}
