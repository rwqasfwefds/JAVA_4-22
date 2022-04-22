package Generics;

import java.util.ArrayList;

// ���׸��� �׽�Ʈ�� �������̽�
interface Eatable{}

// ���׸��� �׽�Ʈ�� Ŭ������
class Fruit implements Eatable{
    // ���� Object �޼ҵ� toString() �������̵� ����
    // ���� Object toString()�� �׳� ����ϸ� �ּҰ��� ����
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

// ���׸��� Ŭ���� ����
// ���������� ���� ����
class Box<T>{
    ArrayList<T> list = new ArrayList<T>();

    // ArrayList�� �⺻ �޼ҵ� add�� �ٽ� ����
    // ArrayList�� �ڷ�����
    void add(T item){
        list.add(item);
    }

    // ArrayList �Ű����� index��ȣ�� �ش��ϴ� �ڷ� ��������
    T get(int i){
        return list.get(i);
    }

    // ���� �迭(ArrayList)�� ũ�� cf) �迭�� length�� ����
    int size(){
        return list.size();
    }

    public String toString() {
        return list.toString();
    }
}

// ���׸��� Ŭ���� ����
class FruitBox<T extends Fruit & Eatable> extends Box<T>{}

public class Ex12_3 {
    public static void main(String[] args) {
        FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
        FruitBox<Apple> appleBox = new FruitBox<Apple>();
        FruitBox<Grape> grapeBox = new FruitBox<Grape>();

        // ArrayList�� �ڷ�����
        // add �޼ҵ带 ȣ�� �� �� ���� ���������� �迭������ ���� ���� : [0]
        // add �޼ҵ带 ȣ�� �� �� ���� ���������� �迭������ ���� ���� : [1]
        // add �޼ҵ带 ȣ�� �� �� ���� ���������� �迭������ ���� ���� : [2]
        fruitBox.add(new Fruit());
        fruitBox.add(new Apple());
        fruitBox.add(new Grape());
        appleBox.add(new Apple());
        grapeBox.add(new Grape());

        // ���
        // ������ toString()�������̵� : Fruit, Apple, Grape ���
        // �������̵� �� �ϸ� �ּҰ��� ��µ�
        System.out.println("fruitBox - " + fruitBox);
        System.out.println("appleBox - " + appleBox);
        System.out.println("grapeBox - " + grapeBox);
    }
}
