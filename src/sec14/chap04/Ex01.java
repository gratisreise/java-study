package sec14.chap04;

public class Ex01 {

    public static void main(String[] args) {
        //  첫 문자만 대문자로
        var str1 = "hello world!";
        var str2 = StringUtils.capitalize(str1);

        //  대소문자 무관 포함 여부 확인
        var str1HasHello = StringUtils
            .containsAnyIgnoreCase(str2, "HELLO");

        //  문자열에서 특정 부분 사이의 문자열만 뽑아내기
        var str3 = "이 문장에서 <이것>만 뽑아보세요.";
        var inBrackets = StringUtils
            .substringBetween(str3, "<", ">");

        //  ⭐️ 문자열이 null일 경우 보다 안정적으로 처리
        String str4 = null;
        //var str5 = str4.trim(); // ⚠️ NullPointerException 발생
        var str6 = StringUtils.trim(str4);

        //var str7 = str4.isBlank(); // ⚠️ NullPointerException 발생
        var str8 = StringUtils.isBlank(str4);

        int[] arr1 = {1, 2, 3, 4, 5};

        //  배열에 원소를 추가한 또 다른 배열을 반환
        int[] arr2 = ArrayUtils.add(arr1, 8);

        //  배열에 원소를 제거한 또 다른 배열을 반환
        int[] arr3 = ArrayUtils.removeElement(arr2, 3);

        //  ⚠️ 매 번 새로운 배열 공간 차지 - 자주 사용된다면 리스트로

        ArrayUtils.reverse(arr3);
    }
}
