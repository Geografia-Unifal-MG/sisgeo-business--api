package br.inpe.dpi.terrabrasilis.resource;

import br.inpe.dpi.terrabrasilis.domain.Metadata;
import br.inpe.dpi.terrabrasilis.service.MetadataService;
import static br.inpe.dpi.terrabrasilis.util.Constants.API;
import static br.inpe.dpi.terrabrasilis.util.Constants.METADATA;
import static br.inpe.dpi.terrabrasilis.util.Constants.V1;
import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(API + V1 + METADATA)
public class MetadataResource implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private final Logger logger = LoggerFactory.getLogger(MetadataResource.class);

    private final MetadataService metadataService;

    public MetadataResource(MetadataService metadataService){
        this.metadataService = metadataService;
    }
    
    @GetMapping("{id}")
    public Mono<Metadata> getMetadataById(@PathVariable String id){
        logger.debug("REST request to get the Metadata");
        return metadataService.findById(id);
    }
}