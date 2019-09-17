package cn.tele.aspect;

import java.lang.reflect.Method;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.executable.ExecutableValidator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import cn.tele.exception.ValidParamException;
import cn.tele.validator.ParamsValidator;

/**
 *
 * @author Tele
 *
 */
@Component
@Aspect
public class UserAspect {

	private ExecutableValidator validator = ParamsValidator.getValidator();

	@Pointcut("execution (* cn.tele.service.*.*(..))")
	private void pt() {
	}

	@Before("pt()")
	public void checkParams(JoinPoint jp) {

		Object target = jp.getTarget();
		Object[] params = jp.getArgs();
		MethodSignature methodSignature = (MethodSignature) jp.getSignature();

		String[] paramNames = methodSignature.getParameterNames();
		Method method = methodSignature.getMethod();

		Set<ConstraintViolation<Object>> validateResult = validator.validateParameters(target, method, params);
		if (!validateResult.isEmpty()) {
			throw new ValidParamException(validateResult);
		}
	}

}
