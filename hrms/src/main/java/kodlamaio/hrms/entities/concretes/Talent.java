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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "talents")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "candidateTalent" })
public class Talent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "talent_name")
	private String talentName;

	@OneToMany(mappedBy = "talent")
	private List<CandidateTalent> candidateTalent;

	public Talent() {
		super();
	}

	public Talent(int id, String talentName, List<CandidateTalent> candidateTalent) {
		super();
		this.id = id;
		this.talentName = talentName;
		this.candidateTalent = candidateTalent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTalentName() {
		return talentName;
	}

	public void setTalentName(String talentName) {
		this.talentName = talentName;
	}

	public List<CandidateTalent> getCandidateTalent() {
		return candidateTalent;
	}

	public void setCandidateTalent(List<CandidateTalent> candidateTalent) {
		this.candidateTalent = candidateTalent;
	}

}
