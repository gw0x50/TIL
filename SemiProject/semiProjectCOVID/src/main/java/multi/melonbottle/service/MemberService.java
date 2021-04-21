package multi.melonbottle.service;

import java.util.List;

import multi.melonbottle.vo.MemberVO;

public interface MemberService {
	public void registerMember(MemberVO vo);
	
	public MemberVO loginMember(String id, String password);
	
	public int checkMember(String id);
	
	public void updateMember(MemberVO vo);

	public void deleteMember(String id);

	public MemberVO selectMember(String id);

	public List<MemberVO> selectAllMember();
}
