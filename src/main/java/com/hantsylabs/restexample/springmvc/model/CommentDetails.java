package com.hantsylabs.restexample.springmvc.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author Hantsy Bai<hantsy@gmail.com>
 *
 */
public class CommentDetails implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Long id;

    private String content;

    private SimpleUserDetails createdBy;

    private LocalDateTime createdDate;


    @java.beans.ConstructorProperties({"id", "content", "createdBy", "createdDate"})
    public CommentDetails(Long id, String content, SimpleUserDetails createdBy, LocalDateTime createdDate) {
        this.id = id;
        this.content = content;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
    }

    public CommentDetails() {
    }

    public static CommentDetailsBuilder builder() {
        return new CommentDetailsBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }

    public SimpleUserDetails getCreatedBy() {
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

    public void setCreatedBy(SimpleUserDetails createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof CommentDetails)) return false;
        final CommentDetails other = (CommentDetails) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$content = this.getContent();
        final Object other$content = other.getContent();
        if (this$content == null ? other$content != null : !this$content.equals(other$content)) return false;
        final Object this$createdBy = this.getCreatedBy();
        final Object other$createdBy = other.getCreatedBy();
        if (this$createdBy == null ? other$createdBy != null : !this$createdBy.equals(other$createdBy)) return false;
        final Object this$createdDate = this.getCreatedDate();
        final Object other$createdDate = other.getCreatedDate();
        if (this$createdDate == null ? other$createdDate != null : !this$createdDate.equals(other$createdDate))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $content = this.getContent();
        result = result * PRIME + ($content == null ? 43 : $content.hashCode());
        final Object $createdBy = this.getCreatedBy();
        result = result * PRIME + ($createdBy == null ? 43 : $createdBy.hashCode());
        final Object $createdDate = this.getCreatedDate();
        result = result * PRIME + ($createdDate == null ? 43 : $createdDate.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof CommentDetails;
    }

    public String toString() {
        return "com.hantsylabs.restexample.springmvc.model.CommentDetails(id=" + this.getId() + ", content=" + this.getContent() + ", createdBy=" + this.getCreatedBy() + ", createdDate=" + this.getCreatedDate() + ")";
    }

    public static class CommentDetailsBuilder {
        private Long id;
        private String content;
        private SimpleUserDetails createdBy;
        private LocalDateTime createdDate;

        CommentDetailsBuilder() {
        }

        public CommentDetails.CommentDetailsBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public CommentDetails.CommentDetailsBuilder content(String content) {
            this.content = content;
            return this;
        }

        public CommentDetails.CommentDetailsBuilder createdBy(SimpleUserDetails createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public CommentDetails.CommentDetailsBuilder createdDate(LocalDateTime createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public CommentDetails build() {
            return new CommentDetails(id, content, createdBy, createdDate);
        }

        public String toString() {
            return "com.hantsylabs.restexample.springmvc.model.CommentDetails.CommentDetailsBuilder(id=" + this.id + ", content=" + this.content + ", createdBy=" + this.createdBy + ", createdDate=" + this.createdDate + ")";
        }
    }
}
