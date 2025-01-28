package sec14.chap04;

public class Ex04 {

    public static void main(String[] args) {

        Person person1 = new Person(
            "홍길동", 20, 175.5, false,
            "AB", 81.2,
            new Career("ABC Market", 2)
        );

        Gson gson = new Gson();
        String person1Json = gson.toJson(person1);

        String person2Json = "{\"name\":\"홍길동\",\"age\":20,\"height\":175.5,\"married\":false,\"career\":{\"company\":\"ABC Market\",\"years\":2}}";
        Person person2 = gson.fromJson(person2Json, Person.class);
        //  transient 필드인 bloodType은 null
    }
}
