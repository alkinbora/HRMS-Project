package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.validation.Injection;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{
	
	private JobAdvertisementDao jobAdvertisementDao;
	private EmployerDao employerDao;
	private CityDao cityDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao,
			EmployerDao employerDao, CityDao cityDao) {
		
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.employerDao = employerDao;
		this.cityDao = cityDao;
	}
	
	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		Result inject = Injection.run(
				findEmployer(jobAdvertisement),findCity(jobAdvertisement),descriptionNullChecker(jobAdvertisement),
				ifMinSalaryNull(jobAdvertisement),ifMaxSalaryNull(jobAdvertisement),minSalaryChecker(jobAdvertisement),
				maxSalaryChecker(jobAdvertisement),ifMinSalaryEqualsMaxSalary(jobAdvertisement),ifQuotaSmallerThanOne(jobAdvertisement),
				appealExpirationChecker( jobAdvertisement));
		
		if(!inject.isSuccess()) {
			
			return new ErrorResult(inject.getMessage());
		}
		
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Eklendi.");
	}

	@Override
	public Result update(JobAdvertisement jobAdvertisement) {
		
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilanı güncellendi.");
	}

	@Override
	public Result delete(JobAdvertisement jobAdvertisement) {
		
		this.jobAdvertisementDao.delete(jobAdvertisement);
		return new SuccessResult("İş ilanı silindi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByIsActive() {
		
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findAllByIsActive(true),"Başarılı");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByIsActiveSorted() {
		
		Sort sort = Sort.by(Sort.Direction.ASC,"applicationDeadline"); // yükselen ASC , Alçalan DESC
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort));
	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByIsActiveAndCompanyName(int id) {
		
		if(!this.employerDao.existsById(id)) {
			return new ErrorDataResult("İş veren bulunamadı.");
		}
		else {
			return new SuccessDataResult <List<JobAdvertisement>>
			(this.jobAdvertisementDao.getEmployersActiveJobAdvertisement(id),"Başarılı.");
		}
	}

	@Override
	public DataResult<JobAdvertisement> jobAdvertisementDisabled(int id) {
		
		if(!this.jobAdvertisementDao.existsById(id)) {
			return new ErrorDataResult("İş veren bulunamadı.");
		}
		JobAdvertisement ref =  this.jobAdvertisementDao.getOne(id);
		ref.setActive(false);
		return new SuccessDataResult <JobAdvertisement>(this.jobAdvertisementDao.save(ref),"İş ilanı Pasif.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		
		return new SuccessDataResult<List<JobAdvertisement>>
		(jobAdvertisementDao.findAll(),"Data listelendi.");
	}
	
	private Result findEmployer(JobAdvertisement jobAdvertisement) {
		if(!this.employerDao.existsById(jobAdvertisement.getEmployer().getId())) {
			return new ErrorResult("İş veren bulunamadı.");
		}
		return new SuccessResult();
	}
	
	
	private Result findCity(JobAdvertisement jobAdvertisement) {
		if(!this.cityDao.existsById(jobAdvertisement.getCity().getId())) {
			return new ErrorResult("Şehir bulunamadı.");
		}
		return new SuccessResult();
	}
	
	private Result descriptionNullChecker(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getDescription().isEmpty()) {
			return new ErrorResult("İş tanımı boş bırakılamaz.");
		}
		return new SuccessResult();
	}
	
	private Result ifMinSalaryNull(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getMinSalary() == null) {
			return new ErrorResult("Minimum maaş girilmek zorundadır.");
		}
		return new SuccessResult();
	}
	
	
	private Result ifMaxSalaryNull(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getMaxSalary() == null) {
			return new ErrorResult("Maksimum maaş girilmek zorundadır.");
		}
		return new SuccessResult();
	}
	
	private Result minSalaryChecker(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getMinSalary() == 0) {
			return new ErrorResult("Minimum maaş 0 verilemez.");
		}
		return new SuccessResult();
	}
	
	private Result maxSalaryChecker(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getMaxSalary() == 0) {
			return new ErrorResult("Maksimum maaş 0 verilemez.");
		}
		return new SuccessResult();
	}
	
	private Result ifMinSalaryEqualsMaxSalary(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getMinSalary() >= jobAdvertisement.getMaxSalary()) {
			return new ErrorResult("Minimum maaş, maksimum maaşa eşit olamaz.");
		}
		return new SuccessResult();
	}
	
	private Result ifQuotaSmallerThanOne(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getQuota() < 1) {
			return new ErrorResult("Açık pozisyon sayısı 1 den küçük olamaz.");
		}
		return new SuccessResult();
	}
	
	private Result appealExpirationChecker(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getAppealExpirationDate() == null) {
			return new ErrorResult("Son başvuru tarihi girilmek zorundadır");
		}
		return new SuccessResult();
	}
	
	
}