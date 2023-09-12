package demirel.kag.t.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demirel.kag.t.demo.dao.GenelDao;
import demirel.kag.t.demo.entity.UrunEntity;
import demirel.kag.t.demo.repository.UrunRepository;
import demirel.kag.t.demo.service.GenelService;

@Service
public class GenelServiceImpl implements GenelService {
	
	@Autowired
	private GenelDao genelDao;
	
	@Autowired
	private UrunRepository urunRepository;

	@Override
	public List<UrunEntity> urunAra(String ad) {
		return genelDao.urunAra(ad);
	}
	
	@Override
	public UrunEntity urunKaydet(UrunEntity body) {
		UrunEntity entity = urunRepository.saveAndFlush(body);
		return entity;
	}

	@Override
	public UrunEntity urunGuncelle(UrunEntity body) {
		UrunEntity entity = urunRepository.saveAndFlush(body);
		return entity;
	}

	@Override
	public UrunEntity findById(Long id) {
		Optional<UrunEntity> urunEnt = urunRepository.findById(id);

		if (urunEnt.isPresent())
			return urunEnt.get();
		else
			return null;
	}

	@Override
	public void urunSil(Long id) {
		urunRepository.deleteById(id);
		
	}
	
	

}

