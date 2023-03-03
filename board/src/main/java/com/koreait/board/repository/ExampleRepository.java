package com.koreait.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.board.entity.ExampleEntity;


//# @Repository : 해당 인터페이스를 Repository로 사용하도록 지정하는 어노테이션임
//? JpaRepository<T, ID> : 해당 인터페이스를 상속 받은 인터페이스를 JPA Query Creation을 사용할 수 있또록 하는 인터페이스
//? T : 데이터베이스의 테이블을 구현한 Entity class
//? ID : 해당 Entity의 Primary Key의 타입
@Repository
public interface ExampleRepository extends JpaRepository<ExampleEntity, Integer>{ // 두번째자리 : ExampleEntity의 PK를 적어야하는데 제네릭에는 기본 데이터타입을 쓸 수 없어서 Integer를 적어야함
    
    //? 추상메서드로 쿼리실행문을 작성할 수 있음
    //? 메서드명을 규칙에 따라 작성하게 되면 JpaRepository가 알아서 SQL을 작성하고 실행함
    public ExampleEntity findByComment(String comment); // SELECT * FROM 과 같은 의미임 // Comment기준으로 찾겠다는 뜻임 // public 뒤의 ExampleEntity : 반환타입임
}
