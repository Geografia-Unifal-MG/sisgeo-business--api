package br.inpe.dpi.terrabrasilis.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import br.inpe.dpi.terrabrasilis.domain.Metadata;

@Repository
public interface MetadataRepository extends ReactiveMongoRepository<Metadata, String> { }