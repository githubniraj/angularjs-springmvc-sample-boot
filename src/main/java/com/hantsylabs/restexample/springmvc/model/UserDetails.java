
package com.hantsylabs.restexample.springmvc.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author Hantsy Bai<hantsy@gmail.com>
 */
public class UserDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long id;

    private String username;

    private String name;

    private String email;

    private String role;
    
    private LocalDateTime createdDate;

    @java.beans.ConstructorProperties({"id", "username", "name", "email", "role", "createdDate"})
    public UserDetails(Long id, String username, String name, String email, String role, LocalDateTime createdDate) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.email = email;
        this.role = role;
        this.createdDate = createdDate;
    }

    public UserDetails() {
    }

    public static UserDetailsBuilder builder() {
        return new UserDetailsBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getRole() {
        return this.role;
    }

    public LocalDateTime getCreatedDate() {
        return this.createdDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof UserDetails)) return false;
        final UserDetails other = (UserDetails) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$role = this.getRole();
        final Object other$role = other.getRole();
        if (this$role == null ? other$role != null : !this$role.equals(other$role)) return false;
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
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $role = this.getRole();
        result = result * PRIME + ($role == null ? 43 : $role.hashCode());
        final Object $createdDate = this.getCreatedDate();
        result = result * PRIME + ($createdDate == null ? 43 : $createdDate.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof UserDetails;
    }

    public String toString() {
        return "com.hantsylabs.restexample.springmvc.model.UserDetails(id=" + this.getId() + ", username=" + this.getUsername() + ", name=" + this.getName() + ", email=" + this.getEmail() + ", role=" + this.getRole() + ", createdDate=" + this.getCreatedDate() + ")";
    }

    public static class UserDetailsBuilder {
        private Long id;
        private String username;
        private String name;
        private String email;
        private String role;
        private LocalDateTime createdDate;

        UserDetailsBuilder() {
        }

        public UserDetails.UserDetailsBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public UserDetails.UserDetailsBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserDetails.UserDetailsBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserDetails.UserDetailsBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserDetails.UserDetailsBuilder role(String role) {
            this.role = role;
            return this;
        }

        public UserDetails.UserDetailsBuilder createdDate(LocalDateTime createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public UserDetails build() {
            return new UserDetails(id, username, name, email, role, createdDate);
        }

        public String toString() {
            return "com.hantsylabs.restexample.springmvc.model.UserDetails.UserDetailsBuilder(id=" + this.id + ", username=" + this.username + ", name=" + this.name + ", email=" + this.email + ", role=" + this.role + ", createdDate=" + this.createdDate + ")";
        }
    }
}
