package br.insper.finalzambom.service;

import br.insper.finalzambom.model.Artigo;
import br.insper.finalzambom.repository.ArtigoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtigoService {

    private final ArtigoRepository ArtigoRepository;

    public ArtigoService(ArtigoRepository ArtigoRepository) {
        this.ArtigoRepository = ArtigoRepository;
    }

    public void createArtigo(Artigo Artigo) {
        ArtigoRepository.save(Artigo);
    }

    public void deleteArtigo(String id) {
        ArtigoRepository.deleteById(id);
    }

    public List<Artigo> getAllArtigos() {
        return ArtigoRepository.findAll();
    }

    public Artigo getArtigoById(String id) {
        return ArtigoRepository.findById(id).orElse(null);
    }
}
