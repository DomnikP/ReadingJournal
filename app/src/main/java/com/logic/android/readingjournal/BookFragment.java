package com.logic.android.readingjournal;

import android.os.Bundle;
import android.support.annotation.CheckResult;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

/**
 * Created by dominik on 23.09.17.
 */

public class BookFragment extends Fragment {

    private Book mBook;
    private EditText mTitleField;
    private EditText mAuthorField;
    private EditText mGenreField;
    private Button mDateButton;
    private CheckBox mReadCheckBox;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBook = new Book();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_book, container,false);

        mTitleField = (EditText) v.findViewById(R.id.book_title);
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
                //Not needed
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mBook.setTitle(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {
                //Not needed

            }
        });

        mAuthorField = (EditText) v.findViewById(R.id.book_author);
        mAuthorField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
                //Not needed
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mBook.setAuthor(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {
                //Not needed

            }
        });

        mGenreField = (EditText) v.findViewById(R.id.book_genre);
        mGenreField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
               //Not needed
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mBook.setGenre(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {
                //Not needed

            }
        });

        mDateButton = (Button) v.findViewById(R.id.read_date);
        mDateButton.setText(mBook.getDate().toString());
        mDateButton.setEnabled(false);

        mReadCheckBox = (CheckBox) v.findViewById(R.id.book_read);
        mReadCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mBook.setRead(isChecked);

            }
        });
        return v;
    }
}
