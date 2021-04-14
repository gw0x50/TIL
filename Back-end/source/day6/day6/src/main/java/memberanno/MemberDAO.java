package memberanno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class MemberDAO {
	@Autowired
	@Qualifier
	MemberVO vo;
	public void setMemberVO(MemberVO vo) {
		this.vo = vo;
	}
	
	public boolean selectMember() {
		return vo.getId().equals("spring") && vo.getPw().equals("work"); 
	}
	public void insertMember() {
		System.out.println(vo.getId() + " 회원님 정상 가입되셨습니다.");
	}
}
