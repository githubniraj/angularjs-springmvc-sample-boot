package com.hantsylabs.restexample.springmvc.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author Hantsy Bai<hantsy@gmail.com>
 *
 */
public class PostDetails implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    private Long id;

    private String title;

    private String content;
    
    private String status;

    private SimpleUserDetails createdBy;

    private LocalDateTime createdDate;

    private SimpleUserDetails lastModifiedBy;

    private LocalDateTime lastModifiedDate;

    @java.beans.ConstructorProperties({"id", "title", "content", "status", "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate"})
    public PostDetails(Long id, String title, String content, String status, SimpleUserDetails createdBy, LocalDateTime createdDate, SimpleUserDetails lastModifiedBy, LocalDateTime lastModifiedDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.status = status;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
    }

    public PostDetails() {
    }

    public static PostDetailsBuilder builder() {
        return new PostDetailsBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public String getStatus() {
        return this.status;
    }

    public SimpleUserDetails getCreatedBy() {
        return this.createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return this.createdDate;
    }

    public SimpleUserDetails getLastModifiedBy() {
        return this.lastModifiedBy;
    }

    public LocalDateTime getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreatedBy(SimpleUserDetails createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void setLastModifiedBy(SimpleUserDetails lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String toString() {
        return "com.hantsylabs.restexample.springmvc.model.PostDetails(id=" + this.getId() + ", title=" + this.getTitle() + ", content=" + this.getContent() + ", status=" + this.getStatus() + ", createdBy=" + this.getCreatedBy() + ", createdDate=" + this.getCreatedDate() + ", lastModifiedBy=" + this.getLastModifiedBy() + ", lastModifiedDate=" + this.getLastModifiedDate() + ")";
    }

    public static class PostDetailsBuilder {
        private Long id;
        private String title;
        private String content;
        private String status;
        private SimpleUserDetails createdBy;
        private LocalDateTime createdDate;
        private SimpleUserDetails lastModifiedBy;
        private LocalDateTime lastModifiedDate;

        PostDetailsBuilder() {
        }

        public PostDetails.PostDetailsBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public PostDetails.PostDetailsBuilder title(String title) {
            this.title = title;
            return this;
        }

        public PostDetails.PostDetailsBuilder content(String content) {
            this.content = content;
            return this;
        }

        public PostDetails.PostDetailsBuilder status(String status) {
            this.status = status;
            return this;
        }

        public PostDetails.PostDetailsBuilder createdBy(SimpleUserDetails createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public PostDetails.PostDetailsBuilder createdDate(LocalDateTime createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public PostDetails.PostDetailsBuilder lastModifiedBy(SimpleUserDetails lastModifiedBy) {
            this.lastModifiedBy = lastModifiedBy;
            return this;
        }

        public PostDetails.PostDetailsBuilder lastModifiedDate(LocalDateTime lastModifiedDate) {
            this.lastModifiedDate = lastModifiedDate;
            return this;
        }

        public PostDetails build() {
            return new PostDetails(id, title, content, status, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
        }

        public String toString() {
            return "com.hantsylabs.restexample.springmvc.model.PostDetails.PostDetailsBuilder(id=" + this.id + ", title=" + this.title + ", content=" + this.content + ", status=" + this.status + ", createdBy=" + this.createdBy + ", createdDate=" + this.createdDate + ", lastModifiedBy=" + this.lastModifiedBy + ", lastModifiedDate=" + this.lastModifiedDate + ")";
        }
    }
}
