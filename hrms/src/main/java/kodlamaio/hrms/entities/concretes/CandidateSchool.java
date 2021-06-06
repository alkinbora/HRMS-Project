package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidates_cv_school")
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "candidateCv" })
public class CandidateSchool {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "school_name")
	private String schoolName;

	@Column(name = "entry_date")
	private LocalDate entryDate;

	@Column(name = "graduation_date")
	private LocalDate graduationDate;

	@Column(name = "department")
	private String department;

	@ManyToOne(targetEntity = CandidateCv.class)
	@JoinColumn(name = "candidates_cv_id")
	private CandidateCv candidateCv;

	@Column(name = "is_continue")
	private boolean isContinue;

	public CandidateSchool() {
		super();
	}

	public CandidateSchool(int id, String schoolName, LocalDate entryDate, LocalDate graduationDate, String department,
			CandidateCv candidateCv, boolean isContinue) {
		super();
		this.id = id;
		this.schoolName = schoolName;
		this.entryDate = entryDate;
		this.graduationDate = graduationDate;
		this.department = department;
		this.candidateCv = candidateCv;
		this.isContinue = isContinue;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public LocalDate getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}

	public LocalDate getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(LocalDate graduationDate) {
		this.graduationDate = graduationDate;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public CandidateCv getCandidateCv() {
		return candidateCv;
	}

	public void setCandidateCv(CandidateCv candidateCv) {
		this.candidateCv = candidateCv;
	}

	public boolean isContinue() {
		return isContinue;
	}

	public void setContinue(boolean isContinue) {
		this.isContinue = isContinue;
	}
}