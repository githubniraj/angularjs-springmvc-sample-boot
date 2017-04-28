package com.hantsylabs.restexample.springmvc.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class SignupForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @NotEmpty
    @Size(min = 6, message = "username should be consist of 6 to 20 characters")
    private String username;

    @NotNull
    @NotEmpty
    @Size(min = 6, message = "password should be consist of 6 to 20 characters")
    private String password;

    @java.beans.ConstructorProperties({"username", "password"})
    public SignupForm(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public SignupForm() {
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof SignupForm)) return false;
        final SignupForm other = (SignupForm) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof SignupForm;
    }

    public String toString() {
        return "com.hantsylabs.restexample.springmvc.model.SignupForm(username=" + this.getUsername() + ", password=" + this.getPassword() + ")";
    }
}
