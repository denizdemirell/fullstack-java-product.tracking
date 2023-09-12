package demirel.kag.t.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demirel.kag.t.demo.entity.UrunEntity;
import demirel.kag.t.demo.repository.UrunRepository;
import demirel.kag.t.demo.service.GenelService;

@RestController
@RequestMapping("api/urun")
@CrossOrigin("*")
public class UrunController {
	
	@Autowired
    private UrunRepository urunRepository;
 
	@Autowired
    private GenelService genelService;
	
    @GetMapping(path = "/getAll")
    public List<UrunEntity> getUrun() {
        return urunRepository.findAll();
    }
    
    @GetMapping(path = "/getUrun/{id}")
 	public UrunEntity findUrunById(@PathVariable Long id) {
 		return urunRepository.findUrunWithId(id);
 	}
    
    @GetMapping(path = "/getUrunWithName/{name}")
   	public List<UrunEntity> getUrunWithName(@PathVariable String name) {
   		return urunRepository.getUrunWithName(name);
   	}
    
    @GetMapping(path = "/ara/{name}")
	public List<UrunEntity> urunAra(@PathVariable String name) {
		return genelService.urunAra(name);
	}
    
    
    @PostMapping("/urunKaydet")
	public UrunEntity urunKaydet(@RequestBody UrunEntity body) {
    	UrunEntity userEntity = genelService.urunKaydet(body);
		return userEntity;
	}
    
    @PutMapping("/urunGuncelle")
   	public UrunEntity urunGuncelle(@RequestBody UrunEntity body) {
    	UrunEntity urunEntity = genelService.urunGuncelle(body);
   		return urunEntity;
   	}
  
    @DeleteMapping("/delete/{id}")
   	public Boolean deleteUrun(@PathVariable Long id) {
   		
    	UrunEntity urun = genelService.findById(id);
   		if (urun == null) {
   			return false;
   		} else {
   			genelService.urunSil(id);
   			return true;
   		}
   		
   		
   	}

}
