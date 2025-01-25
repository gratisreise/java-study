package sec13.chap05;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 메소드 정수 인자의 최소/최대값
 */
@Documented
@Target(ElementType.METHOD)
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface MinMax {
    int min() default 0;
    int max() default 10;
}