package cih.projects.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.validator.constraints.Email;

@Entity
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	@Size(min=3, max=50)
	private String username;
	@NotNull
	@Size(min=8, max=16)
	private String password;
	@Transient
	@NotNull
	@Size(min=8, max=16)
	private String confirmpwd;
	@NotNull
	@Email
	private String email;
	@NotNull
	@Email
	private String confirmEmail;
	public User(Long id, String username, String password, String confirmpwd,
			String email, String confirmEmail) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.confirmpwd = confirmpwd;
		this.email = email;
		this.confirmEmail = confirmEmail;
	}
	public User() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmpwd() {
		return confirmpwd;
	}
	public void setConfirmpwd(String confirmpwd) {
		this.confirmpwd = confirmpwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getConfirmEmail() {
		return confirmEmail;
	}
	public void setConfirmEmail(String confirmEmail) {
		this.confirmEmail = confirmEmail;
	}
	@Override
	public String toString() {
		return String
				.format("User [id=%s, username=%s, password=%s, confirmpwd=%s, email=%s, confirmEmail=%s]",
						id, username, password, confirmpwd, email, confirmEmail);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((confirmEmail == null) ? 0 : confirmEmail.hashCode());
		result = prime * result
				+ ((confirmpwd == null) ? 0 : confirmpwd.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (confirmEmail == null) {
			if (other.confirmEmail != null)
				return false;
		} else if (!confirmEmail.equals(other.confirmEmail))
			return false;
		if (confirmpwd == null) {
			if (other.confirmpwd != null)
				return false;
		} else if (!confirmpwd.equals(other.confirmpwd))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
	public static void main(String[] args) {
        Configuration config = new Configuration();
        config.addAnnotatedClass(User.class);
        config.configure();
        new SchemaExport(config).create(true, true);
    }
}
