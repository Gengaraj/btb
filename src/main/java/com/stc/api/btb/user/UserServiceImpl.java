package com.stc.api.btb.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stc.api.btb.appreciation.Appreciation;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public User findUserById(Long id) {
		return userDao.findUserById(id);
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public void deleteUser(Long id) {
		userDao.deleteUser(id);
	}

	@Override
	public List<User> findUserByName(String name) {
		return userDao.findUserByName(name);
	}

	@Override
	public Long getUserCounts() {
		return userDao.getUserCounts();
	}
	
	@Override
	public List<Appreciation> getEmpAprreciations(Long id) {
		return userDao.getEmpAprreciations(id);
	}

}
