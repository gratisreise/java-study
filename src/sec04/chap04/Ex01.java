package sec04.chap04;

public class Ex01 {

    public static void main(String[] args) {
        int i = 0;

        //  💡 while 문의 괄호에는 종료조건만
        while (i < 10) {
            // 종료조건 충족을 위한 값 변화는 외적으로
            System.out.println(i++);
        }

        //  💡 의도적인 무한 루프에 널리 쓰이는 코드
//        while (true) {
//            System.out.println("인간의 욕심은 끝이 없고");
//            System.out.println("같은 실수를 반복한다.");
//        }

        double popInBillion = 7.837;

        //  ⭐️ break 를 통한 반복 탈출
        while (true) {
            System.out.println("세계인구: " + (popInBillion -= 0.1));
            if (popInBillion <= 0) break;

            System.out.println("인간의 욕심은 끝이 없고");
            System.out.println("같은 실수를 반복한다.");
        }

        System.out.println("인류 멸종");

        //  100보다 작은 3의 배수들 출력해보기

        //int i = 1;

        // ⚠️ 의도대로 작동하지 않음. 이유는?
        while (true) {
            if (i % 3 != 0) continue;  // 🔴
            System.out.println(i);

            if (i++ == 100) break;
        }

        //int i = 1;

        while (true) {
            if (i++ == 100) break;
            if ((i - 1) % 3 != 0) continue;

            System.out.println(i - 1);
        }

        //int i = 1;

        //  보다 가독성을 높이고 의도를 잘 드러낸 코드
        while (true) {
            int cur = i++;

            if (cur == 100) break;
            if (cur % 3 != 0) continue;

            System.out.println(cur);

        }

    }

}
