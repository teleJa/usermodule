package cn.tele.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author Tele
 *
 */
@ControllerAdvice
@EnableWebMvc
public class GlobalExceptionHandler {
	// 单参数校验
	@ExceptionHandler(ValidParamException.class)
	public @ResponseBody Map<Object, String> validParamException(HttpServletRequest req, ValidParamException vpe) {
		return vpe.getErrorMap();
	}

	// 对象类型参数校验
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public @ResponseBody Map<Object, String> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
		String parameterName = ex.getParameter().getParameterName();
		Map<Object, String> map = new HashMap<Object, String>(6);
		map.put(parameterName, ex.getLocalizedMessage());
		return map;
	}

	// pathvariable不传递参数时抛出的异常
	@ExceptionHandler(ServletRequestBindingException.class)
	public @ResponseBody Map<Object, String> servletRequestBindingException(ServletRequestBindingException ex) {
		Map<Object, String> map = new HashMap<Object, String>(6);
		map.put("error", ex.getLocalizedMessage());
		return map;
	}
}
