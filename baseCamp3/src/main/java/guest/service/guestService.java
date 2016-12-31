package guest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import guest.dao.IGuestDAO;
import guest.dto.visitDTO;

@Component("guestService")
public class guestService implements IGuestService{
	@Autowired 
	IGuestDAO guestDao;
	
	@Override
	public void save(visitDTO param) {
		guestDao.save(param);
	}

	@Override
	public List<visitDTO> selectList() {
		return guestDao.selectList();
	}
	
	
}
