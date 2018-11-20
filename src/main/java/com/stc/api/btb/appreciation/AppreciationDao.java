package com.stc.api.btb.appreciation;

import java.util.List;

public interface AppreciationDao {
	List<Appreciation> findAppreciationsGivenByUser(Integer userId);
	List<Appreciation> findAppreciationsGivenToUser(Integer userId);
	Long getAppreciationCount();
	Long getAppreciationCountGivenByUser(Integer userId);
	Appreciation findAppreciationById(Integer id);
	void addAppreciation(Appreciation empAppreciation);
	void updateAppreciation(Appreciation empAppreciation);
	void deleteAppreciation(Integer id);
	public void approveAppreciation(Appreciation empAppreciation);

}
