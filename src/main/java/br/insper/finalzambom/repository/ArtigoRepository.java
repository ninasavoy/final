package br.insper.finalzambom.repository;

import br.insper.finalzambom.model.Artigo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArtigoRepository extends MongoRepository<Artigo, String> {
}
