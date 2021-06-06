package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "candidates_cv")
public class CandidateCv {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "candidate_id")
	private int candidateId;

	@Column(name = "linkedin_address")
	private String linkedinAddress;

	@Column(name = "github_address")
	private String githubAddress;

	@Column(name = "cover_letter")
	private String coverLetter;

	@Column(name = "is_active")
	private boolean isActive;

	@Column(name = "avatar_url")
	private String avatarUrl;

	@OneToMany(mappedBy = "candidateCv", fetch = FetchType.LAZY)
	private List<CandidateSchool> schools;

	@OneToMany(mappedBy = "candidateCv", fetch = FetchType.LAZY)
	private List<CandidateTalent> talents;

	@OneToMany(mappedBy = "candidateCv", fetch = FetchType.LAZY)
	private List<CandidateJobExperience> jobExperience;

	@OneToMany(mappedBy = "candidateCv", fetch = FetchType.LAZY)
	private List<CandidateLanguage> languages;

	public CandidateCv() {
		super();
	}

	public CandidateCv(int id, int candidateId, String linkedinAddress, String githubAddress, String coverLetter,
			boolean isActive, String avatarUrl, List<CandidateSchool> schools, List<CandidateTalent> talents,
			List<CandidateJobExperience> jobExperience, List<CandidateLanguage> languages) {
		super();
		this.id = id;
		this.candidateId = candidateId;
		this.linkedinAddress = linkedinAddress;
		this.githubAddress = githubAddress;
		this.coverLetter = coverLetter;
		this.isActive = isActive;
		this.avatarUrl = avatarUrl;
		this.schools = schools;
		this.talents = talents;
		this.jobExperience = jobExperience;
		this.languages = languages;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public String getLinkedinAddress() {
		return linkedinAddress;
	}

	public void setLinkedinAddress(String linkedinAddress) {
		this.linkedinAddress = linkedinAddress;
	}

	public String getGithubAddress() {
		return githubAddress;
	}

	public void setGithubAddress(String githubAddress) {
		this.githubAddress = githubAddress;
	}

	public String getCoverLetter() {
		return coverLetter;
	}

	public void setCoverLetter(String coverLetter) {
		this.coverLetter = coverLetter;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public List<CandidateSchool> getSchools() {
		return schools;
	}

	public void setSchools(List<CandidateSchool> schools) {
		this.schools = schools;
	}

	public List<CandidateTalent> getTalents() {
		return talents;
	}

	public void setTalents(List<CandidateTalent> talents) {
		this.talents = talents;
	}

	public List<CandidateJobExperience> getJobExperience() {
		return jobExperience;
	}

	public void setJobExperience(List<CandidateJobExperience> jobExperience) {
		this.jobExperience = jobExperience;
	}

	public List<CandidateLanguage> getLanguages() {
		return languages;
	}

	public void setLanguages(List<CandidateLanguage> languages) {
		this.languages = languages;
	}
}
