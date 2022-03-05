package br.inpe.dpi.terrabrasilis.resource;

import static br.inpe.dpi.terrabrasilis.util.Constants.API;
import static br.inpe.dpi.terrabrasilis.util.Constants.TOOL;
import static br.inpe.dpi.terrabrasilis.util.Constants.V1;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.inpe.dpi.terrabrasilis.domain.Tool;
import br.inpe.dpi.terrabrasilis.service.ToolService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(API + V1 + TOOL)
public class ToolResource implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private final Logger logger = LoggerFactory.getLogger(ToolResource.class);
	
	private final ToolService toolService;
	
	public ToolResource(ToolService toolService) {
		this.toolService = toolService;
	}
	
	@GetMapping("/all")
	public Flux<Tool> getAllTool() {
		logger.debug("REST request to get all Tools");
		return toolService.findAll();
	}
	
	@GetMapping("{id}")
	public Mono<Tool> getToolById(@PathVariable String id) {
		logger.debug("REST request to get the Tool");
		return toolService.findById(id);
	}
}
