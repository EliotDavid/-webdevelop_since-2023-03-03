CREATE TABLE Employee(
	employee_number INT AUTO_INCREMENT PRIMARY KEY COMMENT '사번',
    position VARCHAR(10) NOT NULL COMMENT '부서',
    name VARCHAR(20) NOT NULL COMMENT '이름', 
    age INT NOT NULL COMMENT '나이',
    gender VARCHAR(10) NOT NULL COMMENT '성별',
    academic_ability VARCHAR(20) NOT NULL COMMENT '학력',
    birth DATE NOT NULL COMMENT '생년월일',
    tel_number VARCHAR(15) NOT NULL UNIQUE COMMENT '휴대전화번호',
    address TEXT NOT NULL COMMENT '주소',
    address_detail TEXT NOT NULL COMMENT '상세주소',
    join_date DATE NOT NULL COMMENT '입사일',
    resignation_date DATE COMMENT '퇴사일',
    department VARCHAR(45) DEFAULT '미정' COMMENT '부서',
    annual_income INT NOT NULL COMMENT '연봉',
    note TEXT COMMENT '비고'
);

-- Department (department_code, name, cheif, tel_number)

CREATE TABLE Department(
	department_code VARCHAR(5) PRIMARY KEY COMMENT '부서코드',
    name VARCHAR(100) NOT NULL COMMENT '부서명',
    cheif INT NOT NULL COMMENT '부서장',
    tel_number VARCHAR(15) NOT NULL COMMENT '부서전화번호',
    
    CONSTRAINT department_fk_cheif -- 제약조건명을 적어줄 땐 CONSTRAINT + 제약조건명 
    FOREIGN KEY (cheif) -- 어떠한 키를 외래키로 쓸것이냐? () 안에 있는 필드가 외래키로 쓸거임
    REFERENCES Employee (employee_number) -- 참조할 테이블명 + 그 테이블에서 참조할 필드명
);

ALTER TABLE Employee MODIFY COLUMN department VARCHAR(5) COMMENT '부서코드';  

ALTER TABLE Employee ADD CONSTRAINT employee_fk_department -- Employee 테이블 안에 제약조건을 하나 추가하는데 제약조건이름은 다음과 같다
FOREIGN KEY (department) 
REFERENCES Department (department_code);
