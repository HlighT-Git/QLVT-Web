create table if not exists product (
    id int not null AUTO_INCREMENT,
    name varchar(255) not null,
    description varchar(255),
    price float not null,
    quantity int not null,
    PRIMARY KEY (id)
);
alter table product AUTO_INCREMENT = 1;

create table if not exists employee (
    id int not null AUTO_INCREMENT,
    username varchar(25) not null unique,
    password varchar(50) not null,
    name varchar(50) not null,
    date_of_birth date not null,
    email varchar(255) not null unique,
    phone varchar(15) not null unique,
    PRIMARY KEY (id)
);
alter table employee AUTO_INCREMENT = 1;

create table if not exists agent (
    id int not null AUTO_INCREMENT,
    name varchar(255) not null,
    email varchar(255) not null unique,
    phone varchar(15) not null unique,
    PRIMARY KEY (id)
);
alter table agent AUTO_INCREMENT = 1;

create table if not exists supplier (
    id int not null AUTO_INCREMENT,
    name varchar(255) not null,
    email varchar(255) not null unique,
    phone varchar(15) not null unique,
    PRIMARY KEY (id)
);
alter table supplier AUTO_INCREMENT = 1;

create table if not exists slip (
    id int not null AUTO_INCREMENT,
    created_time timestamp not null,
    total_cost float not null,
    PRIMARY KEY (id)
);
alter table slip AUTO_INCREMENT = 1;

create table if not exists import_slip (
    id int not null,
    supplier_id int not null,
    FOREIGN KEY (id) REFERENCES slip(id),
    FOREIGN KEY (supplier_id) REFERENCES supplier(id),
    PRIMARY KEY (id)
);

create table if not exists export_slip (
    id int not null,
    agent_id int not null,
    FOREIGN KEY (id) REFERENCES slip(id),
    FOREIGN KEY (agent_id) REFERENCES agent(id),
    PRIMARY KEY (id)
);

create table if not exists product_in_slip (
    id int not null AUTO_INCREMENT,
    slip_id int not null,
    product_id int not null,
    quantity int not null,
    FOREIGN KEY (slip_id) REFERENCES slip(id),
    FOREIGN KEY (product_id) REFERENCES product(id),
    PRIMARY KEY (id)
);
alter table slip AUTO_INCREMENT = 1;