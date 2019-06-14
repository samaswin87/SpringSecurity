CREATE  TABLE users (
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(60) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username));
  
  CREATE TABLE user_roles (
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (role,username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username));
  
  
  -- aswin@123 and raj@123 are password 
  INSERT INTO users(username,password,enabled)
VALUES ('aswin','$2a$10$IuVeBtyaYUl9jgaa5MUNje4iAErkPnlGmx74aS9cgTY5h.HBqm7uG', true);
INSERT INTO users(username,password,enabled)
VALUES ('raj','$2a$10$egyGYa/oB.8vC6To2KLW4.YhpTXjjSi2TdPHu.QqHRgRFeERSmrJa', true);

INSERT INTO user_roles (username, role)
VALUES ('aswin', 'ROLE_USER');
INSERT INTO user_roles (username, role)
VALUES ('aswin', 'ROLE_ADMIN');
INSERT INTO user_roles (username, role)
VALUES ('raj', 'ROLE_USER');