package com.logic.android.readingjournal;

/**
 * Created by dominik on 02.10.17.
 */

public class BookListActivity extends SingleFragmentActivity {
    @Override
    protected BookListFragment createFragment() {
        return new BookListFragment();
    }
}
