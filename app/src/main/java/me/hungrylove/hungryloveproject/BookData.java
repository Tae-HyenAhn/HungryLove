package me.hungrylove.hungryloveproject;

import java.util.ArrayList;

/**
 * Created by sb on 2017. 4. 26..
 * 싱글톤으로 책 데이터 관리
 */

public class BookData {
    private ArrayList<Book> bookData;

    private static BookData instance;

    public BookData() {
        bookData = new ArrayList<Book>();
    }

    public static BookData getInstance(){
        if(instance == null){
            instance = new BookData();
        }
        return instance;
    }

    public ArrayList<Book> getArrayList(){
        return bookData;
    }
}
