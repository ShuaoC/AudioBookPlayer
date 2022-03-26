package edu.temple.audiobookplayer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val BookListKey = "param1"

class BookListFragment : Fragment() {
    private var bookList: ArrayList<BookObject>? = null
    private var recyclerView : RecyclerView = null

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
            layoutManager = LinearLayoutManager(requireContext())

        }
    }

    class BookAdapter(_books : ArrayList<BookObject>, _clickEvent : (String) -> Unit) : RecyclerView.Adapter<BookAdapter.BookViewHolder>(){

        val books = _books
        val clickEvent = _clickEvent

        class BookViewHolder(_view : View) : RecyclerView.ViewHolder(_view){
            val view = _view
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
            return BookViewHolder()
        }

        override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
            TODO("Not yet implemented")
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