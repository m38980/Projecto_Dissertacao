package st.evora.engenharia.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.lowagie.text.DocumentException;
import st.evora.engenharia.ContadorPDFExporter;
import st.evora.engenharia.model.Cliente;
import st.evora.engenharia.model.Contador;
import st.evora.engenharia.model.Georreferencia;
import st.evora.engenharia.repository.ContadorRepository;
import st.evora.engenharia.repository.GeorreferenciaRepository;
import st.evora.engenharia.service.ClienteService;
import st.evora.engenharia.service.ContadorService;

@Controller
@RequestMapping("/contadores")
public class ContadorController {

	@Autowired
	ContadorService contadorService;

	@Autowired
	ClienteService clienteService;

	@Autowired
	ContadorRepository contadorRepository;
	
	@Autowired
	GeorreferenciaRepository georreferenciaRepository;

	/*public ContadorController(ContadorService contadorService) {
		super();
		this.contadorService = contadorService;
	}
	*/
	@RequestMapping("/getAll")
	@GetMapping()
	public String viewHomePage(Model model, @Param("keyword") String keyword) {
		List<Contador> listContadores = contadorService.listAll(keyword);
		model.addAttribute("listContadores", listContadores);
		model.addAttribute("keyword", keyword);
		
		//model.addAttribute("cliente", new Cliente());
    	model.addAttribute("listClientes", contadorService.getAllClientes());
    	
    	//model.addAttribute("georreferencia", new Georreferencia());
    	model.addAttribute("listGeorreferencia", contadorService.getAllGeorreferencia());
    	
		return findPaginated(1, "idcontador", "asc", model);

	}
	
	/* BEGIN endPoints adicionarNovoContador */
	@PostMapping("/addNew")
	public String addNew(Model model, @Param("cliente") Cliente cliente, @Param("georreferencia") Georreferencia georreferencia,
			Contador contador, 
			BindingResult result, 
			RedirectAttributes attributes) {
			contadorService.addNew(contador);
			
			contadorService.saveCliente(cliente);
			contadorService.saveGeorreferencia(georreferencia);

			model.addAttribute("cliente", new Cliente());
	    	model.addAttribute("cliente", contadorService.getAllClientes());
	    	
	    	model.addAttribute("georreferencia", new Georreferencia());
	    	model.addAttribute("georreferencia", contadorService.getAllGeorreferencia());

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/contadores/getAll";
		}
		attributes.addFlashAttribute("mensagem", "Contador" + contador.getNumero_contador() + "Adicionado com sucesso!");
		return "redirect:/contadores/getAll";
	}

	/* END endPoints adicionarNovoContador */

	/* BEGIN PAGINATION GENERATED */

	@GetMapping("/getAll/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir, Model model) {
		int pageSize = 4;

		Page<Contador> page = contadorService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Contador> listContadores = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listContadores", listContadores);
		return "contadores";
	}
	
	
	  @GetMapping("/detalhes/{id}") 
	  public String getOne(@PathVariable("id") final int id, final Model model) {
	  
	  Contador contador = contadorService.findById(id); 
	  model.addAttribute("contador", contador); 
	  return "contadorDetalhe"; 
	  }
	  
	/* END PAGINATION GENERATED */

	/* BEGIN endPoints pegarContadorPorID */
	
	  @RequestMapping("/getOne")
	  @ResponseBody 
	  public Optional<Contador> getOne(Model model, Long Id) {
	  Optional<Contador> contador = contadorService.getOne(Id); 
	  model.addAttribute("Contador", contador); 
	  return contadorService.getOne(Id);
	  }
	 

	/* BEGIN endPoints pegarContadorPorID */
	/*
	@PostMapping("/update/{id}")
	public String updateContador(@ModelAttribute("contador") Contador contador, @PathVariable(name = "id") Long id) {
		Contador contadorActual = contadorRepository.findById(id).orElse(null);

		if (contadorActual != null) {

			BeanUtils.copyProperties(contador, contadorActual, "idcontador");
			contadorService.save(contadorActual);

		}

		return "redirect:/contadores/getAll";
	}
	*/
	
	/* BEGIN endPoints updateContador */
	
	@RequestMapping(value = "/update",  method = { RequestMethod.PUT, RequestMethod.GET })
	//este tem Contador é o teu model, q ai todas as variaveis q estºao ai, estao no teu front
	public String update(Contador contador, BindingResult result, RedirectAttributes attributes) {
		
		contadorService.update(contador);
		contadorService.save(contador);
		
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/contadores/getAll";
		}
		attributes.addFlashAttribute("mensagem", "Contador" + contador.getNumero_contador() + "Contador modificado com sucesso!");
		return "redirect:/contadores/getAll";
		//contadorService.saveCliente(cliente);
	}
	
	/* END endPoints updateContador */
	
	/* BEGIN endPoints deleteContador */

	@RequestMapping(value = "/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(Long Id) {
		contadorService.delete(Id);
		return "redirect:/contadores/getAll";
	}

	/* BEGIN endPoints deleteContador */

	/* BEGIN PDF GENERATED */

	@GetMapping("/contadores/export/pdf")
	public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=contadores_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		List<Contador> listContadores = contadorService.listPdfContador();

		ContadorPDFExporter exporter = new ContadorPDFExporter(listContadores);
		exporter.export(response);

	}

	/* END PDF GENERATED */

}