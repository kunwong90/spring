
create table `student` (
	`stu_id` int (10),
	`name` varchar (765),
	`dep_id` int (11),
	`sex` char (3),
	primary key (stu_id),
	FOREIGN KEY (dep_id) REFERENCES dept(department_id)
); 
insert into `student` (`stu_id`, `name`, `dep_id`, `sex`) values('1','张三','1','1');
insert into `student` (`stu_id`, `name`, `dep_id`, `sex`) values('2','李四','2','0');
insert into `student` (`stu_id`, `name`, `dep_id`, `sex`) values('3','王五','2','0');
insert into `student` (`stu_id`, `name`, `dep_id`, `sex`) values('4','赵六','1','1');
insert into `student` (`stu_id`, `name`, `dep_id`, `sex`) values('5','tom','1','1');
insert into `student` (`stu_id`, `name`, `dep_id`, `sex`) values('6','侯亮平','2','1');
insert into `student` (`stu_id`, `name`, `dep_id`, `sex`) values('7','侯亮平','2','0');
insert into `student` (`stu_id`, `name`, `dep_id`, `sex`) values('8','侯亮平','2','1');
