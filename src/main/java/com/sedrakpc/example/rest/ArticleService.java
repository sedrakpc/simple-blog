package com.sedrakpc.example.rest;

import com.sedrakpc.example.common.FileStorageService;
import com.sedrakpc.example.dao.ArticleDao;
import com.sedrakpc.example.dao.DataStoreDao;
import com.sedrakpc.example.domain.Article;
import com.sedrakpc.example.domain.DataStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * User: Sedrak Dalaloyan
 * Date: 2/23/15
 * Time: 16:56
 */
@RestController
@RequestMapping("/rest/article")
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private DataStoreDao dataStoreDao;

    @Autowired
    FileStorageService fileStorageService;

    @RequestMapping(method= RequestMethod.GET)
    public List<Article> findAll() {
        return articleDao.loadAll();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Article findOne(@PathVariable("id") long id) {
        return articleDao.findById(id);
    }

    @RequestMapping(method=RequestMethod.POST)
    public Article create(@RequestBody Article article) {
        articleDao.save(article);
        article.setContent("");
        return article;
    }

    @RequestMapping(value="/file", method = RequestMethod.POST)
    public DataStore create(MultipartHttpServletRequest request)
            throws Exception {
        Iterator<String> itr = request.getFileNames();
        MultipartFile mpf = request.getFile(itr.next());
        String fileName = mpf.getOriginalFilename();
        String fileId = UUID.randomUUID().toString();
        String url = fileStorageService.saveFile(mpf.getBytes(), fileId);
        if(url != null) {
            DataStore ds = new DataStore();
            ds.setId(fileId);
            ds.setName(fileName);
            ds.setContentType(mpf.getContentType());
            ds.setUrl(url);
            dataStoreDao.save(ds);
            return ds;
        }
        return null;
    }

}
