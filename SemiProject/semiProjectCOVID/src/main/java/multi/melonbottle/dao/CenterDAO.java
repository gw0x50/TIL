package multi.melonbottle.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import multi.melonbottle.vo.CenterVO;

@Repository
public class CenterDAO {
	
	@Autowired
	private SqlSession session;
	
	public List<CenterVO> selectAllCenter() {
		return session.selectList("center.selectAllCenter");
	}
}
