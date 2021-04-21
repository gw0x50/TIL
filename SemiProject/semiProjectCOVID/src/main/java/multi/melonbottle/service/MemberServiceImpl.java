package multi.melonbottle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import multi.melonbottle.dao.MemberDAO;
import multi.melonbottle.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO dao;
	
	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public void registerMember(MemberVO vo) {
		dao.registerMember(vo);
	}

	@Override
	public MemberVO loginMember(String id, String password) {
		return dao.loginMember(id, password);
	}
	
	@Override
	public int checkMember(String id) {
		return dao.checkMember(id);
	}

	@Override
	public void updateMember(MemberVO vo) {
		dao.updateMember(vo);
	}

	@Override
	public void deleteMember(String id) {
		dao.deleteMember(id);
	}

	@Override
	public MemberVO selectMember(String id) {
		return dao.selectMember(id);
	}

	@Override
	public List<MemberVO> selectAllMember() {
		return dao.selectAllMember();
	}

}
