package br.insper.finalzambom.controller;

import br.insper.finalzambom.model.Artigo;
import br.insper.finalzambom.service.ArtigoService;
import br.insper.finalzambom.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artigos")
public class ArtigoController {

    private final ArtigoService articleService;
    private final UserService userService;

    public ArtigoController(ArtigoService articleService, UserService userService) {
        this.articleService = articleService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> createArticle(@RequestBody Artigo article, @RequestHeader("Authorization") String token) {
        if (userService.isAdmin(token)) {
            articleService.createArtigo(article);
            return ResponseEntity.status(HttpStatus.CREATED).body(article);
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Only admins can create articles");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable("id") String id, @RequestHeader("Authorization") String token) {
        if (userService.isAdmin(token)) {
            articleService.deleteArtigo(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Only admins can delete articles");
    }

    @GetMapping
    public ResponseEntity<?> listArticles(@RequestHeader("Authorization") String token) {
        if (userService.isAuthorized(token)) {
            return ResponseEntity.ok(articleService.getAllArtigos());
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You do not have permission to view articles");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getArticle(@PathVariable("id") String id, @RequestHeader("Authorization") String token) {
        if (userService.isAuthorized(token)) {
            return ResponseEntity.ok(articleService.getArtigoById(id));
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You do not have permission to view this article");
    }
}
