package demirel.kag.t.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import demirel.kag.t.demo.entity.UrunEntity;


@Repository
public interface UrunRepository extends JpaRepository<UrunEntity, Long> {
	
	@Query("SELECT u FROM UrunEntity u WHERE u.id = ?1")
	UrunEntity findUrunWithId(Long id);
	
	@Query("SELECT u FROM UrunEntity u WHERE u.urun_adi = ?1 ")
	List<UrunEntity> getUrunWithName(String urun_adi);
	
	
	
	
	
}
