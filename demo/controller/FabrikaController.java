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
import demirel.kag.t.demo.entity.FabrikaEntity;
import demirel.kag.t.demo.repository.UrunRepository;
import demirel.kag.t.demo.repository.FabrikaRepository;
import demirel.kag.t.demo.service.GenelService;

@RestController
@RequestMapping("api/fabrikalar")
@CrossOrigin("*")
public class FabrikaController {
	
	@Autowired
    private FabrikaRepository repository;
	
	@Autowired
    private GenelService genelService;
 
    @GetMapping(path = "/getAll")
    public List<FabrikaEntity> getUrun() {
        return repository.findAll();
    }
}