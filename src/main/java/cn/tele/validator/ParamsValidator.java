package cn.tele.validator;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;

/** 
 *
 *@author Tele
 *
 */

public class ParamsValidator {

	public static ExecutableValidator getValidator() {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		return validatorFactory.getValidator().forExecutables();
	}
}
