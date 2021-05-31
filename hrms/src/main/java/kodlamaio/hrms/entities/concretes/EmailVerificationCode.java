package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "verification_codes")

public class EmailVerificationCode {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="code")
	private String code;
	
	@Column(name="is_verified")
	private boolean isVerified;
	
	public boolean isVerified() {
		return isVerified;
	}
	
	@Column(name="user_id")
	private int userId;

	public EmailVerificationCode() {
		super();
	}

	public EmailVerificationCode(int id, String code, boolean isVerified, int userId) {
		super();
		this.id = id;
		this.code = code;
		this.isVerified = isVerified;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
	
	
}