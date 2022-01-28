package com.tuyennguyen.serivce;

import com.tuyennguyen.entity.Article;
import com.tuyennguyen.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepo;

    public List<Article> findAll() {
        List<Article> articles = articleRepo.findAll();
        return articles;
    }

    public Optional<Article> findById(int id) {
        return articleRepo.findById(id);
    }

    public Article save(Article article) {
        return articleRepo.save(article);
    }

    public void deleteById(int id) {
        articleRepo.deleteById(id);
    }

}
