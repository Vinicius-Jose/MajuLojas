create database MajuLoja 
go 
use MajuLoja


CREATE TABLE Fornecedor (
id int IDENTITY (1,1) NOT NULL,
nome varchar(255) NULL,
telefone char(12) NULL
PRIMARY KEY (id)
);

CREATE TABLE Motorista (
nome varchar(150) NULL,
num_Placa varchar(7) NOT NULL,
telefone char(12) NULL
PRIMARY KEY (num_Placa)
);

CREATE TABLE Cliente (
id int IDENTITY (1,1) NOT NULL,
nome varchar(150) NULL,
telefone char(12) NULL
PRIMARY KEY (id)
);

CREATE TABLE Capital (
codigo int IDENTITY (1000, 1) NOT NULL,
data_Capital datetime NULL,
valor_Capital decimal(7, 2) NULL
PRIMARY KEY (codigo)
);

CREATE TABLE Piloto (
codigo int IDENTITY (100, 1) NOT NULL,
valor_Unitario int NULL,
data_Piloto date NULL,
Capitalcodigo int NULL
PRIMARY KEY (codigo)
FOREIGN KEY (Capitalcodigo) REFERENCES Capital (codigo)
);

CREATE TABLE Aviamento (
codigo int IDENTITY (100, 1) NOT NULL,
data_Aviamento datetime NULL,
valor_Unitario decimal(7, 2) NULL,
nome varchar(25) NULL,
Fornecedorid int NOT NULL
PRIMARY KEY (codigo)
FOREIGN KEY (Fornecedorid) REFERENCES Fornecedor (id)
 );

 CREATE TABLE Corte_Costura (
codigo int IDENTITY (100,1) NOT NULL,
valor_Corte decimal(7, 2) NULL,
valor_Costura decimal(7, 2) NULL,
qtd_Peca_Cortada int NULL,
data datetime NULL,
Capitalcodigo int NULL
PRIMARY KEY (codigo)
FOREIGN KEY (Capitalcodigo) REFERENCES Capital (codigo)
);

CREATE TABLE Grade (
codigo int IDENTITY (100, 1) NOT NULL,
num_Tamanho_Minimo int NULL,
num_Tamanho_Maximo int NULL,
letra char(2) NULL
PRIMARY KEY (codigo)
);

CREATE TABLE Lucro (
codigo int IDENTITY (1000, 1) NOT NULL,
data_Lucro datetime NULL,
lucro_Mensal decimal(7, 2) NULL,
Capitalcodigo int NOT NULL
PRIMARY KEY (codigo)
FOREIGN KEY (Capitalcodigo) REFERENCES Capital (codigo)
);

CREATE TABLE Tecido (
codigo int IDENTITY (100, 1) NOT NULL,
data_Tecido date NULL,
valor_Unitario decimal(7, 2) NULL,
qtd_Rolo int NULL,
tipo varchar(255) NULL,
cor varchar(255) NULL,
Fornecedorid int NOT NULL,
Capitalcodigo int NULL
PRIMARY KEY (codigo)
FOREIGN KEY (Fornecedorid) REFERENCES Fornecedor (id),
FOREIGN KEY (Capitalcodigo) REFERENCES Capital (codigo)
);

CREATE TABLE Modelagem (
codigo int IDENTITY (100, 1) NOT NULL,
valor_Unitario decimal(7, 2) NULL,
data_Modelagem datetime NULL,
Capitalcodigo int NULL
PRIMARY KEY (codigo)
FOREIGN KEY (Capitalcodigo) REFERENCES Capital (codigo)
);

CREATE TABLE Modelo (
codigo int IDENTITY (1,1) NOT NULL,
modelo varchar(255) NULL,
margem_Custo decimal(7, 2) NULL,
preco_Custo decimal(7, 2) NULL,
Pilotocodigo int NOT NULL,
Modelagemcodigo int NOT NULL,
Corte_Costuracodigo int NOT NULL,
Tecidocodigo int NOT NULL
PRIMARY KEY (codigo)
FOREIGN KEY (Pilotocodigo) REFERENCES Piloto (codigo),
FOREIGN KEY (Modelagemcodigo) REFERENCES Modelagem (codigo),
FOREIGN KEY (Tecidocodigo) REFERENCES Tecido (codigo),
FOREIGN KEY (Corte_Costuracodigo) REFERENCES Corte_Costura (codigo),
);

CREATE TABLE Capital_Modelo (
Capitalcodigo int NOT NULL,
Modelocodigo int NOT NULL
PRIMARY KEY (Capitalcodigo, Modelocodigo)
FOREIGN KEY (Capitalcodigo) REFERENCES Capital (codigo),
FOREIGN KEY (Modelocodigo) REFERENCES Modelo (codigo)
);



CREATE TABLE Encomenda (
codigo int IDENTITY (1000, 1)NOT NULL,
data_Encomenda datetime NULL,
data_Retirada datetime NULL,
valor_Total decimal(7, 2) NULL,
Status_encomenda varchar(50) NULL,
Lucrocodigo int  NULL,
Clienteid int NOT NULL,
Motoristanum_Placa varchar(7)  NULL
PRIMARY KEY (codigo)
FOREIGN KEY (Motoristanum_Placa) REFERENCES Motorista (num_Placa),
FOREIGN KEY (Clienteid) REFERENCES Cliente (id),
FOREIGN KEY (Lucrocodigo) REFERENCES Lucro (codigo)
);

CREATE TABLE Venda (
codigo int IDENTITY (1000, 1) NOT NULL,
data_Venda date NULL,
valor_Total decimal(7, 2) NULL,
Lucrocodigo int NULL
PRIMARY KEY (codigo)
FOREIGN KEY (Lucrocodigo) REFERENCES Lucro (codigo)
);

CREATE TABLE Item_Venda (
Modelocodigo int NOT NULL,
Vendacodigo int NOT NULL,
qtd_Modelo_Vendido int NULL,
valor_Item_Venda decimal(7, 2) NULL
PRIMARY KEY (Modelocodigo, Vendacodigo)
FOREIGN KEY (Modelocodigo) REFERENCES Modelo (codigo),
FOREIGN KEY (Vendacodigo) REFERENCES Venda (codigo)
);

CREATE TABLE Estoque (
Modelocodigo int NOT NULL,
Gradecodigo int NOT NULL,
qtd_Grade int NULL
PRIMARY KEY (Modelocodigo, Gradecodigo)
FOREIGN KEY (Modelocodigo) REFERENCES Modelo (codigo),
FOREIGN KEY (Gradecodigo) REFERENCES Grade (codigo)
);

CREATE TABLE Item_Encomenda (
Modelocodigo int NOT NULL,
quantidade int NULL,
valor_Item_Encomenda decimal(7, 2) NULL,
Encomendacodigo int NOT NULL
PRIMARY KEY (Modelocodigo, Encomendacodigo)
FOREIGN KEY (Encomendacodigo) REFERENCES Encomenda (codigo),
FOREIGN KEY (Modelocodigo) REFERENCES Modelo (codigo)
);


CREATE TABLE Item_Peca (
Aviamentocodigo int NOT NULL,
Modelocodigo int NOT NULL,
qtd_Aviamento int NULL,
valor_Item_Peca decimal(7, 2) NULL,
Capitalcodigo int NULL
PRIMARY KEY (Aviamentocodigo, Modelocodigo)
FOREIGN KEY (Aviamentocodigo) REFERENCES Aviamento (codigo),
FOREIGN KEY (Modelocodigo) REFERENCES Modelo (codigo),
FOREIGN KEY (Capitalcodigo) REFERENCES Capital (codigo)
);

Create Table Usuarios(
nome varchar(200) not null Primary key,
senha varchar(200) not null
)

insert into Capital values
('10/04/2018',5000),
('09/03/2018',6000),
('08/02/2018',7000),
('07/01/2018',9000),
('06/12/2017',3000)

insert into Fornecedor values
('Alberto Gonçalves', '011971763490'),
('Carlos Alberto de Andrade', '011982867455'),
('Bruno Marcondes', '011980867523'),
('Joana Albuquerque', '011984200567')

 insert into Aviamento values
 ('12/01/2018', 0.20, 'Ziper', 1),
 ('12/01/2018', 9.80, 'Elastico comum', 1),
 ('07/02/2018', 0.20, 'Ziper De ouro', 1),
 ('07/02/2018', 9.80, 'Elastico para moletom', 1),
 ('09/03/2018', 0.20, 'Ziper de prata', 1),
 ('09/03/2018', 9.80, 'Elastico para calca', 1),
 ('10/04/2018', 0.20, 'Ziper para moletom', 1)


 insert into Modelagem values
(40.00, '10/01/2018', 1000),
(40.00, '08/01/2018', 1000)


insert into Grade values
(36, 38, 'P'),
(40, 42, 'M'),
(44, 46, 'G'),
(48, 50, 'GG')

 

insert into Piloto values
(40.00, '10/01/2018', 1000),
(40.00, '08/01/2018', 1000)



insert into Tecido values
('14/01/2018', 8.90, 1, 'Moletom', 'Preto', 2, 1000),
('14/01/2018', 8.90, 1, 'Jeans', 'Cinza', 3, 1000),
('12/02/2018', 8.90, 2, 'Moletom', 'Azul', 2, 1001),
('12/02/2018', 8.90, 2, 'Jeans', 'Cinza', 3, 1001),
('15/03/2018', 8.90, 1, 'Moletom', 'Preto', 2, 1002),
('15/03/2018', 8.90, 1, 'Jeans', 'Cinza', 3, 1002),
('18/04/2018', 8.90, 3, 'Moletom', 'Azul', 2, 1003),
('18/04/2018', 8.90, 3, 'Jeans', 'Cinza', 3, 1003),
('20/05/2018', 8.90, 2, 'Moletom', 'Preto', 2, 1004),
('20/05/2018', 8.90, 2, 'Jeans', 'Cinza', 3, 1004)


insert into Corte_Costura values
(0.40, 2.80, 350, '15/01/2018', 1000),
(0.40, 2.80, 220, '05/02/2018', 1001),
(0.40, 2.80, 240, '01/03/2018', 1002),
(0.40, 2.80, 320, '01/04/2018', 1003),
(0.40, 2.80, 400, '01/04/2018', 1004)

 insert into Modelo values
('Conjunto de Moletom', 50.00, 25.00, 100, 100, 100, 100),
('Saia', 25.00, 12.50, 101, 101, 100, 100)



insert into Estoque values
(1, 100, 25),
(1, 101, 10),
(1, 102, 3),
(1, 103, 2),
(2, 100, 30),
(2, 101, 20),
(2, 102, 17),
(2, 103, 23)



insert into Cliente values
('José Pereira Souza', '011947296576'),
('Sabrina Alencar', '011989342390'),
('Caroline Batista', '011956576320'),
('Fernando Augusto Brito', '011997621024'),
('Marcela da Silva', '011976429807')

insert into Motorista values
('João Pedro da Silva', 'KDB6632','011986872340'),
('Marcos Antônio de Oliveira', 'CJK2052', '011980742301'),
('Gilberto dos Santos', 'FJM9067', '011981845645')


insert into lucro(data_Lucro,lucro_Mensal,Capitalcodigo) values
('10/04/2018',5000,1000),
('09/03/2018',60000,1002),
('08/02/2018',70000,1001),
('07/01/2018',10000,1003),
('06/12/2017',30000,1004)



insert into Encomenda values
('23/01/2018', '27/01/2018', 200.00, 'RETIRADO', 1000, 1, 'CJK2052'),
('24/01/2018', '28/01/2018', 100.00, 'RETIRADO', 1000, 2, 'FJM9067'),
('15/02/2018', '18/02/2018', 75.00, 'RETIRADO', 1001, 3, 'FJM9067'),
('13/03/2018', '16/03/2018', 125.00, 'RETIRADO', 1002, 4, 'KDB6632'),
('05/04/2018', '07/04/2018', 225.00, 'RETIRADO', 1003, 5, 'CJK2052'),
('20/05/2018', '23/05/2018', 175.00, 'RETIRADO',1004, 4, 'CJK2052'),
('01/06/2018', '05/06/2018', 100.00, 'RETIRADO', 1004, 3, 'KDB6632'),
('04/06/2018', '12/06/2018', 150.00, 'ARETIRAR', 1004, 1, 'KDB6632'),
('06/06/2018', '11/06/2018', 25.00, 'CANCELADO', 1004, 2, 'FJM9067')

insert into Item_Encomenda values
(1, 4, 50.00, 1000),
(1, 2, 50.00, 1001),
(2, 3, 25.00, 1002),
(1, 2, 50.00, 1003),
(2, 1, 25.00, 1003),
(1, 4, 50.00, 1004),
(2, 1, 25.00, 1004),
(1, 2, 50.00, 1005),
(2, 3, 25.00, 1005),
(2, 4, 25.00, 1006),
(1, 2, 50.00, 1007),
(2, 2, 25.00, 1007),
(2, 1, 25.00, 1008)


insert into Venda values
('25/01/2018', 25.00, 1000),
('30/01/2018', 100.00, 1000),
('13/02/2018', 250.00, 1001),
('18/02/2018', 300.00, 1001),
('04/03/2018', 50.00, 1002),
('05/03/2018', 200.00, 1002),
('23/04/2018', 125.00, 1003),
('27/04/2018', 175.00, 1003),
('15/05/2018', 400.00, 1004),
('20/05/2018', 200.00, 1004)


insert into Item_Venda values
(2, 1000, 1, 25.00),
(1, 1001, 2, 50.00),
(1, 1002, 4, 50.00),
(2, 1002, 2, 25.00),
(1, 1003, 5, 50.00),
(2, 1003, 2, 25.00),
(1, 1004, 1, 50.00),
(1, 1005, 2, 50.00),
(2, 1005, 4, 25.00),
(1, 1006, 2, 50.00),
(2, 1006, 1, 25.00),
(1, 1007, 2, 50.00),
(2, 1007, 3, 25.00),
(1, 1008, 6, 50.00),
(2, 1008, 4, 25.00),
(1, 1009, 4, 50.00)

insert into Corte_Costura values
(10.00,5.00,200,'10/05/2018', null),
(20.00,1.00,150,'08/05/2018', null)

insert into Tecido values
('10/05/2018', 15, 20,'Tecido para moletom', 'Preto', 1, null),
('08/05/2018', 15, 20,'Tecido de Laicra', 'Azul', 1, null)

insert into Item_Peca values
(100, 1, 100, 0.20, 1000),
(101, 2, 100, 9.80, 1000)

insert into Usuarios values
('root', PWDENCRYPT('root')),
('admin',PWDENCRYPT('admin')),
('Maju' , PWDENCRYPT('Lojas'))


Select Month(data_Capital) as meses from Capital
Order by meses

UPdate Capital
set data_Capital = '06/12/2017'
where MONTH(data_Capital) =12
--(100, 1, 60, 0.20, 1001),
--(100, 1, 70, 0.20, 1002),
--(100, 1, 50, 0.20, 1003),
--(100, 1, 60, 0.20, 1004),

--(101, 2, 60, 9.80, 1001),
--(101, 2, 70, 9.80, 1002),
--(101, 2, 50, 9.80, 1003),
--(101, 2, 60, 9.80, 1004)


Select Distinct( md.modelo), md.preco_Custo as custoConfeccao, cc.qtd_Peca_Cortada as cortado, cc.valor_Corte as valCorte,  cc.valor_Costura as costura,case when (tec.Capitalcodigo!= cap.codigo) then 0 else tec.valor_Unitario  end as tecido,case when (pl.Capitalcodigo!= cap.codigo) then 0 else pl.valor_Unitario end as piloto , case  when (ml.CapitalCodigo != cap.codigo) then 0 else ml.valor_Unitario end as modelagem from Capital cap , Modelo md , Corte_Costura cc, Tecido tec, Modelagem ml,Piloto pl
where MONTH(data_Capital) = 02 and YEAR(data_Capital) = 2018 and md.Tecidocodigo = tec.codigo and cc.codigo = md.Corte_Costuracodigo and ml.codigo = md.Modelagemcodigo 



Select valor_Capital  from Capital where MONTH(data_Capital) = 4 and YEAR(data_Capital) = 2018

select PWDCOMPARE('admin',senha) as valido from Usuarios WHERE nome = 'admin'

Select valor_Capital  from Capital where MONTH(data_Capital) = 4 and YEAR(data_Capital) = 2018



select vd.valor_Total + en.valor_Total as valor_Ganho from Modelo md, Venda vd, Encomenda en, Item_Encomenda ien, Item_Venda iv , lucro l where ien.Modelocodigo = md.codigo and iv.Modelocodigo = md.codigo and vd.codigo = iv.Vendacodigo and en.codigo = ien.Encomendacodigo and l.codigo = vd.Lucrocodigo and en.Lucrocodigo = l.codigo and Month(l.data_Lucro) = 6 and YEAR(l.data_Lucro) =2018
group by md.modelo, md.margem_Custo

Select  DISTINCT(md.modelo), md.preco_Custo as custoConfeccao, cc.qtd_Peca_Cortada as cortado, cc.valor_Corte as valCorte,  cc.valor_Costura as costura, tec.valor_Unitario  as tecido,case when (pl.Capitalcodigo!= cap.codigo) then 0 else pl.valor_Unitario end as piloto , case  when (ml.CapitalCodigo != cap.codigo) then 0 else ml.valor_Unitario end as modelagem from Capital cap , Modelo md , Corte_Costura cc, Tecido tec, Modelagem ml,Piloto pl where MONTH(data_Capital) = 6 and YEAR(data_Capital) = 2018 and md.Tecidocodigo = tec.codigo and cc.codigo = md.Corte_Costuracodigo and ml.codigo = md.Modelagemcodigo

select lucro_Mensal, data_Lucro from Lucro
select * from Lucro

select * from Aviamento where nome like 'zi%'



select * from Corte_Costura where DATEDIFF(MONTH,data,getdate()) = 1
select * from Tecido where DATEDIFF(MONTH,data_Tecido,getdate()) = 1
select * from Venda where DATEDIFF(MONTH,data_Venda,getdate()) = 1
select * from Encomenda where DATEDIFF(MONTH,data_Encomenda,getdate()) = 1
select * from Modelo
update Encomenda
set Lucrocodigo = null
where data_Retirada = '23/05/2018'

update tecido
set data_Tecido = ('20/04/2018')
where data_Tecido = '20/05/2018'


alter table encomenda
alter column lucrocodigo int null

alter table encomenda
alter column Motoristanum_Placa varchar(07) null

alter table modelo
alter column Corte_Costuracodigo int null

alter table grade
add constraint tamanho unique(letra)


alter table modelo
alter column corte_costuracodigo int null

select * from Capital
delete from Capital
where codigo = 1004
select * from Capital
select * from Lucro
select * from Capital 
select * from Venda
select * from encomenda
where DATEDIFF(MONTH,data_Venda,getdate()) = 1
select * from Encomenda where Lucrocodigo = 1013

update Capital
set data_Capital = '12/05/2018'
where data_Capital = '12/06/2018'

select max(codigo) +1 from Lucro

select * from Lucro
truncate table Venda


select md.modelo as modelo,Sum(ien.quantidade) + Sum(iv.qtd_Modelo_Vendido)as qtd, md.margem_Custo as preco,  Sum(vd.valor_Total) + Sum(en.valor_Total)as valor_Ganho from Modelo md, Venda vd, Encomenda en, Item_Encomenda ien, Item_Venda iv , lucro l where ien.Modelocodigo = md.codigo and iv.Modelocodigo = md.codigo and vd.codigo = iv.Vendacodigo and en.codigo = ien.Encomendacodigo and l.codigo = vd.Lucrocodigo and en.Lucrocodigo = l.codigo and Month(l.data_Lucro) = 6 and YEAR(l.data_Lucro) =2018
group by md.modelo, md.margem_Custo

select sum(vd.valor_Total) , sum(en.valor_Total) from Venda vd, Lucro l, Encomenda en  where l.codigo = 1013 and
vd.Lucrocodigo = l.codigo and en.Lucrocodigo = l.codigo 
group by en.codigo


select * from modelo
select * from Estoque
select md.modelo , gd.letra as grade, es.qtd_Grade as quantidade  from estoque es, Modelo md, Grade gd
where md.codigo = es.Modelocodigo and gd.codigo = es.Gradecodigo and es.Modelocodigo = 1

select es.ModeloCodigo as modelo, es.qtd_Grade as quantidade, es.gradeCodigo, gd.letra from grade gd, Estoque es 
where es.Gradecodigo = gd.codigo and es.Modelocodigo = 1
select * from modelo

