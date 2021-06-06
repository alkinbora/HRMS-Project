package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "languages")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "candidateLanguage" })
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "languages_name")
	private String languagesName;

	@OneToMany(mappedBy = "language")
	private List<CandidateLanguage> candidateLanguage;

	public Language() {
		super();
	}

	public Language(int id, String languagesName, List<CandidateLanguage> candidateLanguage) {
		super();
		this.id = id;
		this.languagesName = languagesName;
		this.candidateLanguage = candidateLanguage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLanguagesName() {
		return languagesName;
	}

	public void setLanguagesName(String languagesName) {
		this.languagesName = languagesName;
	}

	public List<CandidateLanguage> getCandidateLanguage() {
		return candidateLanguage;
	}

	public void setCandidateLanguage(List<CandidateLanguage> candidateLanguage) {
		this.candidateLanguage = candidateLanguage;
	}
}
