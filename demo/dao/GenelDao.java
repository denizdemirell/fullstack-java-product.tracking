package demirel.kag.t.demo.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.*;
import demirel.kag.t.demo.entity.UrunEntity;
import demirel.kag.t.demo.entity.FabrikaEntity;

@Repository
@Transactional
public class GenelDao {
	
	@PersistenceContext
	EntityManager em;
	
	public List<UrunEntity> urunAra(String ad) {
		List<UrunEntity> obj = new ArrayList<UrunEntity>();
		try {
			String sql = "Select u from UrunEntity u where UPPER(u.urun_adi) like UPPER(:pattern) ";
			
			Query query = em.createQuery(sql);
			query.setParameter("pattern", "%"+ad+"%");
			obj = query.getResultList();

		} catch (Exception e) {
			return null;
		}
		return obj;
	}

}