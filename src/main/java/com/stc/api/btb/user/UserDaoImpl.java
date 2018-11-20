package com.stc.api.btb.user;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stc.api.btb.appreciation.Appreciation;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {
	
	@PersistenceContext	
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		String hql = "FROM User as user ORDER BY user.userName ASC";
		return (List<User>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Long getUserCounts(){
		String hql = "select count(*) as count from User as user";
		return (Long) entityManager.createQuery(hql).getSingleResult();
	}
	
	
	@Override
	public User findUserById(Long id) {
		User user=  entityManager.find(User.class, id);
		return user;
	}

	@Override
	public void addUser(User user) {
		entityManager.persist(user);
	}

	@Override
	public void updateUser(User user) {
		User usr = findUserById(user.getId());
		usr.setUpdatedOn(new Timestamp(System.currentTimeMillis()));
		entityManager.flush();
	}

	@Override
	public void deleteUser(Long id) {
		User usr = findUserById(id);
		usr.setUpdatedOn(new Timestamp(System.currentTimeMillis()));
		usr.setDeletedOn(new Timestamp(System.currentTimeMillis()));
		usr.setUserStatus('I');
		entityManager.flush();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findUserByName(String name) {
		String query = "select * FROM USR_MST where upper(USER_FIRST_NAME) like upper('%"+name+"%') or upper(USER_LAST_NAME) like upper('%"+name+"%') or upper(USER_NAME) like upper('%"+name+"%') ORDER BY USER_FIRST_NAME";
		return (List<User>) entityManager.createNativeQuery(query, User.class).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Appreciation> getEmpAprreciations(Long id) {
		String hql = "FROM Appreciation as empAppreciation where empAppreciation.givenTo="+id;
		return (List<Appreciation>) entityManager.createQuery(hql).getResultList();
	}
	
	
}
