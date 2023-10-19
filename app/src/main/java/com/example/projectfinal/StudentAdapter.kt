package com.example.projectfinal

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(
    private val context: Context,
    private val studentList: ArrayList<student_data>,
    private val message:String
) : RecyclerView.Adapter<StudentAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rollnoTextView: TextView = itemView.findViewById(R.id.rollnoTextView)
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val pdf1:LinearLayout=itemView.findViewById(R.id.imageView3)


        init {
            // Add an OnClickListener to the item view
            itemView.setOnClickListener {
                val position = adapterPosition
                val clickedItem = studentList[position]
                pdf1.setOnClickListener {
                    val intent = Intent(context, pdf::class.java)
                    intent.putExtra("Id", clickedItem.Id)
                    context.startActivity(intent)


                }
                if (position != RecyclerView.NO_POSITION) {
                    // Get the clicked item
                    val clickedItem = studentList[position]
                    // if tutor redirect to student page
                    if(message=="staff@gmail.com")
                    {

                        val intent = Intent(context, student::class.java)
                        intent.putExtra("Id",clickedItem.Id)
                        context.startActivity(intent)

                    }
                    else {
                        // Create an Intent to open the SeparateActivity
                        val intent = Intent(context, Separateactivity::class.java)

                        // Pass data to SeparateActivity if needed
                        intent.putExtra("rollno", clickedItem.rollno)
                        intent.putExtra("name", clickedItem.name)
                        intent.putExtra("Id", clickedItem.Id)

                        // Start SeparateActivity
                        context.startActivity(intent)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_item_layout, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = studentList[position]
        holder.rollnoTextView.text = currentItem.rollno
        holder.nameTextView.text = currentItem.name

    }

    override fun getItemCount(): Int {
        return studentList.size
    }
}
