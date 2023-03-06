package com.koreait.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.board.entity.EmployeeEntity;

@Repository //우리는 jpa라고 하는 orm을 쓸건데 얘 같은 경우 우리가 만든 인터페이스에 상속을 해준다고 함
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> { // 레파지토리는 인터페이스여서 클래스에서 인터페이스로 수정해줌
                                                           // 레파지토리는 jparepository로 상속해주고 얘는 제네릭을 써줘야되는데 그 제네릭은 이 레파지토리를 쓸 클래스의 이름을 쓰고, 두번쨰 인자는 그 클래스의 PK 데이터값을 써주면 됨
        public boolean existByTelNumber(String telNumber); // where조건 : telNumber / 이 메서드를 호출하면 jparepository를 통해서 옆에 employeeentity 들어가서 찾아서 
    
}
