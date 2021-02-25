package com.hanifkf12.myrecyclerapp1.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.hanifkf12.myrecyclerapp1.adapter.MyAdapter
import com.hanifkf12.myrecyclerapp1.util.MySharedPref
import com.hanifkf12.myrecyclerapp1.model.Note
import com.hanifkf12.myrecyclerapp1.databinding.ActivityMainBinding
import com.hanifkf12.myrecyclerapp1.db.MyDatabase
import com.hanifkf12.myrecyclerapp1.presenter.MainPresenterImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), MainView {
    private lateinit var binding: ActivityMainBinding
    private val notesData = mutableListOf<Note>()
    private lateinit var myPref: MySharedPref
    private lateinit var adapter : MyAdapter
    private lateinit var presenter: MainPresenterImp
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = MyDatabase.getInstance(this)
        presenter = MainPresenterImp(this, database.noteDao())
        presenter.getData()

        adapter = MyAdapter(notesData)
        adapter.setOnItemClickListener {
            Toast.makeText(this, it.title, Toast.LENGTH_SHORT).show()
        }

        binding.rvNote.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        binding.rvNote.layoutManager = GridLayoutManager(this, 2)
        binding.rvNote.adapter = adapter

        binding.floatingActionButton.setOnClickListener {
            val note = Note(null,"Note ${(0..100).random()}", "Ini Content ${(0..100).random()} nya")
            presenter.addData(note)
        }

    }

    override fun showData(data: List<Note>?) {
        GlobalScope.launch(Dispatchers.Main) {
            data?.let {
                notesData.clear()
                notesData.addAll(it)
                adapter.notifyDataSetChanged()
            }
        }
    }

    override fun showLoading() {
        Log.d("LOADING","loading....")
    }
}