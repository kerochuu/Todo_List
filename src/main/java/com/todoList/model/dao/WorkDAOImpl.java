package com.todoList.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.todoList.model.vo.Work;

@Repository
public class WorkDAOImpl implements WorkDAO {

	private SqlSession sqlSession;

	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public boolean insertWork(Work work) throws SQLException {
		return sqlSession.insert("work.insertWork", work) > 0;
	}

	@Override
	public boolean updateWork(Work work) throws SQLException {
		return sqlSession.update("board.updateWork", work) > 0;
	}

	@Override
	public boolean deleteWork(int no) throws SQLException {
		return sqlSession.delete("work.deleteWork", no) > 0;
	}

	@Override
	public List<Work> getWorkListByDate() throws SQLException {
		return sqlSession.selectList("work.getWorkListByDate");
	}
	
	@Override
	public List<Work> getWorkListByType() throws SQLException {
		return sqlSession.selectList("work.getWorkListByType");
	}

	@Override
	public Work getWork(int no) throws SQLException {
		return sqlSession.selectOne("work.getWork", no);
	}

}
