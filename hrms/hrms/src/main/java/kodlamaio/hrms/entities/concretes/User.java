package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)

public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="email_address")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@OneToMany(mappedBy = "user")
    private List<SystemUser> systemUser;

	public User() {
		super();
	}

	public User(int id, String email, String password, List<SystemUser> systemUser) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.systemUser = systemUser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<SystemUser> getSystemUser() {
		return systemUser;
	}

	public void setSystemUser(List<SystemUser> systemUser) {
		this.systemUser = systemUser;
	}
	
	
}