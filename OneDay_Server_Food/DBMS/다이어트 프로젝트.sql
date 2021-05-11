-- food

CREATE TABLE tbl_foods(
fd_code	CHAR(7)		PRIMARY KEY,
fd_seq	nVARCHAR2(200)	NOT NULL,	
fd_date	CHAR(4)	NOT NULL	,
fd_ccode	CHAR(6)	NOT NULL,	
fd_icdoe	CHAR(4)	NOT NULL,	
fd_one	NUMBER	NOT NULL	,
fd_gram	NUMBER	NOT NULL	,
fd_kcal	NUMBER	NOT NULL	,
fd_prot	NUMBER	NOT NULL	,
fd_fat	NUMBER	NOT NULL	,
fd_carbo	NUMBER	NOT NULL,	
fd_sacc	NUMBER	NOT NULL	
);

CREATE TABLE tbl_company(
cp_code	CHAR(6)		PRIMARY KEY,
cp_name	nVARCHAR2(125)	NOT NULL	
);

CREATE TABLE tbl_items(
it_code	CHAR(4)		PRIMARY KEY,
it_name	nVARCHAR2(125)	NOT NULL	
);

ALTER TABLE tbl_foods
ADD CONSTRAINT fk_ccode
FOREIGN KEY (fd_ccode)
REFERENCES tbl_company(cp_code);

ALTER TABLE tbl_foods
ADD CONSTRAINT fk_icode
FOREIGN KEY (fd_icode)
REFERENCES tbl_items(it_code); -- FOREIGN KEY 설정


CREATE VIEW view_식품정보 AS
(
SELECT 
    FD.fd_code AS 식품코드,
    FD.fd_name AS 식품명,
    FD.fd_date AS 출시연도,
    FD.fd_ccode AS 제조사코드,
    CP.cp_name AS 제조사명,
    FD.fd_icode AS 분류코드,
    IT.it_name AS 분류명,
    FD.fd_one AS 회제공량,
    FD.fd_gram AS 총내용량,
    FD.fd_kcal AS 칼로리,
    FD.fd_prot AS 단백질,
    FD.fd_fat AS 지방,
    FD.fd_carbo AS 탄수화물,
    FD.fd_sacc AS 총당류 
FROM tbl_foods FD
    LEFT JOIN tbl_company CP ON FD.fd_ccode = cp.cp_code
    LEFT JOIN tbl_items IT ON FD.fd_icode = it.it_code
);   

CREATE TABLE tbl_myfoods(
mf_seq NUMBER PRIMARY KEY,
mf_date VARCHAR2(10) NOT NULL,
mf_icode CHAR(7) NOT NULL,
mf_qty cHAR(3) NOT NULL
);

ALTER TABLE tbl_myfoods
ADD CONSTRAINT fk_myfoods_icode
FOREIGN KEY (mf_icode)
REFERENCES tbl_foods(fd_code);

ALTER TABLE tbl_myfoods
DROP CONSTRAINT fk_myfoods_icode;



CREATE SEQUENCE seq_myfoods -- seq_적용대상테이블명
START WITH 1 -- 시작값
INCREMENT BY 1;

CREATE VIEW view_섭취정보 AS
(
SELECT 
    MF.mf_date AS 날짜,
    FD.fd_name AS 식품명,
    MF.mf_qty AS 섭취량,
    FD.fd_gram AS 총내용량,
    FD.fd_kcal AS 칼로리,
    FD.fd_prot AS 단백질,
    FD.fd_fat AS 지방,
    FD.fd_carbo AS 탄수화물,
    FD.fd_sacc AS 총당류 
FROM tbl_myfoods MF
    LEFT JOIN tbl_foods FD ON MF.mf_icode = FD.fd_code    
);   

DROP VIEW view_섭취정보;

SELECT
    *
FROM view_섭취정보;
