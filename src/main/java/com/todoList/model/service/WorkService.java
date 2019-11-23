package com.todoList.model.service;

import java.sql.SQLException;
import java.util.List;

import com.todoList.model.vo.Work;

public interface WorkService {
	
	boolean addWork(Work work) throws SQLException;

	Work getWork(int no) throws SQLException;

	boolean modifyWork(Work work) throws SQLException;

	boolean deleteWork(int no) throws SQLException;

	List<Work> getWorkListByDate() throws SQLException;

	List<Work> getWorkListByType() throws SQLException;

}
