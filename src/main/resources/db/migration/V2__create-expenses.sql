CREATE TABLE EXPENSES (
    id_expenses bigint not null,
    expenses_name varchar(50) not null,
    expenses_category varchar(50) not null,
    limit_to_spending float not null,
    expenses_value float not null,
    expenses_date timestamp not null,
    expenses_description varchar(255) not null,
    user_id bigint not null,
    primary key (id_expenses),
    foreign key (user_id) references USERS (id_user) on delete cascade
) engine=InnoDB default charset=utf8;