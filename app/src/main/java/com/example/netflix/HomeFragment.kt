package com.example.netflix

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class HomeFragment : Fragment() {


    private lateinit var movieAdapter: NewsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val addBtn: FloatingActionButton = view.findViewById(R.id.floatingActionButton)

        addBtn.setOnClickListener{
            startActivity(Intent(requireContext(), AddActivity::class.java))

        }

        val recycle = view.findViewById<RecyclerView>(R.id.Rview)

        /*GlobalScope.launch(Dispatchers.IO) {
            recycle.adapter = NewsAdapter(AppDataBase.getInstance(requireContext()).movieDao().getAll())
        }
        val db =AppDataBase.getInstance(requireContext())
        val moviesList=db.movieDao().getAll()
       */

        GlobalScope.launch(Dispatchers.IO) {
            val db =AppDataBase.getInstance(requireContext())
            val movies = db.movieDao().getAll()
            withContext(Dispatchers.Main) {
                movieAdapter= NewsAdapter(movies)
                recycle.adapter=movieAdapter
            }
        }
        recycle.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        return view




    }


}