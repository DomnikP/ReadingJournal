package com.logic.android.readingjournal;

public class BookActivity extends SingleFragmentActivity {


    @Override
    protected BookListFragment createFragment() {
        return new BookListFragment();
    }
}
