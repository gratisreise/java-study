package sec13.chap03.ex02.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Repeatable(NumLimits.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface NumLimit {
    LimitType type();
    int to();
}