package com.logic.android.readingjournal;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

/**
 * Created by dominik on 02.10.17.
 */

public class BookListActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return new BookListFragment();
    }
}
