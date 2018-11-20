package com.stc.api.btb.user;

import java.util.List;

import com.stc.api.btb.appreciation.Appreciation;

public interface UserService {
	
	List<User> getAllUsers();
	Long getUserCounts();
	User findUserById(Long id);
	void addUser(User user);
	void updateUser(User user);
	void deleteUser(Long id);
	List<User> findUserByName(String name);
	List<Appreciation> getEmpAprreciations(Long id);

}
