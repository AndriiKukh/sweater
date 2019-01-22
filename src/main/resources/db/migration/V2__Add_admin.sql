insert into usr(id, username, password, active)
    values (1, 'admin', '1215', 1);

insert into user_role(user_id, roles)
    values(1, 'USER'), (1, 'ADMIN');

update usr set password = '$2a$04$ykUZWH4WitS.tqbE4ieqf.22UYozUuxMP.TnvofyWpcIt7xopa/Fa' where usr.id=1;