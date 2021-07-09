package com.example.mvvmexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmexample.databinding.ItemViewBinding

class NoteRecyclerAdapter(val viewModel: MainViewModel, var arrayList: ArrayList<Blog>, val context: Context,
                          val item: OnClickItem): RecyclerView.Adapter<NoteRecyclerAdapter.RecyclerViewHolders>() {


    override fun onBindViewHolder(holder: NoteRecyclerAdapter.RecyclerViewHolders, position: Int) {
        val watchlistData = arrayList[position]
        holder.binding.viewModel = watchlistData
        //val blog:Blog= arrayList[position]

        //holder?.title?.text=blog.title
        //holder?.delete?.image=blog.title
       // holder.delete.setOnClickListener{
            //val pos=arrayList[position] as
           // item.clickItem(position)

        //}

       //holder.bind(arrayList.get(position))
    }

    //class NotesViewHolder (itemView:View):RecyclerView.ViewHolder(itemView)
    //{
   //     val title=itemView.findViewById(R.id.title) as TextView
       // val delete =itemView.findViewById(R.id.delete) as ImageButton
   // }

    override fun getItemCount(): Int {
        if(arrayList.size==0){
            Toast.makeText(context,"List is empty",Toast.LENGTH_LONG).show()
        }else{

        }
        return arrayList.size
    }

    fun updateList(updatedarrayList: ArrayList<Blog>?) {
        arrayList= updatedarrayList!!
        notifyDataSetChanged()
        System.out.println(arrayList.size)
    }

    class RecyclerViewHolders(val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolders {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        return RecyclerViewHolders(binding)
    }


    //inner  class NotesViewHolder(private val binding: View) : RecyclerView.ViewHolder(binding) {
        //val title=binding.findViewById(R.id.title) as TextView
        //val delete =binding.findViewById(R.id.delete) as ImageView
       // fun bind(blog: Blog){

            //binding.title.text = blog.title
           // binding.delete.setOnClickListener {
                //viewModel.remove(blog)
                //notifyItemRemoved(arrayList.indexOf(blog))
            //}
       // }

    }

//}
