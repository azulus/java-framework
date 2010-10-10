package us.surrenderto.example.dao.google;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import us.surrenderto.example.common.objects.Example;
import us.surrenderto.example.utils.ExampleBuilder;
import us.surrenderto.utils.general.Builder;
import us.surrenderto.utils.general.InstanceConverter;

@Aspect
@Component
public class ExampleGoogleInputConverter extends InstanceConverter{
	
	public ExampleGoogleInputConverter() {
		super(
				new Class[]{Example.class},
				new Class[]{ExampleGoogleImpl.class},
				new Builder[]{ExampleBuilder.get()}
		);
	}

	@Pointcut("within(us.surrenderto.example.dao.google..*)")
	public void inDao() {}
	
	@Around("inDao()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		return joinPoint.proceed(sanitize(joinPoint.getArgs()));
	}

}
