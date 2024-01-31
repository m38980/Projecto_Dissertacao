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
@RequestMapping("/map")
public class MapController {

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
	@RequestMapping("/getAllmap")
	@GetMapping()
	public String map() {
		//List<Contador> listContadores = contadorService.listAll(keyword);
		return "map";

	}
	/*
	 * @RequestMapping("/contador") public class ContadorController {
	 * 
	 * @Autowired private ContadorRepository contadorRepository;
	 * 
	 * @GetMapping("/list") public List<Contador> listContador() { return
	 * contadorRepository.findAll(); } }
	 */
	
}