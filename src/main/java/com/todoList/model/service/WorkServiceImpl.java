package com.todoList.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoList.model.dao.WorkDAO;
import com.todoList.model.vo.Work;

@Service("workService")
public class WorkServiceImpl implements WorkService {

	private WorkDAO workDao;
	@Autowired
	public void setWorkDao(WorkDAO workDao) {
		this.workDao = workDao;
	}
	
	@Override
	public boolean addWork(Work work) throws SQLException {
		return workDao.insertWork(work);
	}

	@Override
	public Work getWork(int no) throws SQLException {
		return workDao.getWork(no);
	}

	@Override
	public boolean modifyWork(Work work) throws SQLException {
		return workDao.updateWork(work);
	}

	@Override
	public boolean deleteWork(int no) throws SQLException {
		// TODO Auto-generated method stub
		return workDao.deleteWork(no);
	}

	@Override
	public List<Work> getWorkListByDate() throws SQLException {
		return workDao.getWorkListByDate();
	}
	@Override
	public List<Work> getWorkListByType() throws SQLException {
		return workDao.getWorkListByType();
	}
	
	

}
