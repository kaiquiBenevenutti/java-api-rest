create table usuarios(

                        id bigint not null auto_increment,
                        login varchar(100) not null,
                        senha varchar(100) not null unique,

                        primary key(id)

);