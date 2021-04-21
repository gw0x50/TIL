package multi.melonbottle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import multi.melonbottle.dao.CenterDAO;
import multi.melonbottle.vo.CenterVO;

@Service
public class CenterServiceImpl implements CenterService {

	@Autowired
	private CenterDAO dao;
	
	public void setDao(CenterDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<CenterVO> selectAllCenter() {
		return dao.selectAllCenter();
	}

}
