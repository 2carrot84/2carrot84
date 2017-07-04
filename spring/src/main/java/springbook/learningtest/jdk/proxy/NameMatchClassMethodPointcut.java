package springbook.learningtest.jdk.proxy;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.util.PatternMatchUtils;

public class NameMatchClassMethodPointcut extends NameMatchMethodPointcut {
	public void setMappedClassName(String mappedClassName) {
		this.setClassFilter(new SimpleClassFilter(mappedClassName));	// 기존 NameMatchMethodPointcut에 클래스 필터 추가
	}

	static class SimpleClassFilter implements ClassFilter {
		String mappedName;	// 해당 명칭에 매핑되는 클래스를 대상으로 선정

		public SimpleClassFilter(String mappedName) {
			this.mappedName = mappedName;
		}

		@Override
		public boolean matches(Class<?> aClass) {
			return PatternMatchUtils.simpleMatch(mappedName, aClass.getSimpleName());	// * 가 들어간 문자열 비교를 지원하는 스프링 유틸
		}
	}
}
