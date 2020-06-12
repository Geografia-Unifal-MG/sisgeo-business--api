package br.inpe.dpi.terrabrasilis.service;

import java.io.Serializable;

import br.inpe.dpi.terrabrasilis.domain.Metadata;
import reactor.core.publisher.Mono;

public interface MetadataService extends Serializable{
    Mono<Metadata> findById(String id);
}