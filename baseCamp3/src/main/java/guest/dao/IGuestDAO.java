package guest.dao;

import java.util.ArrayList;
import java.util.List;

import guest.dto.visitDTO;

public interface IGuestDAO {

	public void save(visitDTO param);

	public List<visitDTO> selectList();

}
