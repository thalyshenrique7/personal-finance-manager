CREATE TABLE GOALS (
		id_goal bigint not null auto_increment,
		goal_name varchar(100) not null,
		goal_finance float not null,
		user_goals_id bigint not null,
		primary key (id_goal),
		foreign key (user_goals_id) references users (id_user) on delete cascade
) engine=InnoDB default charset=utf8;