insert into cozinha (nome) values ('Tailandesa');
insert into cozinha (nome) values ('Indiana');

insert into restaurante (nome, taxa_frete, id_cozinha) values ('Thai Gourmet', 10, 1);
insert into restaurante (nome, taxa_frete, id_cozinha) values ('Thai Delivery', 9.5, 1);
insert into restaurante (nome, taxa_frete, id_cozinha) values ('Tuk Tuk Comida Indiana', 15, 2);

insert into estado (nome) values ("Rio Grande do Norte"), ("Minas Gerais"), ("Amapá");

insert into cidade (nome, id_estado) values ("Jandaíra", 1), ("Manhuaçu", 2), ("Macapá", 3);