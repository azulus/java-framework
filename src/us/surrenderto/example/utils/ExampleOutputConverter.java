package us.surrenderto.example.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import us.surrenderto.example.common.objects.Example;
import us.surrenderto.example.common.objects.ExampleImpl;
import us.surrenderto.utils.general.Builder;
import us.surrenderto.utils.general.InstanceConverter;

@Aspect
@Component
public class ExampleOutputConverter extends InstanceConverter{
	
	public ExampleOutputConverter() {
		super(
				new Class[]{Example.class},
				new Class[]{ExampleImpl.class},
				new Builder[]{ExampleBuilder.get()}
		);
	}

	@Pointcut("within(us.surrenderto.example.dao..*)")
	public void inDao() {}
	
	@Around("inDao()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		return sanitize(joinPoint.proceed(joinPoint.getArgs()));
	}

}
