package guest.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import guest.dto.visitDTO;

@Component("guestDAO")
public class guestDAO implements IGuestDAO{
	@Autowired
	SqlSession sqlSession;

	@Override
	public void save(visitDTO param) {
		sqlSession.insert("visit.save",param);
	}

	@Override
	public List<visitDTO> selectList() {
		return sqlSession.selectList("visit.selectList");
	}
	
}
