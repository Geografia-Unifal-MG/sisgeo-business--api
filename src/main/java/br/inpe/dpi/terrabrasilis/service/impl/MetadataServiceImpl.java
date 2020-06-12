package br.inpe.dpi.terrabrasilis.service.impl;

import br.inpe.dpi.terrabrasilis.domain.Metadata;
import br.inpe.dpi.terrabrasilis.repository.MetadataRepository;
import br.inpe.dpi.terrabrasilis.service.MetadataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MetadataServiceImpl implements MetadataService {
    
    private static final long serialVersionUID = 1L;
    private final Logger logger = LoggerFactory.getLogger(MetadataServiceImpl.class);
    
    private final MetadataRepository metadataRepository;
    
    public MetadataServiceImpl(MetadataRepository metadataRepository){
        this.metadataRepository = metadataRepository;
    }

    @Override
    public Mono<Metadata> findById(String id) {
        logger.debug("Request to get Metadata : {}", id);
        return this.metadataRepository.findById(id);
    }
}