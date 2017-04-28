package com.hantsylabs.restexample.springmvc.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class PasswordForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @NotEmpty
    private String oldPassword;

    @NotNull
    @NotEmpty
    private String newPassword;

    @java.beans.ConstructorProperties({"oldPassword", "newPassword"})
    public PasswordForm(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public PasswordForm() {
    }

    public static PasswordFormBuilder builder() {
        return new PasswordFormBuilder();
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public String getNewPassword() {
        return this.newPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof PasswordForm)) return false;
        final PasswordForm other = (PasswordForm) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$oldPassword = this.getOldPassword();
        final Object other$oldPassword = other.getOldPassword();
        if (this$oldPassword == null ? other$oldPassword != null : !this$oldPassword.equals(other$oldPassword))
            return false;
        final Object this$newPassword = this.getNewPassword();
        final Object other$newPassword = other.getNewPassword();
        if (this$newPassword == null ? other$newPassword != null : !this$newPassword.equals(other$newPassword))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $oldPassword = this.getOldPassword();
        result = result * PRIME + ($oldPassword == null ? 43 : $oldPassword.hashCode());
        final Object $newPassword = this.getNewPassword();
        result = result * PRIME + ($newPassword == null ? 43 : $newPassword.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof PasswordForm;
    }

    public String toString() {
        return "com.hantsylabs.restexample.springmvc.model.PasswordForm(oldPassword=" + this.getOldPassword() + ", newPassword=" + this.getNewPassword() + ")";
    }

    public static class PasswordFormBuilder {
        private String oldPassword;
        private String newPassword;

        PasswordFormBuilder() {
        }

        public PasswordForm.PasswordFormBuilder oldPassword(String oldPassword) {
            this.oldPassword = oldPassword;
            return this;
        }

        public PasswordForm.PasswordFormBuilder newPassword(String newPassword) {
            this.newPassword = newPassword;
            return this;
        }

        public PasswordForm build() {
            return new PasswordForm(oldPassword, newPassword);
        }

        public String toString() {
            return "com.hantsylabs.restexample.springmvc.model.PasswordForm.PasswordFormBuilder(oldPassword=" + this.oldPassword + ", newPassword=" + this.newPassword + ")";
        }
    }
}
