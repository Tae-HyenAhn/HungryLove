package me.hungrylove.hungryloveproject;

/**
 * Created by sb on 2017. 4. 26..
 */

public class Book {
    private int pageNum;
    private String bookTitle;
    private String author;
    private String intro;
    private String title;
    private String content;

    public Book(int pageNum, String bookTitle, String author, String intro, String title, String content) {
        this.pageNum = pageNum;
        this.bookTitle = bookTitle;
        this.author = author;
        this.intro = intro;
        this.title = title;
        this.content = content;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
