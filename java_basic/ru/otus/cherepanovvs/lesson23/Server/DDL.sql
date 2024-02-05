CREATE DATABASE chat_users;

CREATE TABLE Roles (
  role_id INT PRIMARY KEY,
  role_name VARCHAR(255)
);

CREATE TABLE Users (
  user_id INT PRIMARY KEY,
  login VARCHAR(255),
  password INT,
  user_name VARCHAR(255),
  role_id INT,
  FOREIGN KEY (role_id) REFERENCES Roles(role_id)
);