CREATE TABLE IF NOT EXISTS  T_USER(
   ID INT NOT NULL AUTO_INCREMENT,
   USERNAME VARCHAR(100) NOT NULL,
   PASSWORD VARCHAR(100) NOT NULL,
   PRIMARY KEY ( ID )
);


INSERT INTO T_USER (USERNAME, PASSWORD) VALUES ('Jack', 'AAAAAAAA');
INSERT INTO T_USER (USERNAME, PASSWORD) VALUES ('Jones', 'BBBBBBBB');