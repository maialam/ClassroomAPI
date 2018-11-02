package com.infosys.classroom.persistence;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.infosys.classroommanagement.ClassroomAccount;
import com.infosys.util.JSONUtil;



@Transactional(SUPPORTS)
@Default
public class ClassroomServiceDBImpl implements ClassroomServiceDB {



	@PersistenceContext(unitName = "primary")
		private EntityManager manager;

		@Inject
		private JSONUtil util;

		
		public String getAllAccounts() {
			Query query =  manager.createQuery("Select a FROM Account a");
			Collection<ClassroomAccount> accounts = (Collection<ClassroomAccount>) ((javax.persistence.Query) query).getResultList();
			return util.getJSONForObject(accounts);
		}


		@Transactional
		public String createAccount(String account) {
			ClassroomAccount anAccount = util.getObjectForJSON(account, ClassroomAccount.class);
			manager.persist(anAccount);
			if (anAccount.getAccountNumber().equals(9999))
					{
				return "{\"message\": \"This account is blocked\"}";
			} 
			return "{\"message\": \"account has been sucessfully added\"}";
		}


		@Transactional(REQUIRED)
		public String updateAccount(Long classroomid, String accountToUpdate) {
			ClassroomAccount updatedAccount = util.getObjectForJSON(accountToUpdate, ClassroomAccount.class);
			ClassroomAccount accountFromDB = findAccount(classroomid);
			if (accountToUpdate != null) {
				accountFromDB = updatedAccount;
				manager.merge(accountFromDB);
			}
			return "{\"message\": \"account sucessfully updated\"}";
		}
		
		
		
		@Transactional(REQUIRED)
		public String getAccount(Long classroomid) {
			ClassroomAccount accountInDB = findAccount(classroomid);
			 return util.getJSONForObject(accountInDB);
			
		}



		
		@Transactional(REQUIRED)
		public String deleteAccount(Long classroomid) {
			ClassroomAccount accountInDB = findAccount(classroomid);
			if (accountInDB != null) {
				manager.remove(accountInDB);
			}
			return "{\"message\": \"account sucessfully deleted\"}";
		}

		private ClassroomAccount findAccount(Long classroomid) {
			return manager.find(ClassroomAccount.class, classroomid);
		}

		public void setManager(EntityManager manager) {
			this.manager = manager;
		}

		public void setUtil(JSONUtil util) {
			this.util = util;
		}





	}
		
		


	

