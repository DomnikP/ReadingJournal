package com.logic.android.readingjournal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by dominik on 02.10.17.
 */

public class BookListFragment extends Fragment{

    private RecyclerView mBookRecyclerView;
    private BookAdapter mAdapter;

    public void updateUI() {
        BookList bookList = BookList.get(getActivity());
        List<Book> books = bookList.getBooks();

        mAdapter = new BookAdapter(books);
        mBookRecyclerView.setAdapter(mAdapter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_list, container, false);

        mBookRecyclerView =  (RecyclerView) view.findViewById(R.id.book_recycler_view);
        mBookRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;

    }

    private class BookHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTitleTextView;
        private TextView mAuthorTextView;
        private ImageView mReadImageView;

        private Book mBook;

        public BookHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_book, parent,false));
            mTitleTextView= (TextView) itemView.findViewById(R.id.book_title);
            mAuthorTextView = (TextView) itemView.findViewById(R.id.book_author);
            mReadImageView = (ImageView) itemView.findViewById(R.id.book_read);
            itemView.setOnClickListener(this);
        }

        public void bind(Book book) {
            mBook = book;
            mTitleTextView.setText(mBook.getTitle());
            mAuthorTextView.setText(mBook.getAuthor());
            mReadImageView.setVisibility(book.isRead() ? View.VISIBLE : View.GONE);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(getActivity(), mBook.getTitle() + "Clicked!" , Toast.LENGTH_SHORT).show();
        }
    }

    private class BookAdapter extends RecyclerView.Adapter<BookHolder> {
        private List<Book> mBooks;

        public BookAdapter(List<Book> books) {
            mBooks = books;
        }

        @Override
        public BookHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new BookHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(BookHolder holder, int position) {

            Book book = mBooks.get(position);
            holder.bind(book);

        }

        @Override
        public int getItemCount() {
            return mBooks.size();
        }
    }


}
