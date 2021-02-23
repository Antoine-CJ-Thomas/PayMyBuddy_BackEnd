package com.paymybuddy.app.service;

<<<<<<< HEAD
=======
import java.sql.ResultSet;
import java.sql.SQLException;

>>>>>>> refs/remotes/origin/develop
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymybuddy.app.model.UserAccount;
import com.paymybuddy.app.repository.UserAccountRepository;

/**
 *
 */
@Service
public class UserAccountService {

    private static final Logger logger = LogManager.getLogger("UserAccountService");

    @Autowired
	private UserAccountRepository userAccountRepository;
    
    private UserAccount userAccount = new UserAccount();
	
	public UserAccountService() {
        logger.info("UserAccountService()");
	}
<<<<<<< HEAD
	
	public boolean createUserAccount(UserAccount userAccount) {
        logger.info("createUserAccount(" + userAccount + ")");
=======

	public UserAccount getUserAccount(String emailAddress, UserAccount userAccount) {
        logger.info("getUserAccount(" + emailAddress + ", " + userAccount + ")");
>>>>>>> refs/remotes/origin/develop
        
<<<<<<< HEAD
        userAccountRepository.insertUserAcount(userAccount);
        
		boolean creationSuccessful = false;

		this.userAccount = userAccountRepository.selectUserAcount(userAccount.getEmailAddress());
		
        if (this.userAccount.getPassword().equals(userAccount.getPassword()) && this.userAccount.getFirstName().equals(userAccount.getFirstName()) && this.userAccount.getLastName().equals(userAccount.getLastName())) {

        	creationSuccessful = true;
		    logger.info("- Account created successfully");
        }
        
        else {

		    logger.info("- Account couldn't be created");
        }
        
		return creationSuccessful;
	}
=======
        ResultSet resultSet = userAccountRepository.selectUserAcount(emailAddress);
        
    	try {
>>>>>>> refs/remotes/origin/develop

<<<<<<< HEAD
	public UserAccount getUserAccount(String emailAddress) {
        logger.info("getUserAccount(" + emailAddress + ")");
                
		return userAccountRepository.selectUserAcount(emailAddress);
=======
			if (resultSet.next()) {

				userAccount.setId(resultSet.getInt("id"));
				userAccount.setEmailAddress(resultSet.getString("email_address"));
				userAccount.setPassword(resultSet.getString("password"));
				userAccount.setFirstName(resultSet.getString("first_name"));
				userAccount.setLastName(resultSet.getString("last_name"));
				userAccount.setBalanceAmount(resultSet.getFloat("balance"));
			}

		} catch (SQLException e) {
            logger.error("- ResultSet throw exception : " + e.getMessage());
		} finally {
			closeResultSet(resultSet);
	    }
        
		return userAccount;
	}
	
	public boolean createUserAccount(UserAccount userAccount) {
        logger.info("createUserAccount(" + userAccount + ")");
        
        userAccountRepository.insertUserAcount(userAccount);
        
		boolean creationSuccessful = false;
        
        ResultSet resultSet = userAccountRepository.selectUserAcount(userAccount.getEmailAddress());

		try {

			if (resultSet.next()) {
				
				if (resultSet.getString("password").equals(userAccount.getPassword())) {
					if (resultSet.getString("first_name").equals(userAccount.getFirstName())) {
						if (resultSet.getString("last_name").equals(userAccount.getLastName())) {

							creationSuccessful = true;
						    logger.info("- Account created successfully");
						}
					}
				}
			}

		} catch (SQLException e) {
            logger.error("- ResultSet throw exception : " + e.getMessage());
            
		} finally {
			closeResultSet(resultSet);
	    }
		
		if (creationSuccessful == false) {
		    logger.info("- Account couldn't be created");
		}
        
		return creationSuccessful;
>>>>>>> refs/remotes/origin/develop
	}

	public boolean editUserAccount(UserAccount userAccount) {
        logger.info("editUserAccount(" + userAccount + ")");
        
        userAccountRepository.updateUserAcount(userAccount);
        
		boolean editionSuccessful = false;
<<<<<<< HEAD
=======
        
        ResultSet resultSet = userAccountRepository.selectUserAcount(userAccount.getEmailAddress());
>>>>>>> refs/remotes/origin/develop

<<<<<<< HEAD
		this.userAccount = userAccountRepository.selectUserAcount(userAccount.getEmailAddress());
		
        if (this.userAccount.getPassword().equals(userAccount.getPassword()) && this.userAccount.getFirstName().equals(userAccount.getFirstName()) && this.userAccount.getLastName().equals(userAccount.getLastName())) {

			editionSuccessful = true;
		    logger.info("- Account edited successfully");
        }
        
        else {

		    logger.info("- Account couldn't be edited");
        }
=======
		try {

			if (resultSet.next()) {
				
				if (resultSet.getString("password").equals(userAccount.getPassword())) {
					if (resultSet.getString("first_name").equals(userAccount.getFirstName())) {
						if (resultSet.getString("last_name").equals(userAccount.getLastName())) {

							editionSuccessful = true;
						    logger.info("- Account edited successfully");
						}
					}
				}
			}

		} catch (SQLException e) {
            logger.error("- ResultSet throw exception : " + e.getMessage());
            
		} finally {
			closeResultSet(resultSet);
	    }
		
		if (editionSuccessful == false) {
		    logger.info("- Account couldn't be edited");
		}
>>>>>>> refs/remotes/origin/develop
        
		return editionSuccessful;
	}

	public boolean deleteUserAccount(String emailAddress) {
        logger.info("deleteUserAccount(" + emailAddress +")");
        
<<<<<<< HEAD
		boolean deleteSuccessful = false;
        
        userAccountRepository.deleteUserAcount(emailAddress);

        if (userAccountRepository.selectUserAcount(emailAddress).getId() == 0) {

			deleteSuccessful = true;
		    logger.info("- Account deleted successfully");
        }
        
        else {

		    logger.info("- Account couldn't be deleted");
        }
=======
        userAccountRepository.deleteUserAcount(emailAddress);

		boolean deleteSuccessful = false;
		
        ResultSet resultSet = userAccountRepository.selectUserAcount(emailAddress);
		
		try {
			
			if (resultSet.next() == false) {

				deleteSuccessful = true;
			    logger.info("- Account deleted successfully");
			}

		} catch (SQLException e) {
            logger.error("- ResultSet throw exception : " + e.getMessage());
            
		} finally {
			closeResultSet(resultSet);
	    }
		
		if (deleteSuccessful == false) {
		    logger.info("- Account couldn't be deleted");
		}
>>>>>>> refs/remotes/origin/develop

		return deleteSuccessful;
	}

	public boolean logInUserAccount(String emailAddress, String password) {
        logger.info("logInUserAccount(" + emailAddress + ", " + password +")");
        
		boolean loginSuccessful = false;
<<<<<<< HEAD
=======
		
        ResultSet resultSet = userAccountRepository.selectUserAcount(emailAddress);
>>>>>>> refs/remotes/origin/develop

<<<<<<< HEAD
        if (userAccountRepository.selectUserAcount(emailAddress).getPassword().equals(password)) {

		    loginSuccessful = true;
		    logger.info("- Connexion allowed");
        }
        
        else {

		    logger.info("- Connexion prohibited");
        }
=======
		try {

			if (resultSet.next()) {
				
				if (resultSet.getString("password").equals(password)) {

				    loginSuccessful = true;
				    logger.info("- Connexion allowed");
				}
			}

		} catch (SQLException e) {
            logger.error("- ResultSet throw exception : " + e.getMessage());
            
		} finally {
			closeResultSet(resultSet);
	    }
		
		if (loginSuccessful == false) {
		    logger.info("- Connexion prohibited");
		}
>>>>>>> refs/remotes/origin/develop

		return loginSuccessful;
	}
<<<<<<< HEAD
=======
	
    private void closeResultSet(ResultSet resultSet) {

        if (resultSet != null) {
        	try {
        		resultSet.close();
			} catch (SQLException e) {
	            logger.error("- Close resultSet throw exception : " + e.getMessage());
			}
		}
    }
>>>>>>> refs/remotes/origin/develop
}
