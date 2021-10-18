-- Create Table with "Auto-index".
CREATE TABLE PPMSDM.STUDENT(
    ID NUMBER GENERATED BY DEFAULT AS IDENTITY,
    NAME VARCHAR2(50) NOT NULL,
    EMAIL VARCHAR2(200) NOT NULL,
    PRIMARY KEY(ID)
);

GRANT DELETE, INSERT, SELECT, UPDATE ON PPMSDM.STUDENT TO PPMSAPPL;

CREATE SYNONYM  PPMSAPPL.STUDENT FOR PPMSDM.STUDENT; 

--select distinct t.privilege from user_tab_privs t;

--
insert into ppmsdm.sales t (t.item, t.quantity, t.amount) values ('CUP', 10, 44.5); 
insert into ppmsdm.sales t (t.item, t.quantity, t.amount) values ('Jacket', 15, 7000.0f); 
delete from ppmsdm.sales t where t.id < 40;
select * from ppmsdm.sales; 
select * from ppmsdm.sales where id = 41