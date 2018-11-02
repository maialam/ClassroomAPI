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

import com.infosys.classroommanagement.Classroom;
import com.infosys.util.JSONUtil;



@Transactional(SUPPORTS)
@Default
public class ClassroomServiceDBImpl implements ClassroomServiceDB {



	@PersistenceContext(unitName = "primary")
		private EntityManager manager;

		@Inject
		private JSONUtil util;

		
		public String getAllClassrooms() {
			Query query =  manager.createQuery("Select a FROM Classroom a");
			Collection<Classroom> classroom = (Collection<Classroom>) ((javax.persistence.Query) query).getResultList();
			return util.getJSONForObject(classroom);
		}


		@Transactional
		public String createClassroom(String account) {
			Classroom aclassroom = util.getObjectForJSON(account, Classroom.class);
			manager.persist(aclassroom);
			if (aclassroom.getAccountNumber().equals(9999))
					{
				return "{\"message\": \"This account is blocked\"}";
			} 
			return "{\"message\": \"account has been sucessfully added\"}";
		}


		@Transactional(REQUIRED)
		public String updateClassroom(Long classroomid, String accountToUpdate) {
			Classroom updatedAccount = util.getObjectForJSON(accountToUpdate, Classroom.class);
			Classroom classroomFromDB = findClassroom(classroomid);
			if (accountToUpdate != null) {
				classroomFromDB = updatedAccount;
				manager.merge(classroomFromDB);
			}
			return "{\"message\": \"account sucessfully updated\"}";
		}
		
		
		
		@Transactional(REQUIRED)
		public String getClassroom(Long classroomid) {
			Classroom classroomInDB = findClassroom(classroomid);
			 return util.getJSONForObject(classroomInDB);
			
		}



		
		@Transactional(REQUIRED)
		public String deleteClassroom(Long classroomid) {
			Classroom classroomInDB = findClassroom(classroomid);
			if (classroomInDB != null) {
				manager.remove(classroomInDB);
			}
			return "{\"message\": \"account sucessfully deleted\"}";
		}

		private Classroom findClassroom(Long classroomid) {
			return manager.find(Classroom.class, classroomid);
		}

		public void setManager(EntityManager manager) {
			this.manager = manager;
		}

		public void setUtil(JSONUtil util) {
			this.util = util;
		}





	}
		
		


	

