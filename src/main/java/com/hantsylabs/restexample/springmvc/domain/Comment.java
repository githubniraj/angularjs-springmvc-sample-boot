package com.hantsylabs.restexample.springmvc.domain;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author Hantsy Bai<hantsy@gmail.com>
 *
 */
@Entity
@Table(name = "comments")
public class Comment implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "content")
    private String content;

    @JoinColumn(name = "post_id")
    @ManyToOne()
    private Post post;

    @ManyToOne
    @JoinColumn(name = "created_by")
    @CreatedBy
    private User createdBy;

    @Column(name = "created_on")
    @CreatedDate
    private LocalDateTime createdDate;

    @java.beans.ConstructorProperties({"id", "content", "post", "createdBy", "createdDate"})
    public Comment(Long id, String content, Post post, User createdBy, LocalDateTime createdDate) {
        this.id = id;
        this.content = content;
        this.post = post;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
    }

    public Comment() {
    }

    public static CommentBuilder builder() {
        return new CommentBuilder();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.content);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comment other = (Comment) obj;
        if (!Objects.equals(this.content, other.content)) {
            return false;
        }
        return true;
    }


    public Long getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }

    public Post getPost() {
        return this.post;
    }

    public User getCreatedBy() {
        return this.createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return this.createdDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String toString() {
        return "com.hantsylabs.restexample.springmvc.domain.Comment(id=" + this.getId() + ", content=" + this.getContent() + ", post=" + this.getPost() + ", createdBy=" + this.getCreatedBy() + ", createdDate=" + this.getCreatedDate() + ")";
    }

    public static class CommentBuilder {
        private Long id;
        private String content;
        private Post post;
        private User createdBy;
        private LocalDateTime createdDate;

        CommentBuilder() {
        }

        public Comment.CommentBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public Comment.CommentBuilder content(String content) {
            this.content = content;
            return this;
        }

        public Comment.CommentBuilder post(Post post) {
            this.post = post;
            return this;
        }

        public Comment.CommentBuilder createdBy(User createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public Comment.CommentBuilder createdDate(LocalDateTime createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Comment build() {
            return new Comment(id, content, post, createdBy, createdDate);
        }

        public String toString() {
            return "com.hantsylabs.restexample.springmvc.domain.Comment.CommentBuilder(id=" + this.id + ", content=" + this.content + ", post=" + this.post + ", createdBy=" + this.createdBy + ", createdDate=" + this.createdDate + ")";
        }
    }
}
