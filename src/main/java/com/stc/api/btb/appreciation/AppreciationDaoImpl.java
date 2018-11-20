package com.stc.api.btb.appreciation;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class AppreciationDaoImpl implements AppreciationDao {

	
	@PersistenceContext	
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Appreciation> findAppreciationsGivenByUser(Integer userId) {
		String hql ="From Appreciation as appreciation where appreciation.givenBy="+userId;
		return (List<Appreciation>)entityManager.createQuery(hql).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appreciation> findAppreciationsGivenToUser(Integer userId) {
		// TODO Auto-generated method stub
		String hql ="From Appreciation as appreciation where appreciation.givenTo="+userId;
		return (List<Appreciation>)entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Long getAppreciationCount() {
		String hql = "select count(*) as count from Appreciation as appreciation";
		return (Long) entityManager.createQuery(hql).getSingleResult();
	}

	@Override
	public Long getAppreciationCountGivenByUser(Integer userId) {
		String hql = "select count(*) as count from Appreciation as appreciation where appreciation.givenBy="+userId;
		return (Long) entityManager.createQuery(hql).getSingleResult();
	}

	@Override
	public Appreciation findAppreciationById(Integer id) {
		Appreciation empAppreciation = (Appreciation)entityManager.find(Appreciation.class, id);
		return empAppreciation;
	}

	@Override
	public void addAppreciation(Appreciation empAppreciation) {
		entityManager.persist(empAppreciation);
		
	}

	@Override
	public void updateAppreciation(Appreciation empAppreciation) {
		Appreciation appreciation = findAppreciationById(empAppreciation.getAppreciationId());
		appreciation.setAppreciationNote(empAppreciation.getAppreciationNote());
		if(empAppreciation.getAppreciationStatus()==('A') && appreciation.getAppreciationStatus()!='A'){
			appreciation.setAppreciationStatus(empAppreciation.getAppreciationStatus());
			appreciation.setApprovedDate(new Timestamp(System.currentTimeMillis()));
		}
		appreciation.setApprovedBy(empAppreciation.getApprovedBy());
		appreciation.setUpdatedBy(empAppreciation.getUpdatedBy());
		appreciation.setUpdatedTimeStamp(new Timestamp(System.currentTimeMillis()));
		entityManager.flush();
	}

	@Override
	public void deleteAppreciation(Integer id) {
		Appreciation appreciation = findAppreciationById(id);
		appreciation.setUpdatedTimeStamp(new Timestamp(System.currentTimeMillis()));
		appreciation.setDeletedTimeStamp(new Timestamp(System.currentTimeMillis()));
		appreciation.setAppreciationStatus('I');
		entityManager.flush();
	}
	
	@Override
	public void approveAppreciation(Appreciation empAppreciation) {
		empAppreciation= findAppreciationById( empAppreciation.getAppreciationId());
		empAppreciation.setUpdatedTimeStamp(new Timestamp(System.currentTimeMillis()));
		empAppreciation.setDeletedTimeStamp(new Timestamp(System.currentTimeMillis()));
		empAppreciation.setApprovedDate(new Timestamp(System.currentTimeMillis()));
		empAppreciation.setAppreciationStatus('A');
		entityManager.flush();
	}
	
	
}
