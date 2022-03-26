package edu.temple.audiobookplayer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val BookListKey = "param1"

class BookListFragment : Fragment() {
    private var bookList: ArrayList<BookObject>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            bookList = it.getParcelableArrayList<BookObject>(BookListKey);
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_book_list, container, false) as RecyclerView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(view as RecyclerView){
            bookList?.run {

                val clickEvent = {
                    book : String? ->
                }
                layoutManager = LinearLayoutManager(requireContext())
                adapter = BookAdapter(this,clickEvent)
            }
        }
    }

    class BookAdapter(_books : ArrayList<BookObject>, _clickEvent : (String?) -> Unit) : RecyclerView.Adapter<BookAdapter.BookViewHolder>(){

        val books = _books
        val clickEvent = _clickEvent

        class BookViewHolder(_view : View) : RecyclerView.ViewHolder(_view){
            val view = _view
            val titleTxt = _view.findViewById<TextView>(R.id.titleText)
            val authorTxt = _view.findViewById<TextView>(R.id.authorText)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
            return BookViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.book_list_layout, parent, false)
            )
        }

        override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
            holder.titleTxt.text = books[position].title
            holder.authorTxt.text = books[position].author
            holder.view.setOnClickListener{clickEvent(books[position].title)}
        }

        override fun getItemCount(): Int {
            return books.size
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(bookList: BookList) =
            BookListFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(BookListKey, bookList.list)
                }
            }
    }
}