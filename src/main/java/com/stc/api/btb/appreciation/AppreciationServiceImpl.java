package com.stc.api.btb.appreciation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppreciationServiceImpl implements AppreciationService {
	
	@Autowired
	private AppreciationDao appreciationDao;

	@Override
	public List<Appreciation> findAppreciationsGivenByUser(Integer userId) {
		return appreciationDao.findAppreciationsGivenByUser(userId);
	}

	@Override
	public List<Appreciation> findAppreciationsGivenToUser(Integer userId) {
		return appreciationDao.findAppreciationsGivenToUser(userId);
	}

	@Override
	public Long getAppreciationCount() {
		return appreciationDao.getAppreciationCount();
	}

	@Override
	public Long getAppreciationCountGivenByUser(Integer userId) {
		return appreciationDao.getAppreciationCountGivenByUser(userId);
	}

	@Override
	public Appreciation findAppreciationById(Integer id) {
		return appreciationDao.findAppreciationById(id);
	}

	@Override
	public void addAppreciation(Appreciation empAppreciation) {
		appreciationDao.addAppreciation(empAppreciation);		
	}

	@Override
	public void updateAppreciation(Appreciation empAppreciation) {
		appreciationDao.updateAppreciation(empAppreciation);
	}

	@Override
	public void deleteAppreciation(Integer id) {
		appreciationDao.deleteAppreciation(id);
	}

	@Override
	public void approveAppreciation(Appreciation empAppreciation) {
		appreciationDao.approveAppreciation(empAppreciation);
	}
}
