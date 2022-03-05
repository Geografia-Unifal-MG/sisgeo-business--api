package br.inpe.dpi.terrabrasilis.resource;

import static br.inpe.dpi.terrabrasilis.util.Constants.API;
import static br.inpe.dpi.terrabrasilis.util.Constants.DATASOURCE;
import static br.inpe.dpi.terrabrasilis.util.Constants.V1;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.inpe.dpi.terrabrasilis.domain.Datasource;
import br.inpe.dpi.terrabrasilis.enuns.DatasourceType;
import br.inpe.dpi.terrabrasilis.service.DatasourceService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(API + V1 + DATASOURCE)
//@CrossOrigin(origins = "http://example.com", maxAge = 3600)
@CrossOrigin(maxAge = 3600)
public class DatasourceResource implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private final Logger logger = LoggerFactory.getLogger(DatasourceResource.class);
	
	private final DatasourceService datasourceService;
	
	public DatasourceResource(DatasourceService datasourceService) {
		this.datasourceService = datasourceService;
	}
	
	@CrossOrigin()
	@GetMapping("/all")
	public Flux<Datasource> getAllDatasource() {
		logger.debug("REST request to get all Datasource");
		return datasourceService.findAll();
	}
	
	@CrossOrigin()
	@GetMapping("{id}")
	public Mono<Datasource> getDatasourceById(@PathVariable String id) {
		logger.debug("REST request to get the Datasource");
		return datasourceService.findById(id);
	}
	
	@CrossOrigin()
	@GetMapping("{type}/type")
	public Flux<Datasource> getDatasourceByType(@PathVariable String type) {
		logger.debug("REST request to get the Datasource by DatasourceType");
		DatasourceType typeToSearch = DatasourceType
										.stream()
										.filter(t -> t.getType().equals(type.toUpperCase()))
										.map(d -> d)
										.findAny()
										.get();
		
		return datasourceService.findByType(typeToSearch);
	}
}
