insert into category (id, name) values (1, 'tablet');
insert into category (id, name) values (2, 'laptop');
insert into category (id, name) values (3, 'inne');

insert into role(id,role_name) values(1,'ROLE_ADMIN');
insert into role(id,role_name) values(2,'ROLE_SIMPLE_USER');
insert into department(id,name,active) values(1,'IT',1);
insert into location(id,name) values(1,'Warszawa');
insert into user(id,name,surname,login,password,department_id,active) values(1,'Patryk','Cymerman','p.cymerman','$2a$10$van592Vx5R8DGnewjUExl.G7pMSHhFHMEMMGKuBCRZiHh/NUSCXPq',1,1);
insert into user(id,name,surname,login,password,active) values(2,'Slawomir','Wodkowski','s.wodkowski','$2a$10$0xIrNanjwX14qRc.OZImA.zGIr4U2qkGg8vgWWGqxEOX702Obt7D2',1);
insert into user(id,name,surname,login,password,department_id,active) values(3,'Patryk','Cymerman','p.cymerman1','$2a$10$van592Vx5R8DGnewjUExl.G7pMSHhFHMEMMGKuBCRZiHh/NUSCXPq',1,1);

insert into user_role(user_id, role_id) values (1,1);
insert into user_role(user_id, role_id) values (2,2);
insert into user_role(user_id, role_id) values (3,2);


insert into project(id,name,project_Number) values(2,'Black',223111);
insert into project(id,name,project_Number) values(1,'Red Bull',223111);




insert into equipment(id,category_id,manufacturer,model,date_Of_Purchase,serial_Number,price,project_id,location_id,active) values(1,1,'Samsung','SM-T585',parsedatetime('17-09-2012','dd-MM-yyyy'),'CND213401',2500,2,1,1);
insert into equipment(id,category_id,manufacturer,model,date_Of_Purchase,serial_Number,price,project_id,location_id,active) values(2,1,'Samsung','SM-T285',parsedatetime('17-09-2012','dd-MM-yyyy'),'CND312445',1500,2,1,1);
insert into equipment(id,category_id,manufacturer,model,date_Of_Purchase,serial_Number,price,project_id,location_id,active) values(3,1,'Apple','IPadMini4',parsedatetime('17-09-2012','dd-MM-yyyy'),'CND312445',1700,2,1,1);
insert into equipment(id,category_id,manufacturer,model,date_Of_Purchase,serial_Number,price,active) values(4,2,'Lenovo','y510p',parsedatetime('17-09-2012','dd-MM-yyyy'),'CND2fs31114',3500,1);
insert into equipment(id,category_id,manufacturer,model,date_Of_Purchase,serial_Number,price,project_id,location_id,active) values(5,2,'Samsung','SX2241',parsedatetime('17-09-2012','dd-MM-yyyy'),'CND213554',2500,2,1,1);
insert into equipment(id,category_id,manufacturer,model,date_Of_Purchase,serial_Number,price,project_id,location_id,active) values(6,2,'Apple','MacBook Pro',parsedatetime('17-09-2012','dd-MM-yyyy'),'DFE2351',5500,2,1,1);
insert into equipment(id,category_id,manufacturer,model,date_Of_Purchase,serial_Number,price,project_id,location_id,active) values(7,3,'Samsung','SX300',parsedatetime('17-09-2012','dd-MM-yyyy'),'CND213401',1500,2,1,1);
insert into equipment(id,category_id,manufacturer,model,date_Of_Purchase,serial_Number,price,project_id,location_id,active) values(8,3,'Samsung','CE3210',parsedatetime('17-09-2012','dd-MM-yyyy'),'CND213401',4500,2,1,1);
insert into equipment(id,category_id,manufacturer,model,date_Of_Purchase,serial_Number,price,project_id,location_id,active) values(9,3,'LG','W2231',parsedatetime('17-09-2012','dd-MM-yyyy'),'CND213401',500,2,1,1);
insert into equipment(id,category_id,manufacturer,model,date_Of_Purchase,serial_Number,price,project_id,location_id,active) values(10,2,'Lenovo','y510p',parsedatetime('17-09-2012','dd-MM-yyyy'),'CND2fs31114',3500,2,1,1);
insert into equipment(id,category_id,manufacturer,model,date_Of_Purchase,serial_Number,price,project_id,location_id,active) values(11,2,'Lenovo','y510p',parsedatetime('17-09-2012','dd-MM-yyyy'),'CND2fs31114',3500,2,1,1);

insert into ownership(id,user_id,equipment_id,allocation_Start_Date,project_id,location_id) values(1,1,4,parsedatetime('17-09-2012','dd-MM-yyyy'),1,1);
insert into ownership(id,user_id,equipment_id,allocation_Start_Date,) values(2,1,5,parsedatetime('17-09-2012','dd-MM-yyyy'));
insert into ownership(id,user_id,equipment_id,allocation_Start_Date, allocation_End_Date) values(3,1,6,parsedatetime('17-09-2012','dd-MM-yyyy'),parsedatetime('20-09-2012','dd-MM-yyyy'));
insert into ownership(id,user_id,equipment_id,allocation_Start_Date, allocation_End_Date) values(4,1,10,parsedatetime('17-09-2012','dd-MM-yyyy'),parsedatetime('20-09-2012','dd-MM-yyyy'));
insert into ownership(id,user_id,equipment_id,allocation_Start_Date, allocation_End_Date) values(5,1,11,parsedatetime('17-09-2012','dd-MM-yyyy'),parsedatetime('20-09-2012','dd-MM-yyyy'));