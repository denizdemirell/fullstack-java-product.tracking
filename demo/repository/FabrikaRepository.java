package demirel.kag.t.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import demirel.kag.t.demo.entity.*;

@Repository
public interface FabrikaRepository  extends JpaRepository<FabrikaEntity, Long> {
	
	
}
