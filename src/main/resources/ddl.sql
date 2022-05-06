create table categoria (id integer not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB;
create table estoque (id integer not null auto_increment, descricao varchar(255), primary key (id)) engine=InnoDB;
create table funcionario (id integer not null auto_increment, cpf varchar(255), data_de_nasc datetime(6), email varchar(255), nome varchar(255), perfil varchar(255), primary key (id)) engine=InnoDB;
create table item_estoque (quantidade integer, produto_id integer not null, estoque_id integer not null, primary key (estoque_id, produto_id)) engine=InnoDB;
create table produto (id integer not null auto_increment, nome varchar(255), categoria_id integer, primary key (id)) engine=InnoDB;
alter table item_estoque add constraint FKddgajw322snfo4kxp18kqobwv foreign key (produto_id) references produto (id);
alter table item_estoque add constraint FKnsal531l2976rbhkb01yyndsg foreign key (estoque_id) references estoque (id);
alter table produto add constraint FKopu9jggwnamfv0c8k2ri3kx0a foreign key (categoria_id) references categoria (id);
create table categoria (id integer not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB;
create table estoque (id integer not null auto_increment, descricao varchar(255), primary key (id)) engine=InnoDB;
create table funcionario (id integer not null auto_increment, cpf varchar(255), data_de_nasc datetime(6), email varchar(255), nome varchar(255), perfil varchar(255), primary key (id)) engine=InnoDB;
create table item_estoque (quantidade integer, produto_id integer not null, estoque_id integer not null, primary key (estoque_id, produto_id)) engine=InnoDB;
create table produto (id integer not null auto_increment, nome varchar(255), categoria_id integer, primary key (id)) engine=InnoDB;
alter table item_estoque add constraint FKddgajw322snfo4kxp18kqobwv foreign key (produto_id) references produto (id);
alter table item_estoque add constraint FKnsal531l2976rbhkb01yyndsg foreign key (estoque_id) references estoque (id);
alter table produto add constraint FKopu9jggwnamfv0c8k2ri3kx0a foreign key (categoria_id) references categoria (id);
create table categoria (id integer not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB;
create table estoque (id integer not null auto_increment, descricao varchar(255), primary key (id)) engine=InnoDB;
create table funcionario (id integer not null auto_increment, cpf varchar(255), data_de_nasc datetime(6), email varchar(255), nome varchar(255), perfil varchar(255), primary key (id)) engine=InnoDB;
create table item_estoque (quantidade integer, produto_id integer not null, estoque_id integer not null, primary key (estoque_id, produto_id)) engine=InnoDB;
create table produto (id integer not null auto_increment, nome varchar(255), categoria_id integer, primary key (id)) engine=InnoDB;
alter table item_estoque add constraint FKddgajw322snfo4kxp18kqobwv foreign key (produto_id) references produto (id);
alter table item_estoque add constraint FKnsal531l2976rbhkb01yyndsg foreign key (estoque_id) references estoque (id);
alter table produto add constraint FKopu9jggwnamfv0c8k2ri3kx0a foreign key (categoria_id) references categoria (id);

    create table categoria (
       id integer not null auto_increment,
        nome varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table estoque (
       id integer not null auto_increment,
        descricao varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table funcionario (
       id integer not null auto_increment,
        cpf varchar(255),
        data_de_nasc datetime(6),
        email varchar(255),
        nome varchar(255),
        perfil varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table item_estoque (
       quantidade integer,
        produto_id integer not null,
        estoque_id integer not null,
        primary key (estoque_id, produto_id)
    ) engine=InnoDB;

    create table produto (
       id integer not null auto_increment,
        nome varchar(255),
        categoria_id integer,
        primary key (id)
    ) engine=InnoDB;

    alter table item_estoque 
       add constraint FKddgajw322snfo4kxp18kqobwv 
       foreign key (produto_id) 
       references produto (id);

    alter table item_estoque 
       add constraint FKnsal531l2976rbhkb01yyndsg 
       foreign key (estoque_id) 
       references estoque (id);

    alter table produto 
       add constraint FKopu9jggwnamfv0c8k2ri3kx0a 
       foreign key (categoria_id) 
       references categoria (id);

    create table categoria (
       id integer not null auto_increment,
        nome varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table estoque (
       id integer not null auto_increment,
        descricao varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table funcionario (
       id integer not null auto_increment,
        cpf varchar(255),
        data_de_nasc datetime(6),
        email varchar(255),
        nome varchar(255),
        perfil varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table item_estoque (
       quantidade integer,
        produto_id integer not null,
        estoque_id integer not null,
        primary key (estoque_id, produto_id)
    ) engine=InnoDB;

    create table produto (
       id integer not null auto_increment,
        nome varchar(255),
        categoria_id integer,
        primary key (id)
    ) engine=InnoDB;

    alter table item_estoque 
       add constraint FKddgajw322snfo4kxp18kqobwv 
       foreign key (produto_id) 
       references produto (id);

    alter table item_estoque 
       add constraint FKnsal531l2976rbhkb01yyndsg 
       foreign key (estoque_id) 
       references estoque (id);

    alter table produto 
       add constraint FKopu9jggwnamfv0c8k2ri3kx0a 
       foreign key (categoria_id) 
       references categoria (id);
create table categoria (id integer not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB;
create table estoque (id integer not null auto_increment, descricao varchar(255), primary key (id)) engine=InnoDB;
create table funcionario (id integer not null auto_increment, cpf varchar(255), data_de_nasc datetime(6), email varchar(255), nome varchar(255), perfil varchar(255), primary key (id)) engine=InnoDB;
create table item_estoque (quantidade integer, produto_id integer not null, estoque_id integer not null, primary key (estoque_id, produto_id)) engine=InnoDB;
create table produto (id integer not null auto_increment, nome varchar(255), categoria_id integer, primary key (id)) engine=InnoDB;
alter table item_estoque add constraint FKddgajw322snfo4kxp18kqobwv foreign key (produto_id) references produto (id);
alter table item_estoque add constraint FKnsal531l2976rbhkb01yyndsg foreign key (estoque_id) references estoque (id);
alter table produto add constraint FKopu9jggwnamfv0c8k2ri3kx0a foreign key (categoria_id) references categoria (id);
create table categoria (id integer not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB;
create table estoque (id integer not null auto_increment, descricao varchar(255), primary key (id)) engine=InnoDB;
create table funcionario (id integer not null auto_increment, cpf varchar(255), data_de_nasc datetime(6), email varchar(255), nome varchar(255), perfil varchar(255), primary key (id)) engine=InnoDB;
create table item_estoque (quantidade integer, produto_id integer not null, estoque_id integer not null, primary key (estoque_id, produto_id)) engine=InnoDB;
create table produto (id integer not null auto_increment, nome varchar(255), categoria_id integer, primary key (id)) engine=InnoDB;
alter table item_estoque add constraint FKddgajw322snfo4kxp18kqobwv foreign key (produto_id) references produto (id);
alter table item_estoque add constraint FKnsal531l2976rbhkb01yyndsg foreign key (estoque_id) references estoque (id);
alter table produto add constraint FKopu9jggwnamfv0c8k2ri3kx0a foreign key (categoria_id) references categoria (id);
