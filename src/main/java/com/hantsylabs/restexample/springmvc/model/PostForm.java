package com.hantsylabs.restexample.springmvc.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *
 * @author Hantsy Bai<hantsy@gmail.com>
 *
 */
public class PostForm implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @NotNull
    @NotEmpty
    private String title;

    @NotNull
    @NotEmpty
    private String content;

    @java.beans.ConstructorProperties({"title", "content"})
    public PostForm(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public PostForm() {
    }

    public static PostFormBuilder builder() {
        return new PostFormBuilder();
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof PostForm)) return false;
        final PostForm other = (PostForm) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final Object this$content = this.getContent();
        final Object other$content = other.getContent();
        if (this$content == null ? other$content != null : !this$content.equals(other$content)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $content = this.getContent();
        result = result * PRIME + ($content == null ? 43 : $content.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof PostForm;
    }

    public String toString() {
        return "com.hantsylabs.restexample.springmvc.model.PostForm(title=" + this.getTitle() + ", content=" + this.getContent() + ")";
    }

    public static class PostFormBuilder {
        private String title;
        private String content;

        PostFormBuilder() {
        }

        public PostForm.PostFormBuilder title(String title) {
            this.title = title;
            return this;
        }

        public PostForm.PostFormBuilder content(String content) {
            this.content = content;
            return this;
        }

        public PostForm build() {
            return new PostForm(title, content);
        }

        public String toString() {
            return "com.hantsylabs.restexample.springmvc.model.PostForm.PostFormBuilder(title=" + this.title + ", content=" + this.content + ")";
        }
    }
}
