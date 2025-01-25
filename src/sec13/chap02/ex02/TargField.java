package sec13.chap02.ex02;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

//@TargConstr // ⚠️ 사용불가
@Target(ElementType.FIELD)
public @interface TargField { }