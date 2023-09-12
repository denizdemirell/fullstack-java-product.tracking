package demirel.kag.t.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import demirel.kag.t.demo.entity.UrunEntity;
import demirel.kag.t.demo.entity.FabrikaEntity;

public interface GenelService {

	List<UrunEntity> urunAra(String ad);
	
	UrunEntity urunKaydet(UrunEntity body);

	UrunEntity urunGuncelle(UrunEntity body);

	UrunEntity findById(Long id);

	void urunSil(Long id);
	


}

