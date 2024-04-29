DROP TABLE CP_CARD;
DROP TABLE CP_COLECAO;

CREATE TABLE CP_COLECAO (
       cod_colecao NUMERIC GENERATED ALWAYS AS IDENTITY PRIMARY KEY ,
       nome VARCHAR(255) NOT NULL
);

create table CP_CARD(
       cod_carta VARCHAR2(2) PRIMARY KEY NOT NULL,
       nome VARCHAR2(255) NOT NULL,
       velocidade NUMBER NOT NULL,
       cilindradas NUMBER NOT NULL,
       zeroCem NUMBER NOT NULL,
       potencia NUMBER NOT NULL,
       comprimento NUMBER NOT NULL,
       peso NUMBER NOT NULL,
       is_supertrunfo VARCHAR2(1) NOT NULL,
       cod_colecao NUMBER NOT NULL
);
ALTER TABLE CP_CARD ADD CONSTRAINT fk_colecao FOREIGN KEY (cod_colecao) REFERENCES cp_colecao(cod_colecao);



