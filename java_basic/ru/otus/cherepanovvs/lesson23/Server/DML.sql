INSERT INTO `Roles` 
(role_id, role_name) 
VALUES 
(1, "ADMIN"),
(2, "USER");


INSERT INTO `Users` 
(user_id, login, password, user_name, role_id)
VALUES
(1, "login1", 106438208, "user1", 1),
(2, "login2", 106438209, "user2", 2);