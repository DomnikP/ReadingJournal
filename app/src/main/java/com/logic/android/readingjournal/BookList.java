package com.logic.android.readingjournal;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by dominik on 02.10.17.
 */

public class BookList {

    private static BookList sBookList; //Singleton(only one Instance of itself will be created)

    private List<Book> mBooks;

    public static BookList get (Context context) {
        if (sBookList == null) {
            sBookList = new BookList(context);
        }
        return sBookList;
    }

    //Private constructor to ensure that other class can't create a BookList
    private BookList (Context context) {
        mBooks = new ArrayList<>();
        for (int i = 0; i< 100; i++) {
            Book book = new Book();
            book.setTitle("Book #" + i);
            book.setRead(i%2==0);
            mBooks.add(book);
        }
    }

    public List<Book> getBooks() {
        return mBooks;
    }

    public Book getBook(UUID id) {
        for (Book book : mBooks) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }
}
