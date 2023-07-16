CREATE TABLE USERS (
    id_user bigint not null auto_increment,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    age int not null,
    cpf varchar(14) not null,
    wallet float not null,
    add_value_to_wallet float not null,
    primary key (id_user)
) engine=InnoDB default charset=utf8;