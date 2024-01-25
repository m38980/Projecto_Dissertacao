package st.evora.engenharia.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import st.evora.engenharia.model.Contador;
import st.evora.engenharia.model.Georreferencia;
import st.evora.engenharia.repository.GeorreferenciaRepository;

@Service
@Transactional
@RestController
@RequestMapping("/contador_1")
public class GeorreferenciaService {
	
	@Autowired
    GeorreferenciaRepository georreferenciaRepository;
	

	/* BEGIN listarTODOS Coordenadas método (listAll) */ 
	public List<Georreferencia> listAll(String keyword) {
		if (keyword != null) {
			return georreferenciaRepository.search(keyword);
		}
		return (List<Georreferencia>) georreferenciaRepository.findAll();
	}
	/* END listarTODOS Coordenadas */ 
	
	
	/* BEGIN paginação */
	
	public Page<Georreferencia> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection){
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return georreferenciaRepository.findAll(pageable);
	}
	
	/* END paginação */ 
	
	/* BEGIN selecionar Por ID */ 
	
	public Optional<Georreferencia> getOne(Long Id) {
		return georreferenciaRepository.findById(Id);
	}
	/* BEGIN selecionar Por ID */ 
	
	/* BEGIN adiconar Coordenada */ 
	public void addNew(Georreferencia georreferencia) {
		georreferenciaRepository.save(georreferencia);
	}
	/* END adiconar Coordenada */ 
	
	/* BEGIN ACTUALIZAR Coordenada */ 
	public void update(Georreferencia georreferencia) {
		georreferenciaRepository.save(georreferencia);
	}
	/* END ACTUALIZAR Coordenada */ 
	
	/* BEGIN DELETE Coordenada */ 
	public void delete(Long Id) {
		georreferenciaRepository.deleteById(Id);
	}
	/* END DELETE Coordenada */ 
	
	/* BEGIN GERAR PDF */
	
	public List<Georreferencia> listPdfGeorreferencia() {
        return (List<Georreferencia>) georreferenciaRepository.findAll();
    }
	/* END GERAR PDF */
	
	
/* BEGIN PINTAR MAPA */
	@RequestMapping("/lista")
	@GetMapping
	public List<Contador> resumo() {
        return georreferenciaRepository.search();
    }
	/* END GERAR PDF */
}
