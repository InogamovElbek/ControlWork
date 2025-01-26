package com.company;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class ArticleService {
    private final List<Article> articleList = new ArrayList<>();
    private int cId = 1;
    public void addArticle(Article article) {
        article.setId(cId++);
        articleList.add(article);
    }
    public List<Article> listArticles() {
        return articleList;
    }
    public boolean updateArticle(int id, Article newA) {
        return articleList.stream()
                .filter(article -> article.getId() == id)
                .findFirst()
                .map(article -> {
                    article.setTitle(newA.getTitle());
                    article.setContent(newA.getContent());
                    return true;
                })
                .orElse(false);
    }
    public boolean removeArticle(int id) {
        return articleList.removeIf(article -> article.getId() == id);
    }
}
