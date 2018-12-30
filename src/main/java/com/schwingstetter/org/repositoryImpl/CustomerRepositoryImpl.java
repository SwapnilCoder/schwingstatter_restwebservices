package com.schwingstetter.org.repositoryImpl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import com.schwingstetter.org.model.Customer;
import com.schwingstetter.org.repository.CustomerRepositoryCustom;

@Transactional
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;
    
   
	@Override
	public Map<String,String> getAllCustomerNames() {
	 
		Map<String,String> custById=new HashMap<String,String>();
		
		Query q=entityManager.createNativeQuery("select c.cust_id,c.name from Customer c");
		System.out.println("Executing Query");
		List<Object> result=q.getResultList();
		Iterator itr=result.iterator();
		
		while(itr.hasNext())
		{
			Object[] row=(Object[]) itr.next();
			String cust_id=String.valueOf(row[0]);
			String name=String.valueOf(row[1]);
		System.out.println(name+" "+cust_id);
			custById.put(cust_id, name);
		}
		return custById;
   
	}

}
