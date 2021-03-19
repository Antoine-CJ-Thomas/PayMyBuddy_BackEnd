INSERT INTO user_account (email_address,password,first_name,last_name,balance)
VALUES    

	('Jean.Martin@email','197','Jean','Martin',228.0),
	('Pierre.Bernard@email','890','Pierre','Bernard',120.0),
	('Michel.Thomas@email','820','Michel','Thomas',108.0),
	('André.Petit@email','711','André','Petit',105.0),
	('Philippe.Robert@email','538','Philippe','Robert',102.0);
	
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