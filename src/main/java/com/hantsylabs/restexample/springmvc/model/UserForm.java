
package com.hantsylabs.restexample.springmvc.model;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *
 * @author Hantsy Bai<hantsy@gmail.com>
 */
public class UserForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String role;

    @java.beans.ConstructorProperties({"username", "password", "name", "email", "role"})
    public UserForm(String username, String password, String name, String email, String role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public UserForm() {
    }

    public static UserFormBuilder builder() {
        return new UserFormBuilder();
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
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

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof UserForm)) return false;
        final UserForm other = (UserForm) o;
        if (!other.canEqual((Object) this)) return false;
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
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
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
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof UserForm;
    }

    public String toString() {
        return "com.hantsylabs.restexample.springmvc.model.UserForm(username=" + this.getUsername() + ", password=" + this.getPassword() + ", name=" + this.getName() + ", email=" + this.getEmail() + ", role=" + this.getRole() + ")";
    }

    public static class UserFormBuilder {
        private String username;
        private String password;
        private String name;
        private String email;
        private String role;

        UserFormBuilder() {
        }

        public UserForm.UserFormBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserForm.UserFormBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserForm.UserFormBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserForm.UserFormBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserForm.UserFormBuilder role(String role) {
            this.role = role;
            return this;
        }

        public UserForm build() {
            return new UserForm(username, password, name, email, role);
        }

        public String toString() {
            return "com.hantsylabs.restexample.springmvc.model.UserForm.UserFormBuilder(username=" + this.username + ", password=" + this.password + ", name=" + this.name + ", email=" + this.email + ", role=" + this.role + ")";
        }
    }
}
