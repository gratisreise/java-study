package sec14.chap04;

import java.util.List;

public class Ex03 {

    public static void main(String[] args) {
        //  💡 Bag : 중복 포함 가능, 개수 카운트
        Bag<String> bag = new HashBag<>();

        bag.add("아아");
        bag.add("아아");
        bag.add("뜨아");
        bag.add("뜨아", 3); // n개씩 추가 가능

        var iceAmericanos = bag.getCount("아아");
        var hotAmericanos = bag.getCount("뜨아");
        var inMyTimes = bag.getCount("라떼");

        //  💡 MultiMap : key에 여러 value를 가질 수 있음
        MultiMap<String, String> multiMap = new MultiValueMap<>();

        multiMap.put("철수", "개근상");
        multiMap.put("영희", "우수상");
        multiMap.put("영희", "인기상");
        multiMap.put("영희", "모범상");
        multiMap.put("잡돌", "개진상");

        var chulsooAwards = multiMap.get("철수");
        var youngheeAwards = multiMap.get("영희");
        var jabdolAwards = multiMap.get("잡돌");

        //  컬렉션들의 합집합, 차집합, 여집합 등
        List<Character> chrList1 = List.of('A', 'B', 'C', 'D');
        List<Character> chrList2 = List.of('C', 'D', 'E', 'F');

        List<Character> chrUnion = ListUtils.union(chrList1, chrList2);
        List<Character> chrSymmetricDifference = ListUtils.sum(chrList1, chrList2);
        List<Character> chrSubtract = ListUtils.subtract(chrList1, chrList2);
        List<Character> chrIntersection = ListUtils.intersection(chrList1, chrList2);
        List<Character> chrDisjunction = (List<Character>) CollectionUtils.disjunction(chrList1, chrList2);


    }

}
