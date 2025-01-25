package sec13.chap03.ex02.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import sec13.chap03.ex02.WeekDay;

@Retention(RetentionPolicy.RUNTIME)
public @interface WeekDaysAvail {
    WeekDay[] value();
}