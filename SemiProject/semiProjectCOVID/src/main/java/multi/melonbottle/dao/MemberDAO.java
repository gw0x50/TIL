package multi.melonbottle.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import multi.melonbottle.vo.MemberVO;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession session;
	
	public void registerMember(MemberVO vo) {
		session.insert("member.registerMember", vo);
	}
	
	public MemberVO loginMember(String id, String password) {
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPassword(password);
		
		return session.selectOne("member.loginMember", vo);
	}
	
	public int checkMember(String id) {
		return session.selectOne("member.checkMember", id);
	}
	
	public void updateMember(MemberVO vo) {
		session.update("member.updateMember", vo);
	}

	public void deleteMember(String id) {
		session.delete("member.deleteMember", id);
	}

	public MemberVO selectMember(String id) {
		return session.selectOne("member.selectMember", id);
	}

	public List<MemberVO> selectAllMember() {
		return session.selectList("member.selectAllMember");
	}
}
