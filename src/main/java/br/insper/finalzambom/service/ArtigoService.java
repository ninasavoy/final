package br.insper.finalzambom.service;

import br.insper.finalzambom.model.Artigo;
import br.insper.finalzambom.repository.ArtigoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtigoService {

    private final ArtigoRepository artigoRepository;

    public ArtigoService(ArtigoRepository artigoRepository) {
        this.artigoRepository = artigoRepository;
    }

    public Artigo criarArtigo(Artigo artigo) {
        return artigoRepository.save(artigo);
    }

    public void deletarArtigo(String id) {
        artigoRepository.deleteById(id);
    }

    public List<Artigo> listarArtigos() {
        return artigoRepository.findAll();
    }

    public Artigo buscarArtigo(String id) {
        return artigoRepository.findById(id).orElseThrow(() -> new RuntimeException("Artigo não encontrado"));
    }
}
