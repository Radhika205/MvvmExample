package com.example.mvvmexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.ViewModelProviders
import kotlin.collections.remove as remove1

class MainActivity : AppCompatActivity(),OnClickItem{
    private var updatedarrayList: ArrayList<Blog>?=null
    private var arrayList: ArrayList<Blog>?=null
    private var viewManager = LinearLayoutManager(this)
private lateinit var viewModel: MainViewModel
private lateinit var mainrecycler: RecyclerView
    lateinit var noteRecyclerAdapter: NoteRecyclerAdapter
private lateinit var but: Button
lateinit var item: OnClickItem
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainrecycler = findViewById(R.id.recycler)
        val application = requireNotNull(this).application
        val factory = MainViewModelFactory()
        viewModel = ViewModelProviders.of(this,factory).get(MainViewModel::class.java)
        but = findViewById(R.id.button)
        but.setOnClickListener {
            addData()

        }
        item=this

        initialiseAdapter()
    }
    private fun initialiseAdapter(){
        mainrecycler.layoutManager = viewManager
        observeData()
    }

    fun observeData(){
        viewModel.lst.observe(this, Observer{
            Log.i("data",it.toString())
            arrayList = it
            mainrecycler.adapter= NoteRecyclerAdapter(viewModel, it, this,item)
        })
    }


    fun addData(){
        var txtplce = findViewById<EditText>(R.id.titletxt)
        var title=txtplce.text.toString()
        if(title.isNullOrBlank()){
            Toast.makeText(this,"Enter value!",Toast.LENGTH_LONG).show()
        }else{
            var blog= Blog(title)
            viewModel.add(blog)
            txtplce.text.clear()
            mainrecycler.adapter?.notifyDataSetChanged()
        }

    }

    override fun clickItem(position: Int) {
        //var updatedarrayList= arrayList?.drop(position)
        //var a = arrayList?.remove1(updatedarrayList)
       // noteRecyclerAdapter.updateList(updatedarrayList)
        //System.out.println( "position" +position)
    }
}

