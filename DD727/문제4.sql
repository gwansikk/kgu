ALTER TABLE lecture
DROP COLUMN no;

/*
ORA-12992: cannot drop parent key column 
부모(상위) column은 삭제할 수 없습니다.
course에서 참조하고 있기떄문에 삭제할 수 없습니다.
*/

ALTER TABLE lecture
MODIFY no NUMBER(4);

/*
ORA-02267: column type incompatible with referenced column type 
course에서 참조되고 있기 때문에 데이터 타입을 변경할 수 없습니다.
외래키로 참조해오는 키는 데이터 타입이 일치해야합니다.
*/