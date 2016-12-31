package guest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import guest.dto.visitDTO;

public interface IGuestService {
	public void save(visitDTO param);

	public List<visitDTO> selectList();
}
