package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {

	@Autowired
	private JobTitleDao jobTitleDao;

	public JobTitleManager() {

	}

	@Override
	public DataResult<List<JobTitle>> getAll() {

		return new SuccessDataResult<List<JobTitle>>(jobTitleDao.findAll(),
				"İş pozisyonları başarılı şekilde listelendi.");
	}

	@Override
	public DataResult<List<JobTitle>> findById(int id) {

		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findById(id), "Başarı Şekilde Listelendi");
	}

	@Override
	public DataResult<List<JobTitle>> findJobTitles(String title) {
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findJobTitles(title),
				"Başarı Şekilde Listelendi");
	}

	@Override
	public DataResult<JobTitle> add(JobTitle title) {

		if (jobTitleDao.findAllByTitle(title.getTitle()).stream().count() != 0) {
			return new ErrorDataResult<JobTitle>(null, "Bu iş pozisyonu zaten kayıtlı");

		}
		return new SuccessDataResult<JobTitle>(this.jobTitleDao.save(title), "İş pozisyonu başarıyla listelendi.");

	}

}