create table userinfo(
	id int,
	userName varchar(40),
	userAge int,
	idCard varchar(50),
	tel varchar(50),
	city varchar(100),
	userAddress varchar(100),
	password varchar(50),
	userSex varchar(50),
	userNO varchar(50),
	balance int,
	userflag int);
create table trader(
	id int,
	trade varchar(50),
	balance int,
	dataTime varchar(50),
	userNO varchar(50),
	money int);
create table manuserInfo(
	userName varchar(40),
	password varchar(50),
	userAge int,
	idCard varchar(50),
	userSex varchar(50),
	tel varchar(50),
	city varchar(100),
	userAddress varchar(100),
	userNO varchar(50),
	balance int,
	userflag int);
create table abDetection(
	id int,
	userNO varchar(50),
	trade varchar(50),
	dataTime varchar(50),
	money int);
