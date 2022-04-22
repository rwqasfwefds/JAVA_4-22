package Generics;

import java.util.ArrayList;

// 지네릭스 테스트용 클래스 3개 정의
class Product{}
class Tv extends Product{}
class Audio extends Product{}

public class Ex12_1 {
    public static void main(String[] args) {
        ArrayList<Product> productList = new ArrayList<Product>();
        ArrayList<Tv> tvList = new ArrayList<Tv>();

        // 향상된 배열 : ArrayList 자료 넣기
        productList.add(new Tv());
        productList.add(new Audio());

        // 향상된 배열 : ArrayList 자료 넣기
        tvList.add(new Tv());
        tvList.add(new Tv());

        printAll(productList);
    }    

    public static void printAll(ArrayList<Product> list){
        // 향상된 for문 
        for(Product p : list){
            System.out.println(p);
        }
    }
}
