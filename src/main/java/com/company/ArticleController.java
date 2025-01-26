package com.company;

import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/articles")
public class ArticleController {
    private ArticleService articleService;
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }
    @PostMapping("/add")
    public String addArticle(@RequestBody Article article) {
        articleService.addArticle(article);
        return "Maqola qoshildi: " + article;
    }
    @GetMapping("/list")
    public List<Article> listArticles() {
        return articleService.listArticles();
    }
    @PutMapping("/update/{id}")
    public String updateArticle(@PathVariable int id, @RequestBody Article article) {
        boolean updated = articleService.updateArticle(id, article);
        if (updated) {
            return "Maqola yengilandi: " + article;
        } else {
            return "mashi id" + id +"  maqola topilmadi.";
        }
    }
    @DeleteMapping("/delete/{id}")
    public String removeArticle(@PathVariable int id) {
        boolean deleted = articleService.removeArticle(id);
        if (deleted) {
            return "Maqola ochirildi.";
        } else {
            return "ID " + id + " ga ega maqola topilmadi.";
        }
    }
}
