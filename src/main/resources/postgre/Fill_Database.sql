INSERT INTO user_account (email_address,password,first_name,last_name,balance)
VALUES    

	('Danny.Griffiths@email','$2a$12$YDSqx9IZo8DP1Zk8mHxAm.NYQRh99Bno8en0XjJSH1j.vQsB2O2xe','Danny','Griffiths',250.0),
	('Pollard.Berrier@email','$2a$12$cXWPX7VebQddaXU4ownKje3ZmPRuwoP5NiqY/BQUS/OR8iWjsxLzW','Pollard','Berrier',150.0),
	('Darius.Keeler@email','$2a$12$r0Bei6UFHLdhVWNlMOUXo.FwKTQmLNGL.jJaO6beTmDAR9bfz1856','Darius','Keeler',250.0),
	('Craig.Walker@email','$2a$12$ngaaYRw4JQfkYrI.DP9hO.y15MTt0cxZA7sfbsQ4ufU.BY4rVQlPu','Craig','Walker',200.0),
	('Dave.Pen@email','$2a$12$0NJ9Jme9fIp4AWbrtK4GLOEjhkrVMCMU1ZtQyqwGYDFpfToYPrXl2','Dave','Pen',150.0);
	
INSERT INTO user_contact (user_id,contact_id)
VALUES    

	(1,2),(1,3),(1,4),	
	(2,3),(2,4),(2,5),	
	(3,4),(3,5),(3,1),	
	(4,5),(4,1),(4,2),
	(5,1),(5,2),(5,3);
	
INSERT INTO bank_account (user_id,account_name,account_number,swift_code)
VALUES    

	(1,'Main account','123456789','AAAABBCCDDD'),
	(2,'Main account','234567891','EEEEFFGGHHH'),
	(3,'Main account','345678912','IIIIJJKKLLL'),
	(4,'Main account','456789123','MMMMNNOOPPP'),
	(5,'Main account','567891234','QQQQRRSSTTT');
	
INSERT INTO internal_transaction (user_id,contact_id,date_time,amount,description)
VALUES    

	(1,2,'2021-03-10 08:00:00',20,'Cinema'),(1,3,'2021-03-15 09:00:00',30,'Bar'),(1,4,'2021-03-20 10:00:00',40,'Restaurant'),
	(2,3,'2021-03-11 11:00:00',30,'Cinema'),(2,4,'2021-03-16 12:00:00',40,'Bar'),(2,5,'2021-03-21 13:00:00',50,'Restaurant'),
	(3,4,'2021-03-12 14:00:00',40,'Bar'),(3,5,'2021-03-17 15:00:00',50,'Restaurant'),(3,1,'2021-03-22 16:00:00',10,'Cinema'),
	(4,5,'2021-03-13 17:00:00',50,'Restaurant'),(4,1,'2021-03-18 18:00:00',10,'Cinema'),(4,2,'2021-03-23 19:00:00',20,'Bar'),
	(5,1,'2021-03-14 20:00:00',10,'Cinema'),(5,2,'2021-03-19 21:00:00',20,'Bar'),(5,3,'2021-03-24 22:00:00',30,'Restaurant');
	
INSERT INTO external_transaction (user_id,bank_id,date_time,amount,description)
VALUES    

	(1,1,'2021-03-01 12:00:00',-340,'Balance fill'),
	(2,2,'2021-03-01 12:00:00',-270,'Balance fill'),
	(3,3,'2021-03-01 12:00:00',-350,'Balance fill'),
	(4,4,'2021-03-01 12:00:00',-280,'Balance fill'),
	(5,5,'2021-03-01 12:00:00',-210,'Balance fill');