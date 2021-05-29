package kodlamaio.hrms.core.concretes;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import kodlamaio.hrms.core.abstracts.MernisCheckService;
import kodlamaio.hrms.entities.concretes.Candidates;

@Primary
@Component
public class FakeMernisCheckAdapter implements MernisCheckService{

	@Override
	public boolean checkIfRealPerson(Candidates candidates) {
		return true;
	}
	
}
