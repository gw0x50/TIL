package memberservice;

public class MemberServiceImpl implements MemberService {
	MemberDAO dao;

	public void setMemberDAO(MemberDAO dao) {
		this.dao = dao;
	}

	public void register() {
		if (!dao.selectMember()) dao.insertMember();
	}

	@Override
	public void login() {
		if (dao.selectMember()) System.out.println("정상 로그인 사용자");
	}
}
