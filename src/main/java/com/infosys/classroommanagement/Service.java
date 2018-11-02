package com.infosys.classroommanagement;
import java.util.HashMap;

import com.infosys.util.JSONUtil;
import java.util.Map;

import javax.enterprise.inject.Alternative;





@Alternative
public class Service {

	

		private Map<Integer, Classroom> hmap = new HashMap<Integer, Classroom>();
		private static int classroomid = 1;

		public Boolean searchFunction(String searchName) {

			long entry = hmap.entrySet().stream().filter(eachAccount -> eachAccount.getValue().equals(searchName)).count();

			System.out.println(entry + "With this name");

			if (entry > 0) {
				return true;
			} else

				return false;
			

		}
		

//		public String getAllAccounts() {
//			return util.getJSONForObject(Service.values());
//		}
	//	
//		public String createAccount(String account) {
//			ID++;
//			Account newAccount = util.getObjectForJSON(account, Account.class);
//			accountMap.put(ID, newAccount);
//			return account;
//		}

		public void addAccount(Classroom accountToAdd) {
			hmap.put(classroomid, accountToAdd);
			classroomid++;
		}

		public Classroom searchAccount(Classroom idToSearch) {
			Classroom result = hmap.get("classroomidToSearch");
			return result;
		}

		public void delAccount(Integer idToDel) {
			hmap.remove(idToDel);
		}

		public Map<Integer, Classroom> getAccount() {
			return hmap;
		}

		public void setAccountMap(Map<Integer, Classroom> account) {
			this.hmap = account;
		}

	}

	
	

