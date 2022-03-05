package br.inpe.dpi.terrabrasilis.resource;

import static br.inpe.dpi.terrabrasilis.util.Constants.*;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.inpe.dpi.terrabrasilis.domain.VisionDTO;
import br.inpe.dpi.terrabrasilis.service.VisionToVisionService;
import org.springframework.cache.annotation.Cacheable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(API + V1 + VISION_TO_VISION)
@EnableCaching
public class VisionToVisionResource implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private final Logger logger = LoggerFactory.getLogger(VisionToVisionResource.class);
	
	private final VisionToVisionService visionToVisionService;
	
	public VisionToVisionResource(VisionToVisionService visionToVisionService) {
		this.visionToVisionService = visionToVisionService;
	}
	
	@GetMapping("/all")
        @Cacheable(CACHE_DEFORESTATION)
	public Flux<VisionDTO> getAllVisionDTO() {
		logger.debug("REST request to get all VisionDTO");
		return visionToVisionService.findAll();
	}
	
	@GetMapping("{id}")
	public Mono<VisionDTO> getVisionDTOById(@PathVariable String id) {
		logger.debug("REST request to get the VisionDTO");
		return visionToVisionService.findById(id);
	}
}
