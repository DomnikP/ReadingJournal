package com.logic.android.readingjournal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.List;
import java.util.UUID;

/**
 * Created by dominik on 18.11.17.
 */

public class BookPagerActivity extends AppCompatActivity {

    private static final String EXTRA_BOOK_ID = "com.logic.android.readingjournal";
    private ViewPager mViewPager;
    private List<Book> mBooks;

    public static Intent newIntent(Context packageContext, UUID bookId) {
        Intent intent = new Intent (packageContext, BookPagerActivity.class);
        intent.putExtra(EXTRA_BOOK_ID, bookId);
        return intent;
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_pager);

        mViewPager = (ViewPager) findViewById(R.id.book_view_pager);
        UUID bookId = (UUID) getIntent().getSerializableExtra(EXTRA_BOOK_ID);

        mBooks = BookList.get(this).getBooks();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            //Fetches the Book instance for the given position in the data set, then uses that Book's ID
            //to create and return a properly configured BookFragment
            public Fragment getItem(int position) {
                Book book = mBooks.get(position);
                return BookFragment.newInstance(book.getId());
            }

            //Returns the number of items in the ArrayList
            @Override
            public int getCount() {
                return mBooks.size();
            }
        });


        for (int i = 0; i< mBooks.size(); i++) {
            if (mBooks.get(i).equals(bookId)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
