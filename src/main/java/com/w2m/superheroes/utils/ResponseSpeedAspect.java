package com.w2m.superheroes.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class ResponseSpeedAspect {

	private Long startTime;
	private Long duration;

	@Around("@annotation(ResponseSpeed)")
	public Object requestSpeed(ProceedingJoinPoint joinPoint) throws Throwable {
		this.startTime = System.currentTimeMillis();
		var result = joinPoint.proceed();
		this.duration = System.currentTimeMillis() - startTime;
		log.info("::: Response Speed: {} ms",this.duration);
		return result;
	}

}
