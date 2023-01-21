-- Barcelone
insert into player(team_id,id,name,number,is_guardian) values (1,1,'ter stegen',1,true);
insert into player(team_id,id,name,number) values (1,2,'christensen',15);
insert into player(team_id,id,name,number) values (1,3,'araujo',4);
insert into player(team_id,id,name,number) values (1,4,'alonso',17);
insert into player(team_id,id,name,number) values (1,5,'alba',18);
insert into player(team_id,id,name,number) values (1,6,'roberto',20);
insert into player(team_id,id,name,number) values (1,7,'kounde',23);
insert into player(team_id,id,name,number) values (1,8,'busquets',5);
insert into player(team_id,id,name,number) values (1,9,'ansu fati',10);
insert into player(team_id,id,name,number) values (1,10,'kessie',19);
insert into player(team_id,id,name,number) values (1,11,'pedri',8);

-- Real Madrid
insert into player(team_id,id,name,number,is_guardian) values (2,12,'courtois',1,true);
insert into player(team_id,id,name,number) values (2,13,'vini jr',20);
insert into player(team_id,id,name,number) values (2,14,'carvajal',2);
insert into player(team_id,id,name,number) values (2,15,'militao',3);
insert into player(team_id,id,name,number) values (2,16,'alaba',4);
insert into player(team_id,id,name,number) values (2,17,'mendi',23);
insert into player(team_id,id,name,number) values (2,18,'modric',10);
insert into player(team_id,id,name,number) values (2,19,'camavinga',12);
insert into player(team_id,id,name,number) values (2,20,'valverde',15);
insert into player(team_id,id,name,number) values (2,21,'benzema',9);
insert into player(team_id,id,name,number) values (2,22,'kroos',8);

create sequence player_seq as integer start 23;