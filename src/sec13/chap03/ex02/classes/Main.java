package sec13.chap03.ex02.classes;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import sec13.chap03.ex02.WeekDay;
import sec13.chap03.ex02.annotations.Blind;
import sec13.chap03.ex02.annotations.ClassDesc;
import sec13.chap03.ex02.annotations.MaxLength;
import sec13.chap03.ex02.annotations.NumLimit;
import sec13.chap03.ex02.annotations.NumLimits;
import sec13.chap03.ex02.annotations.TestAndPrint;
import sec13.chap03.ex02.annotations.WeekDaysAvail;

public class Main {

    public static Object verifyObj (Object obj) throws Exception {
        Class<?> objClass = obj.getClass();
        ClassDesc cd = objClass.getAnnotation(ClassDesc.class);
        System.out.println(cd.value() + " 검증 시작");

        for (Field f : objClass.getDeclaredFields()) {
            f.setAccessible(true);

            Object val = f.get(obj);

            //  🧪 필드의 어노테이션 검증 및 처리
            for (Annotation a : f.getAnnotations()) {

                //  첫 글자 외 *으로
                if (a instanceof Blind) {
                    String s = (String) val;
                    f.set(obj, s.substring(0, 1) + "*".repeat(s.length() - 1));
                }

                //  최대 길이 검증
                if (a instanceof MaxLength) {
                    int maxLen = ((MaxLength) a).value();
                    if (((String) val).length() > maxLen) {
                        throw new Exception(
                            "%s 최대 길이(%d) 초과".formatted(f.getName(), maxLen)
                        );
                    }
                }

                //  최소값/최대값 검증
                //  💡 Repeatable 여럿을 썼을 경우 묶음으로 들어감
                if (a instanceof NumLimits) {
                    //  💡 value 메소드가 NumLimit[] 반환
                    for (NumLimit nl : ((NumLimits) a).value()) {
                        verifyNumLimit(f.getName(), nl, (int) val);
                    }
                }
                //  💡 Repeatable 이지만 하나만 들어간 경우
                if (a instanceof NumLimit) {
                    verifyNumLimit(f.getName(), (NumLimit) a, (int) val);
                }

                //  가용 요일 검증
                if (a instanceof WeekDaysAvail) {
                    WeekDaysAvail wda = (WeekDaysAvail) a;
                    WeekDay wd = (WeekDay) f.get(obj);
                    WeekDay[] availables = wda.value();
                    boolean available = false;
//                    for (Weekday inAvail : availables) {
//                        if (wd == inAvail) available = true;
//                    }
                    if (!available) throw new Exception(
                        "해당 요일(%s) 불가".formatted(wd.getName())
                    );
                }
            }
        }

        //  테스트해야 할 메소드 실행
        for (Method m : objClass.getDeclaredMethods()) {
            for (Annotation a : m.getAnnotations()) {
                if (a instanceof TestAndPrint) {
                    TestAndPrint tp = (TestAndPrint) a;
                    String printBefore = tp.before();
                    String printAfter = tp.after();

                    if (!printBefore.isBlank())
                        System.out.println(printBefore);
                    m.invoke(obj);
                    if (!printAfter.isBlank())
                        System.out.println(printAfter);
                }
            }

        }

        return obj;
    }

    public static void verifyNumLimit (
        String fieldName, NumLimit nl, int val
    ) throws Exception {
//        if (nl.type() == LimitType.MIN && val < nl.to()) {
//            throw new Exception(
//                "%s 범위(최소 %d) 오류".formatted(fieldName, nl.to())
//            );
//        }
//        if (nl.type() == LimitType.MAX && val > nl.to()) {
//            throw new Exception(
//                "%s 범위(최대 %d) 오류".formatted(fieldName, nl.to())
//            );
//        }
    }

}
