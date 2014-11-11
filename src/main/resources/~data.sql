insert into authorities values(1,'ROLE_SUPERADMIN');
insert into authorities values(2,'ROLE_ADMIN');
insert into authorities values(3,'ROLE_AUDITOR');
insert into authorities values(4,'ROLE_USER');

insert into users(userid,email,password,firstname,lastname,username,enabled,roleid) values(1,'rob@example.com','password','Rob','Winch','rob',1,4);
insert into users(userid,email,password,firstname,lastname,username,enabled,roleid) values (2,'luke@example.com','password','Luke','Taylor','luke',1,4);