package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidates_job_experiences")
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "candidateCv" })
public class CandidateJobExperience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "workplace_name")
	private String workplaceName;

	@Column(name = "entry_date")
	private Date entryDate;

	@Column(name = "exit_date")
	private Date exitDate;

	@ManyToOne
	@JoinColumn(name = "job_titles_id")
	private JobTitle jobTitle;

	@Column(name = "is_continue")
	private boolean isContinue;

	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne()
	@JoinColumn(name = "candidates_cv_id")
	private CandidateCv candidateCv;

	public CandidateJobExperience() {
		super();
	}

	public CandidateJobExperience(int id, String workplaceName, Date entryDate, Date exitDate, JobTitle jobTitle,
			boolean isContinue, CandidateCv candidateCv) {
		super();
		this.id = id;
		this.workplaceName = workplaceName;
		this.entryDate = entryDate;
		this.exitDate = exitDate;
		this.jobTitle = jobTitle;
		this.isContinue = isContinue;
		this.candidateCv = candidateCv;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWorkplaceName() {
		return workplaceName;
	}

	public void setWorkplaceName(String workplaceName) {
		this.workplaceName = workplaceName;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Date getExitDate() {
		return exitDate;
	}

	public void setExitDate(Date exitDate) {
		this.exitDate = exitDate;
	}

	public JobTitle getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(JobTitle jobTitle) {
		this.jobTitle = jobTitle;
	}

	public boolean isContinue() {
		return isContinue;
	}

	public void setContinue(boolean isContinue) {
		this.isContinue = isContinue;
	}

	public CandidateCv getCandidateCv() {
		return candidateCv;
	}

	public void setCandidateCv(CandidateCv candidateCv) {
		this.candidateCv = candidateCv;
	}
}
