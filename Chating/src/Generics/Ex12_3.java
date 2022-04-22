package Generics;

import java.util.ArrayList;

// 지네릭스 테스트용 인터페이스
interface Eatable{}

// 지네릭스 테스트용 클래스들
class Fruit implements Eatable{
    // 조상 Object 메소드 toString() 오버라이딩 했음
    // 조상 Object toString()을 그냥 출력하면 주소값이 나옴
    @Override
    public String toString(){
        return "Fruit";
    }
}

class Apple extends Fruit{
    @Override
    public String toString(){
         return "Apple";
        }
    }
class Grape extends Fruit{
    @Override
    public String toString() {
        return "Grape";
    }
}
class Toy {
    @Override
    public String toString() {
        return "Toy";
    }
}

// 지네릭스 클래스 정의
// 공통팀에서 거의 만듦
class Box<T>{
    ArrayList<T> list = new ArrayList<T>();

    // ArrayList의 기본 메소드 add를 다시 정의
    // ArrayList에 자료저장
    void add(T item){
        list.add(item);
    }

    // ArrayList 매개변수 index번호에 해당하는 자료 가져오기
    T get(int i){
        return list.get(i);
    }

    // 향상된 배열(ArrayList)의 크기 cf) 배열의 length랑 동일
    int size(){
        return list.size();
    }

    public String toString() {
        return list.toString();
    }
}

// 지네리스 클래스 정의
class FruitBox<T extends Fruit & Eatable> extends Box<T>{}

public class Ex12_3 {
    public static void main(String[] args) {
        FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
        FruitBox<Apple> appleBox = new FruitBox<Apple>();
        FruitBox<Grape> grapeBox = new FruitBox<Grape>();

        // ArrayList에 자료저장
        // add 메소드를 호출 할 때 마다 내부적으로 배열공간을 만들어서 저장 : [0]
        // add 메소드를 호출 할 때 마다 내부적으로 배열공간을 만들어서 저장 : [1]
        // add 메소드를 호출 할 때 마다 내부적으로 배열공간을 만들어서 저장 : [2]
        fruitBox.add(new Fruit());
        fruitBox.add(new Apple());
        fruitBox.add(new Grape());
        appleBox.add(new Apple());
        grapeBox.add(new Grape());

        // 출력
        // 위에서 toString()오버라이딩 : Fruit, Apple, Grape 출력
        // 오버라이딩 안 하면 주소값이 출력됨
        System.out.println("fruitBox - " + fruitBox);
        System.out.println("appleBox - " + appleBox);
        System.out.println("grapeBox - " + grapeBox);
    }
}
