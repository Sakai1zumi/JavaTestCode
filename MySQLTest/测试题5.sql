CREATE TABLE IF NOT EXISTS Book(
	bid INT PRIMARY KEY,
	bname VARCHAR(20) UNIQUE NOT NULL,
	price FLOAT DEFAULT 10,
	btypeId INT,
	CONSTRAINT bk_bt_btype FOREIGN KEY(btypeId) REFERENCES bookType(id);
);

SET autocommit = 0;
START TRANSACTION;

INSERT INTO book(bid,bname,price,btypeId) VALUES(1,'三体',20,1);

COMMIT;

CREATE VIEW my_v1
AS
SELECT b.bname,bT.`name`
FROM Book b
JOIN bookType bT
ON b.btypeId=bT.id
WHERE b.price>100;

CREATE OR REPLACE my_v1
AS
SELECT bname,price
FROM book
WHERE price BETWEEN 90 AND 120;

DROP my_v1;