create table public.user(
    id bigserial,
    login varchar(100),
    password varchar(100),
    first_name varchar(100),
    last_name varchar(100)
);

insert into public.user(login, password, first_name, last_name)
values('admin', '123', 'admin', 'admin');