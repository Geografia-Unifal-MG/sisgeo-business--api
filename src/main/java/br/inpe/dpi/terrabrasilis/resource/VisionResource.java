package br.inpe.dpi.terrabrasilis.resource;

import static br.inpe.dpi.terrabrasilis.util.Constants.*;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.inpe.dpi.terrabrasilis.domain.Vision;
import br.inpe.dpi.terrabrasilis.domain.VisionDTO;
import br.inpe.dpi.terrabrasilis.exception.VisionNotFoundException;
import br.inpe.dpi.terrabrasilis.service.VisionService;
import br.inpe.dpi.terrabrasilis.service.VisionToVisionService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(API + V1 + VISION)
@CrossOrigin(maxAge = 3600)
@EnableCaching
public class VisionResource implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private final Logger logger = LoggerFactory.getLogger(VisionResource.class);
	
	private final VisionService visionService;
	private final VisionToVisionService visionToVisionService;
	
	public VisionResource(VisionService visionService, VisionToVisionService visionToVisionService) {
		this.visionService = visionService;
		this.visionToVisionService = visionToVisionService;
	}
	
	@GetMapping("/all")
	@CrossOrigin()         
	public Flux<Vision> getAllVision() {
		logger.debug("REST request to get all Vision");
		return visionService.findAll();
	}
	
	@GetMapping("{id}")
	public Mono<Vision> getVisionById(@PathVariable String id) {
		logger.debug("REST request to get the Vision by id");
		return visionService.findById(id);
	}

	@GetMapping("/name/{name}")
	public Mono<Vision> getVisionByName(@PathVariable String name) {
		logger.debug("REST request to get the Vision name");

		Vision vision = visionService.findByName(name).blockOptional().orElseThrow(VisionNotFoundException::new);

		return Mono.just(vision);
	}

	@GetMapping("/name/{name}/all")
	@CrossOrigin()
	@Cacheable(CACHE_DEFORESTATION)
	public Flux<VisionDTO> getAllVisionByName(@PathVariable String name) {
		logger.debug("REST request to get the all Vision name");

		Vision vision = visionService.findByName(name).blockOptional().orElseThrow(VisionNotFoundException::new);								
		
		return visionToVisionService.findByRoot(vision);
	}
}
