create database OA2;
use OA2;
create table INFOSOURCES(
	id int primary key auto_increment,
	name varchar(100) not null unique,
	description varchar(255)
);
create table CUSTOMERSTATUS(
	id int primary key auto_increment,
	name varchar(100) not null unique,
	description varchar(255)
);
create table CLASSTYPES(
	id int primary key auto_increment,
	name varchar(100) not null unique,
	description varchar(255)
);
create table CLASSES(
	id int primary key auto_increment,
	name varchar(100) not null unique,
	startDate date,
	endDate date,
	planNumber int,
	number int,
	actualNumber int,
	status varchar(100),
	classTypeId int,
	constraint classType_id_fk foreign key(classTypeId) references CLASSTYPES(id)
);
create table CUSTOMERS(
	id int primary key auto_increment,
	name varchar(100) not null,
	phoneNumber varchar(20) not null unique,
	gender varchar(10),
	qq varchar(20) not null unique,
	email varchar(100) not null unique,
	address varchar(255),
	status varchar(100),
	classType varchar(100),
	infoSource varchar(100),
	message varchar(500),
	actived bit(1),
	activeCode varchar(100),
	activeDate date
);
create table APPLYS(
	number varchar(100) primary key,
	title varchar(100) not null,
	startDate date,
	endDate date,
	closed bit(1),
	successed bit(1),
	status varchar(100),
	totalGrade float(8,2),
	classesId int,
	customerId int,
	constraint classesId_id_fk foreign key(classesId) references CLASSES(id),
	constraint customerId_id_fk foreign key(customerId) references CUSTOMERS(id)
);
create table RESUMEAPPLY(
	number varchar(100) primary key,
	title varchar(100) not null,
	upTime date,
	status varchar(100),
	checkDate date,
	checker varchar(100),
	grade float(8,2),
	path varchar(100),
	filename varchar(100),
	oldFilename varchar(100),
	message varchar(500),
	constraint number_id_fk1 foreign key(number) references APPLYS(number)
);
create table BASETESTAPPLY(
	number varchar(100) primary key,
	title varchar(100) not null,
	upTime date,
	status varchar(100),
	checkDate date,
	checker varchar(100),
	grade float(8,2),
	path varchar(100),
	filename varchar(100),
	oldFilename varchar(100),
	message varchar(500),
	constraint number_id_fk2 foreign key(number) references APPLYS(number)
);
create table QUOTAAPPLY(
	number varchar(100) primary key,
	checkDate date,
	checker varchar(100),
	checkMessage varchar(500),
	constraint number_id_fk3 foreign key(number) references APPLYS(number)
);
#与权限有关
create table users(
	id int primary key auto_increment,
	username varchar(100) not null unique,
	password varchar(100) not null,
	nickname varchar(100) not null
);
create table roles(
	id int primary key auto_increment,
	name varchar(100) not null unique,
	description varchar(100)
);
create table user_role(
	u_id int,
	r_id int,
	primary key(u_id,r_id),
	constraint u_id_fk foreign key(u_id) references users(id),
	constraint r_id_fk1 foreign key(r_id) references roles(id)
);
create table functions(
	id int primary key auto_increment,
	name varchar(100) not null unique,
	uri varchar(500)
);
create table role_function(
	r_id int,
	f_id int,
	primary key(r_id,f_id),
	constraint r_id_fk2 foreign key(r_id) references roles(id),
	constraint f_id_fk foreign key(f_id) references functions(id)
);