package st.evora.engenharia.service;

import java.util.Collection;
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

import st.evora.engenharia.model.Cliente;
import st.evora.engenharia.model.Contador;
import st.evora.engenharia.model.Georreferencia;
import st.evora.engenharia.repository.ClienteRepository;
import st.evora.engenharia.repository.ContadorRepository;
import st.evora.engenharia.repository.GeorreferenciaRepository;

@Service
@Transactional
public class ContadorService {

	@Autowired
	private ContadorRepository contadorRepository;

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private GeorreferenciaRepository georreferenciaRepository;

	/* BEGIN listarTODOS Contador método (listAll) */
	public List<Contador> listAll(String keyword) {
		if (keyword != null) {
			return contadorRepository.search(keyword);
		}
		return (List<Contador>) contadorRepository.findAll();
	}
	/* END listarTODOS Contador */

	/* BEGIN paginação */

	public Page<Contador> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return contadorRepository.findAll(pageable);
	}

	/* END paginação */

	/* BEGIN selecionar Por ID */

	public Optional<Contador> getOne(Long Id) {
		return contadorRepository.findById(Id);
	}
	/* BEGIN selecionar Por ID */
	
	public Contador findById(final int id) {
		return contadorRepository.getById((long) id);
	}
	
	/* BEGIN adiconar Contador */
	public void addNew(Contador contador) {
		contadorRepository.save(contador);
	}
	/* END adiconar Contador */

	/* BEGIN ACTUALIZAR Contador */
	public void update(Contador contador) {
		contadorRepository.save(contador);
	}
	/* END ACTUALIZAR Contador */

	/* BEGIN DELETE Contador */
	public void delete(Long Id) {
		contadorRepository.deleteById(Id);
	}
	/* END DELETE Contador */

	/* BEGIN gerarPDF Contador */
	public List<Contador> listPdfContador() {
		return (List<Contador>) contadorRepository.findAll();
	}
	/* END gerarPDF Contador */

	/*
	@SuppressWarnings("unused")
	private Contador addClientesToContador(Contador c, String listClientes) {
		String[] cli = listClientes.split("idcliente");
		Cliente cliente = null;
		for (String str : cli) {
			cliente = clienteRepository.findById((int) Long.parseLong((String) str)).get();
			c.getClientes().addAll((Collection<? extends Contador>) cliente);
		}
		return c;
	}
	*/
	public Cliente saveCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public List<Cliente> getAllClientes() {

		return clienteRepository.findAll();
	}
	
	public Georreferencia saveGeorreferencia(Georreferencia georreferencia) {
		return georreferencia.save(georreferencia);
	}
	
	public List<Georreferencia> getAllGeorreferencia(){
		return georreferenciaRepository.findAll();
	}

	public void save(Contador contador) {
		contadorRepository.save(contador);
	}
	@RestController
	@RequestMapping("/contador")
	public class ContadorController {
	    @Autowired
	    private ContadorRepository contadorRepository;

	    @GetMapping("/list")
	    public List<Contador> listPdfGeorreferencia() {
	        return contadorRepository.findAll();
	    }
	}
}