package kodlamaio.hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_advertisements")
@Entity
public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "description")
	private String description;

	@Column(name = "quota")
	private int quota;

	@Column(name = "appeal_expiration_date")
	private LocalDateTime appealExpirationDate;

	@Column(name = "created_date")
	private LocalDateTime createdDate;

	@Column(name = "min_salary")
	private Double minSalary;

	@Column(name = "max_salary")
	private Double maxSalary;

	@Column(name = "is_active")
	private boolean isActive;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	@ManyToOne
	@JoinColumn(name = "job_title_id")
	private JobTitle jobtitle;

	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;

	public JobAdvertisement() {
		super();
	}

	public JobAdvertisement(int id, String description, int quota, LocalDateTime appealExpirationDate,
			LocalDateTime createdDate, Double minSalary, Double maxSalary, boolean isActive, City city,
			JobTitle jobtitle, Employer employer) {
		super();
		this.id = id;
		this.description = description;
		this.quota = quota;
		this.appealExpirationDate = appealExpirationDate;
		this.createdDate = createdDate;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.isActive = isActive;
		this.city = city;
		this.jobtitle = jobtitle;
		this.employer = employer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuota() {
		return quota;
	}

	public void setQuota(int quota) {
		this.quota = quota;
	}

	public LocalDateTime getAppealExpirationDate() {
		return appealExpirationDate;
	}

	public void setAppealExpirationDate(LocalDateTime appealExpirationDate) {
		this.appealExpirationDate = appealExpirationDate;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public Double getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(Double minSalary) {
		this.minSalary = minSalary;
	}

	public Double getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(Double maxSalary) {
		this.maxSalary = maxSalary;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public JobTitle getJobtitle() {
		return jobtitle;
	}

	public void setJobtitle(JobTitle jobtitle) {
		this.jobtitle = jobtitle;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

}