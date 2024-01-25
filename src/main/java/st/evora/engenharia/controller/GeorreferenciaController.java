package st.evora.engenharia.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.lowagie.text.DocumentException;

import st.evora.engenharia.ClientePDFExporter;
import st.evora.engenharia.GeorreferenciaPDFExporter;
import st.evora.engenharia.model.Cliente;
import st.evora.engenharia.model.Georreferencia;
import st.evora.engenharia.repository.ClienteRepository;
import st.evora.engenharia.repository.GeorreferenciaRepository;
import st.evora.engenharia.service.ClienteService;
import st.evora.engenharia.service.GeorreferenciaService;

@Controller
@RequestMapping("/georreferencia")
public class GeorreferenciaController {

	@Autowired
	GeorreferenciaService georreferenciaService;

	@Autowired
	GeorreferenciaRepository georreferenciaRepository;
	
	public static String  uploadDirectory = System.getProperty("user.dir") + "/src/main/webapp/imagedata";
	
	/* BEGIN MÉTODO LISTAR TODOS COORDENADA */
	
	@RequestMapping("/getAll")
	@GetMapping()
	public String viewHomePage(Model model, @Param("keyword") String keyword) {
		List<Georreferencia> listGeorreferencia = georreferenciaService.listAll(keyword);
		model.addAttribute("listGeorreferencia", listGeorreferencia);
		model.addAttribute("keyword", keyword);

		return findPaginated(1, "descricao", "asc", model);

	}
	
	/* END MÉTODO LISTAR TODOS COORDENADA */

	/* BEGIN PAGINATION GENERATED */

	@GetMapping("/getAll/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir, Model model) {
		int pageSize = 4;

		Page<Georreferencia> page = georreferenciaService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Georreferencia> listGeorreferencia = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listGeorreferencia", listGeorreferencia);
		return "georreferencia";
	}
	/* END PAGINATION GENERATED */

	/* BEGIN endPoints pegarCoordenadaPorID */
	
	@RequestMapping("/getOne")
	@ResponseBody
	public Optional<Georreferencia> getOne(Model model, long Id) {
		return georreferenciaService.getOne(Id);
	}

	/* BEGIN endPoints pegarCoordenadaPorID */

	
	/* BEGIN endPoints adicionarNovaCoordenada */
	
	@PostMapping("/addNew")
	public String addNew(Georreferencia georreferencia, BindingResult result, RedirectAttributes attributes) {
		georreferenciaService.addNew(georreferencia);
		
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/georreferencia/getAll";
			
		}
		attributes.addFlashAttribute("mensagem", "Coordenada com Latitude " + georreferencia.getLatitude() + " e Longitude " + georreferencia.getLongitude() +  " Adicionado com sucesso!");
		return "redirect:/georreferencia/getAll";
	}

	/* END endPoints adicionarNovaCoordenada */

	
	/* BEGIN endPoints updateCoordenada */

	@RequestMapping(value = "/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Georreferencia georreferencia) {
		georreferenciaService.update(georreferencia);
		return "redirect:/georreferencia/getAll";
	}

	/* BEGIN endPoints updateCoordenada */

	
	/* BEGIN endPoints deleteCoordenada */

	@RequestMapping(value = "/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(Long Id) {
		georreferenciaService.delete(Id);
		return "redirect:/georreferencia/getAll";
	}

	/* BEGIN endPoints deleteCoordenada */

	
	/* BEGIN PDF GENERATED */

	@GetMapping("/georreferencia/export/pdf")
	public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=georreferencias" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		List<Georreferencia> listGeorreferencia = georreferenciaService.listPdfGeorreferencia();

		GeorreferenciaPDFExporter exporter = new GeorreferenciaPDFExporter(listGeorreferencia);
		exporter.export(response);

	}

}
