package com.sedrakpc.example.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by: Sedrak Dalaloyan
 * Date: 4/5/16
 * Time: 4:44 PM
 */
public class Article implements Serializable {

    private Long id;
    private String title;
    private String content;
    private String postedBy;
    private Date creationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
