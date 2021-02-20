
package util;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import datamodel.data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class databaseUtil {
	static SessionFactory session = null;
	
	public static SessionFactory getSessionFactory() {
		if(session != null)
			return session;
		
		Configuration config = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
		session = config.buildSessionFactory(builder.build());
		return session;
	}
	
	public static List<data> memoList(){
		List<data> result = new ArrayList<>();
		
		Session currSession = getSessionFactory().openSession();
		Transaction trans = null;
		
		try {
			trans = currSession.beginTransaction();
			List<?> memoStack = currSession.createQuery("FROM data").list();
			for(Iterator<?> iter = memoStack.iterator();iter.hasNext();) {
				data memoData = (data)iter.next();
				result.add(memoData);
			}
			trans.commit();
		}
		catch(HibernateException e) {
			if(trans != null)
				trans.rollback();
			e.printStackTrace();
		}
		finally {
			currSession.close();
		}
		return result;
	}
	
	public static List<data> memoList(String keyword){
		List<data> result = new ArrayList<>();
		
		Session currSession = getSessionFactory().openSession();
		Transaction trans = null;
		try {
			trans = currSession.beginTransaction();
			List<?> memoStack = currSession.createQuery("FROM data").list();
			for(Iterator<?> iter = memoStack.iterator(); iter.hasNext();){
				data memoData = (data)iter.next();
				boolean keyWordCheck = memoData.getMemoName().contains(keyword) ||
						memoData.getMemoDate().contains(keyword) ||
						memoData.getMemoDesc().contains(keyword) ||
						memoData.getMemoTime().contains(keyword);
				
				if(keyWordCheck) {
					result.add(memoData);
				}
			}
			trans.commit();
		}
		catch(HibernateException e) {
			if(trans != null)
				trans.rollback();
			e.printStackTrace();
		}
		finally {
			currSession.close();
		}

		return result;
	}
	
	public static void createMemo(String name,String desc, String date, String time) {
		Session currSession = getSessionFactory().openSession();
		Transaction trans = null;
		try {
			trans = currSession.beginTransaction();
			currSession.save(new data(name,desc,date,time));
			trans.commit();
			
		}
		catch(HibernateException e) {
			if(trans != null)
				trans.rollback();
			e.printStackTrace();
		}
		finally {
			currSession.close();
		}
	}
	
	

}
