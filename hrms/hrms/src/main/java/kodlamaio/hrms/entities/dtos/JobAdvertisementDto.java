package kodlamaio.hrms.entities.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class JobAdvertisementDto {

	@JsonIgnore
	private int id;

	private int employerId;

	private int jobtitleId;

	private int cityId;

	private String description;

	private int quota;

	private LocalDateTime appealExpirationDate;
	
	private LocalDateTime createdDate = LocalDateTime.now();

	private Double minSalary;
	
	private Double maxSalary;

	private boolean isActive;

	private int workHourId;
	
	private int workTypeId;

	public JobAdvertisementDto() {
		super();
	}

	public JobAdvertisementDto(int id, int employerId, int jobtitleId, int cityId, String description, int quota,
			LocalDateTime appealExpirationDate, LocalDateTime createdDate, Double minSalary, Double maxSalary,
			boolean isActive, int workHourId, int workTypeId) {
		super();
		this.id = id;
		this.employerId = employerId;
		this.jobtitleId = jobtitleId;
		this.cityId = cityId;
		this.description = description;
		this.quota = quota;
		this.appealExpirationDate = appealExpirationDate;
		this.createdDate = createdDate;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.isActive = isActive;
		this.workHourId = workHourId;
		this.workTypeId = workTypeId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmployerId() {
		return employerId;
	}

	public void setEmployerId(int employerId) {
		this.employerId = employerId;
	}

	public int getJobtitleId() {
		return jobtitleId;
	}

	public void setJobtitleId(int jobtitleId) {
		this.jobtitleId = jobtitleId;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
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

	public int getWorkHourId() {
		return workHourId;
	}

	public void setWorkHourId(int workHourId) {
		this.workHourId = workHourId;
	}

	public int getWorkTypeId() {
		return workTypeId;
	}

	public void setWorkTypeId(int workTypeId) {
		this.workTypeId = workTypeId;
	}

}