package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "candidates_talent")
public class CandidateTalent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(targetEntity = CandidateCv.class)
	@JoinColumn(name = "candidates_cv_id")
	private CandidateCv candidateCv;

	@ManyToOne
	@JoinColumn(name = "talents_id")
	private Talent talent;

	public CandidateTalent() {
		super();
	}

	public CandidateTalent(int id, CandidateCv candidateCv, Talent talent) {
		super();
		this.id = id;
		this.candidateCv = candidateCv;
		this.talent = talent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CandidateCv getCandidateCv() {
		return candidateCv;
	}

	public void setCandidateCv(CandidateCv candidateCv) {
		this.candidateCv = candidateCv;
	}

	public Talent getTalent() {
		return talent;
	}

	public void setTalent(Talent talent) {
		this.talent = talent;
	}

}
