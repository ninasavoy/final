package br.insper.finalzambom.controller;

import br.insper.finalzambom.model.Artigo;
import br.insper.finalzambom.service.ArtigoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artigos")
public class ArtigoController {

    private final ArtigoService artigoService;

    public ArtigoController(ArtigoService artigoService) {
        this.artigoService = artigoService;
    }

    @PostMapping
    public ResponseEntity<Artigo> criarArtigo(@RequestBody Artigo artigo) {
        return ResponseEntity.ok(artigoService.criarArtigo(artigo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarArtigo(@PathVariable String id) {
        artigoService.deletarArtigo(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Artigo>> listarArtigos() {
        return ResponseEntity.ok(artigoService.listarArtigos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artigo> buscarArtigo(@PathVariable String id) {
        return ResponseEntity.ok(artigoService.buscarArtigo(id));
    }
}
