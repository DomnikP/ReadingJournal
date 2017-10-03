package com.logic.android.readingjournal;

import java.util.Date;
import java.util.UUID;

/**
 * Created by dominik on 23.09.17.
 */

public class Book {

    private UUID mId;
    private String mTitle;
    private String mAuthor;
    private String mGenre;
    private Date mDate;
    private boolean mRead;

    public Book() {
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        mAuthor = author;
    }

    public String getGenre() {
        return mGenre;
    }

    public void setGenre(String genre) {
        mGenre = genre;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isRead() {
        return mRead;
    }

    public void setRead(boolean read) {
        mRead = read;
    }
}
