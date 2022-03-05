package br.inpe.dpi.terrabrasilis.resource;

import static br.inpe.dpi.terrabrasilis.util.Constants.API;
import static br.inpe.dpi.terrabrasilis.util.Constants.LAYER;
import static br.inpe.dpi.terrabrasilis.util.Constants.V1;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.inpe.dpi.terrabrasilis.domain.Layer;
import br.inpe.dpi.terrabrasilis.service.LayerService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(API + V1 + LAYER)
public class LayerResource implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private final Logger logger = LoggerFactory.getLogger(LayerResource.class);
	
	private final LayerService layerService;

	public LayerResource(LayerService layerService) {
		this.layerService = layerService;
	}

	@GetMapping("/all")
	public Flux<Layer> getAllLayer() {
		logger.debug("REST request to get all Layer");
		return layerService.findAll();
	}
	
	@GetMapping("{id}")
	public Mono<Layer> getLayerById(@PathVariable String id) {
		logger.debug("REST request to get the Layer");
		return layerService.findById(id);
	}
}