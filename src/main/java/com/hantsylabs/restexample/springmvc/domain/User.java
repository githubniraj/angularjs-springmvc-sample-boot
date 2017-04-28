package com.hantsylabs.restexample.springmvc.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "users")
public class User implements UserDetails, Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private String role;

    @Column(name = "created_date")
    @CreatedDate
    private LocalDateTime createdDate;

    @java.beans.ConstructorProperties({"id", "username", "password", "name", "email", "role", "createdDate"})
    public User(Long id, String username, String password, String name, String email, String role, LocalDateTime createdDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.role = role;
        this.createdDate = createdDate;
    }

    public User() {
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public String getName() {
        if (this.name == null || this.name.trim().length() == 0) {
            return this.username;
        }
        return name;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_" + this.role));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public Long getId() {
        return this.id;
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

    public void setPassword(String password) {
        this.password = password;
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
        if (!(o instanceof User)) return false;
        final User other = (User) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
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
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
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
        return other instanceof User;
    }

    public String toString() {
        return "com.hantsylabs.restexample.springmvc.domain.User(id=" + this.getId() + ", username=" + this.getUsername() + ", password=" + this.getPassword() + ", name=" + this.getName() + ", email=" + this.getEmail() + ", role=" + this.getRole() + ", createdDate=" + this.getCreatedDate() + ")";
    }

    public static class UserBuilder {
        private Long id;
        private String username;
        private String password;
        private String name;
        private String email;
        private String role;
        private LocalDateTime createdDate;

        UserBuilder() {
        }

        public User.UserBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public User.UserBuilder username(String username) {
            this.username = username;
            return this;
        }

        public User.UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public User.UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public User.UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public User.UserBuilder role(String role) {
            this.role = role;
            return this;
        }

        public User.UserBuilder createdDate(LocalDateTime createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public User build() {
            return new User(id, username, password, name, email, role, createdDate);
        }

        public String toString() {
            return "com.hantsylabs.restexample.springmvc.domain.User.UserBuilder(id=" + this.id + ", username=" + this.username + ", password=" + this.password + ", name=" + this.name + ", email=" + this.email + ", role=" + this.role + ", createdDate=" + this.createdDate + ")";
        }
    }
}
