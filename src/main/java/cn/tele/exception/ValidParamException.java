package cn.tele.exception;

import java.awt.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Path;

/**
 *
 * @author Tele
 *
 */
public class ValidParamException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private Set<ConstraintViolation<Object>> validateResult;

	public ValidParamException() {
		super();
	}

	public ValidParamException(String message) {
		super(message);
	}

	public ValidParamException(Set<ConstraintViolation<Object>> validateResult) {
		this.validateResult = validateResult;
	}

	public Set<ConstraintViolation<Object>> getValidateResult() {
		return validateResult;
	}

	public void setValidateResult(Set<ConstraintViolation<Object>> validateResult) {
		this.validateResult = validateResult;
	}

	@Override
	public String getMessage() {
		return validateResult.iterator().next().getMessage();
	}

	public Map<Object, String> getErrorMap() {
		Map<Object, String> map = new HashMap<Object, String>(6);
		Iterator<ConstraintViolation<Object>> iterator = validateResult.iterator();
		while (iterator.hasNext()) {
			ConstraintViolation<Object> cons = iterator.next();
			Path propertyPath = cons.getPropertyPath();
			String message = cons.getMessage();
			map.put(propertyPath, message);
		}
		return map;
	}

}
