INSERT INTO user_account (email_address,password,first_name,last_name,balance)
VALUES    

	('Danny.Griffiths@email','$2y$10$Q0kyED2ilZJy9DBL9wc.7.ziwGIqDCQDpw5DF9g22xBwqCWabqnrS','Danny','Griffiths',250.0),
	('Pollard.Berrier@email','$2y$10$2qaPXX16SiSs0jW2dHYis.vs5fPJI2NI/8a9l2.q.yEmgfqmsJW9O','Pollard','Berrier',150.0),
	('Darius.Keeler@email','$2y$10$CmjiOD7a8O7PxpvRHOAQNeDVPfdSs/yDjq2SCh7gmyqSCopXSvzhW','Darius','Keeler',250.0),
	('Craig.Walker@email','$2y$10$kZhLw9fBnQmShtsOjKlVQuQD3O/7PC3jyOY9UjH8YJylw6STeT.be','Craig','Walker',200.0),
	('Dave.Pen@email','$2y$10$V7Lf0Oo/lyBtTqur853wYOTKUQEm3cgXMMZzvtK7HgHEA67YBnUEO','Dave','Pen',150.0);
	
INSERT INTO user_contact (user_id,contact_id)
VALUES    

	(1,2),
	(1,3),
	(1,4),
	
	(2,3),
	(2,4),
	(2,5),
	
	(3,4),
	(3,5),
	(3,1),
	
	(4,5),
	(4,1),
	(4,2),
	
	(5,1),
	(5,2),
	(5,3);
	
INSERT INTO bank_account (user_id,account_name,account_number,swift_code)
VALUES    

	(1,'main account','123456789','AAAABBCCDDD'),
	(2,'main account','234567891','EEEEFFGGHHH'),
	(3,'main account','345678912','IIIIJJKKLLL'),
	(4,'main account','456789123','MMMMNNOOPPP'),
	(5,'main account','567891234','QQQQRRSSTTT');