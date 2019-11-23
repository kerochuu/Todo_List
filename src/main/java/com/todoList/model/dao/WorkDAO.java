package com.todoList.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.todoList.model.vo.Work;


public interface WorkDAO {

	boolean insertWork(Work work) throws SQLException;

	boolean updateWork(Work work) throws SQLException;

	boolean deleteWork(int no) throws SQLException;

	Work getWork(int no) throws SQLException;
	
	List<Work> getWorkListByDate() throws SQLException;

	List<Work> getWorkListByType() throws SQLException;

}
