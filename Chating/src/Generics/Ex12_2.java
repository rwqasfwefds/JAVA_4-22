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
        // ArrayList : ���� �迭
        // add : �Ű������� ���� ���� �迭�� ���� ex)
        list.add(new Student("�ڹٿ�", 1, 1));
        list.add(new Student("�ڹ�¯", 1, 2));
        list.add(new Student("ȫ�浿", 1, 3));

        // Iterator : ���� for���� ���
        // ���� �迭(ArrayList) -> Iterator ��ȯ
        Iterator<Student> it = list.iterator();
        // while(it.hasNext()) : �迭 ���� �ڷ������� �ڷᰡ ���������� �ݺ��� ��
        while(it.hasNext()){ // �ڷ� ������ true, ������ false
            Student s = it.next(); // �ڷ������� �ӽú��� s �ֱ�
            System.out.println(s.name);
        }
    }
}
