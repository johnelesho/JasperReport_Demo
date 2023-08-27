-- DROP TABLE IF EXISTS receipt_tbl;

CREATE TABLE receipt_tbl
(
    id          BIGINT PRIMARY KEY,
    description VARCHAR(255),
    quantity    INTEGER,
    amount      INTEGER,
    total       INTEGER
);
INSERT INTO receipt_tbl (id, description, quantity, amount, total)
VALUES ('1','Dan', '2', '20', '40'),
       ('2','Jen', '3', '30', '90'),
       ('3','Bella', '5', '50', '250');
