insert into users(username, password, enabled) values ('medico', '{noop}medico1', true);
insert into users(username, password, enabled) values ('paciente', '{noop}paciente1', true);
insert into authorities(username, authority) values ('medico', 'ROLE_MEDICO');
insert into authorities(username, authority) values ('paciente', 'ROLE_PACIENTE');