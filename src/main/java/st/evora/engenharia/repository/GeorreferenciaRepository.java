package st.evora.engenharia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import st.evora.engenharia.model.Contador;
import st.evora.engenharia.model.Georreferencia;

public interface GeorreferenciaRepository  extends JpaRepository<Georreferencia, Long>{
	
	@Query("SELECT g FROM Georreferencia g WHERE CONCAT" + "(g.latitude, " + "g.longitude, " + "g.descricao) LIKE %?1%")
	
	List<Georreferencia> search(String keyword);
	
	@Query("select c from Contador c " +
            "join fetch c.georreferencia " +
            "join fetch c.cliente")
    List<Contador> search();

}
