delete from import_slip;
delete from export_slip;
delete from product_in_slip;
delete from slip;
delete from product;
delete from employee;
delete from agent;
delete from supplier;

insert into product (id, name, description, price, quantity)
    values(1, 'sp1', 'sp1', 10, 100);
insert into product (id, name, description, price, quantity)
    values(2, 'sp2', 'sp2', 20, 200);
insert into product (id, name, description, price, quantity)
    values(3, 'sp3', 'sp3', 30, 300);

insert into employee (id, username, password, name, date_of_birth, email, phone)
    values(1, 'admin1', '123456', 'tqh', STR_TO_DATE('23-09-2001', '%d-%m-%Y'), 'tqh@gmail.com', '0388');
insert into employee (id, username, password, name, date_of_birth, email, phone)
    values(2, 'admin2', '123456', 'dtc', STR_TO_DATE('3-4-2003', '%d-%m-%Y'), 'dtc@gmail.com', '3360');

insert into agent (id, name, email, phone)
    values(1, 'daily1', 'daily1@gmail.com', '0345');
insert into agent (id, name, email, phone)
    values(2, 'daily2', 'daily2@gmail.com', '0356');

insert into supplier (id, name, email, phone)
    values(1, 'ncc1', 'ncc1@gmail.com', '0123');
insert into supplier (id, name, email, phone)
    values(2, 'ncc2', 'ncc2@gmail.com', '0234');