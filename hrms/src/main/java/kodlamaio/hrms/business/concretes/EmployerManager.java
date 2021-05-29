package kodlamaio.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.abstracts.EmailSendService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmailSendService emailSendService;
	private List<String> emails = new ArrayList<>();
	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailSendService emailSendService) {
		super();
		this.employerDao = employerDao;
		this.emailSendService=emailSendService;
	}
	
	@Override
	public Result login(String email, String password) {
		Result result = new ErrorResult("Giriş başarısız.");
		for (int i = 0; i < employerDao.findAll().size(); i++) {
			if(employerDao.findAll().get(i).getEmail() == email && employerDao.findAll().get(i).getPassword() == password) {
				result = new SuccessResult("Giriş başarılı.");
			}
		}
		return result;
	}

	@Override
	public Result register(Employer employer) {
		Result result=new ErrorResult("Kayıt başarısız.");
		if(emailIsItUsed(employer.getEmail())) {
			emailSendService.emailSend(employer.getEmail());
			employer.setConfirmation(false);  
			this.employerDao.save(employer);
			result = new SuccessResult("Kayıt başarılı");
		}
		return result;
	}

	private boolean emailIsItUsed(String email) {
		boolean result = true;
		if(getAllEmails().contains(email)) {
			result = false;
		}
		return result;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"İşverenler listelendi.");
	}

	@Override
	public List<String> getAllEmails() {
		for (int i = 0; i < employerDao.findAll().size(); i++) {
			emails.add(employerDao.findAll().get(i).getEmail());
		}
		return emails;
	}

}
