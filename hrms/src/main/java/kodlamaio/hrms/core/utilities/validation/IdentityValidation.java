package kodlamaio.hrms.core.utilities.validation;

import kodlamaio.hrms.externalServices.FakeMernis;

public class IdentityValidation {
	public static boolean isRealPerson(String tcno) {
		FakeMernis mernis = new FakeMernis();
		return mernis.ValidateByPersonalInfo(tcno);
	}
}
