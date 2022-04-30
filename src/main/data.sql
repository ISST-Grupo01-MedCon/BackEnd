insert into users(username, password, enabled) values ('alumno', '{noop}alumno1', true);
insert into users(username, password, enabled) values ('profesor', '{noop}profesor1', true);
insert into authorities(username, authority) values ('alumno', 'ROLE_ALUM');
insert into authorities(username, authority) values ('profesor', 'ROLE_PROF');