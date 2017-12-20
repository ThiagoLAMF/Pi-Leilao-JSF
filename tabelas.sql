CREATE TABLE TbUsuario(
		Pk_Id_Usuario INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
		Nome_Usuario VARCHAR(255),
        Login_Usuario VARCHAR(255),
        Senha_Usuario VARCHAR(255),
		Fg_Admin BIT DEFAULT 0
);

CREATE TABLE TbLeilao(
	Pk_Id_Leilao INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    Ds_Leilao VARCHAR(255),
    Status_Leilao INT DEFAULT 0, -- status 0 = cadastrado | status 1 = em andamento | status 2 = finalizado
    Lance_Minimo DECIMAL(17,3),
    Valor_Lance DECIMAL(17,3)
);

CREATE TABLE TbLance(
	Pk_Id_Lance INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	Lance_Leilao DECIMAL(17,3),
    Fk_Id_Leilao INTEGER NOT NULL,
    Fk_Id_Usuario INTEGER NOT NULL,
    FOREIGN KEY (Fk_Id_Leilao)
		REFERENCES TbLeilao(Pk_Id_Leilao),
	FOREIGN KEY (Fk_Id_Usuario)
		REFERENCES TbUsuario(Pk_Id_Usuario)
);

INSERT INTO TbUsuario(Nome_Usuario,Login_Usuario,Senha_Usuario,Fg_Admin) VALUES("administrador","admin","123",1);
INSERT INTO TbUsuario(Nome_Usuario,Login_Usuario,Senha_Usuario,Fg_Admin) VALUES("cliente","cliente","123",1);

INSERT INTO TbLeilao(Ds_Leilao,Fg_Encerrado,Lance_Minimo,Valor_Lance) VALUES("TV 30'",0,1,1);
INSERT INTO TbLeilao(Ds_Leilao,Fg_Encerrado,Lance_Minimo,Valor_Lance) VALUES("TV 20'",0,1,1);

INSERT INTO TbLance(Lance_Leilao,Fk_Id_Leilao,Fk_Id_Usuario) VALUES(1,1,1);

select * from tbusuario
select * from tbleilao

select * from tblance

delete from tblance
delete from tbleilao

-- drop table tblance
-- drop table tbleilao