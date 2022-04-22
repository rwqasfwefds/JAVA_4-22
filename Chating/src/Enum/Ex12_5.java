package Enum;

// 열거형 : 상수만 가넝
// EAST : 0, SOUTH : 1, WEST : 2, NORTH : 3
enum Direction{EAST, SOUTH, WEST, NORTH};

public class Ex12_5 {
    public static void main(String[] args) {
        // 열거형 사용법 3가지
        Direction d1 = Direction.EAST; // 사용하기 제일 간단
        Direction d2 = Direction.valueOf("WEST"); // WEST
        Direction d3 = Enum.valueOf(Direction.class, "EAST"); // Direction 얘 자체가 내부적으로 클래스가 되어서 이렇게도 가능

        System.out.println("d1 = " + d1);
        System.out.println("d2 = " + d2);
        System.out.println("d3 = " + d3);

        // 열거형은 "=="로 비교 쌉건웅
        System.out.println("d1 == d2 ? " + (d1 == d2));
        System.out.println("d1 == d3 ? " + (d1 == d3));
        System.out.println("d1.equals(d3) ? " + d1.equals(d3));
        System.out.println("d1.compareTo(d3) ? " + (d1.compareTo(d3)));
        // (열거형일 경우) d1(0) - d2(2) = -2 가 나옴
        // 일반적인 비교 : 크면 1, 같으면 0, 작으면 -1
        System.out.println("d1.compareTo(d2) ? " + (d1.compareTo(d2)));

        switch(d1){
            case EAST:
            System.out.println("The direction is EAST");
            break;
            case SOUTH:
            System.out.println("The direction is SOUTH");
            break;
            case WEST:
            System.out.println("The direction is WEST");
            break;
            case NORTH:
            System.out.println("The direction is NORTH");
            break;
            default:
            System.out.println("Invalid direction.");
        }

        // 열거형의 자료들을 배열로 반환(return)
        Direction[] dArr = Direction.values(); 

        // 향상된 for 문
        for(Direction d : dArr){
            // name() : 열거형의 상수이름을 반환(리턴)
            // ordinal() : 열거형의 상수 순서를 반환
            System.out.printf("%s = %d%n", d.name(), d.ordinal());
        }
    }
}
