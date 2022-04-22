package Generics;

import java.util.ArrayList;
import java.util.Iterator;

class Student{
    String name = "";
    int ban;
    int no;

    Student(String name, int ban, int no){
        this.name = name;
        this.ban = ban;
        this.no = no;
    }
}

public class Ex12_2 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<Student>();
        // ArrayList : 향상된 배열
        // add : 매개변수의 값이 내부 배열로 저장 ex)
        list.add(new Student("자바왕", 1, 1));
        list.add(new Student("자바짱", 1, 2));
        list.add(new Student("홍길동", 1, 3));

        // Iterator : 향상된 for문과 비슷
        // 향상된 배열(ArrayList) -> Iterator 변환
        Iterator<Student> it = list.iterator();
        // while(it.hasNext()) : 배열 같은 자료형에서 자료가 없을때까지 반복을 함
        while(it.hasNext()){ // 자료 있으면 true, 없으면 false
            Student s = it.next(); // 자료있으면 임시변수 s 넣기
            System.out.println(s.name);
        }
    }
}
