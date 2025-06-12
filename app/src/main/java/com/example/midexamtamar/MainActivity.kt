package com.example.midexamtamar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MovieRecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        Client.init()
        val apiService = Client.getReqResService()
        val call = apiService.getCities(1)

        call.enqueue(object : Callback<ReqresObj<List<Model>>> {
            override fun onResponse(
                call: Call<ReqresObj<List<Model>>>,
                response: Response<ReqresObj<List<Model>>>
            ) {
                if (response.isSuccessful) {
                    val movieList = response.body()?.data?.toMutableList() ?: mutableListOf()
                    adapter = MovieRecyclerView(movieList)
                    recyclerView.adapter = adapter

                    // Swipe ფუნქციონალი
                    val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
                        override fun onMove(
                            recyclerView: RecyclerView,
                            viewHolder: RecyclerView.ViewHolder,
                            target: RecyclerView.ViewHolder
                        ): Boolean = false

                        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                            val position = viewHolder.adapterPosition
                            val movie = adapter.movies[position]

                            when (direction) {
                                ItemTouchHelper.RIGHT -> {
                                    Snackbar.make(recyclerView, "${movie.name} დაემატა ფავორიტებში", Snackbar.LENGTH_SHORT).show()
                                    adapter.notifyItemChanged(position)
                                }
                                ItemTouchHelper.LEFT -> {
                                    adapter.movies.removeAt(position)
                                    adapter.notifyItemRemoved(position)
                                    Snackbar.make(recyclerView, "${movie.name} წაიშალა", Snackbar.LENGTH_SHORT).show()
                                }
                            }
                        }
                    }

                    val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
                    itemTouchHelper.attachToRecyclerView(recyclerView)
                } else {
                    Snackbar.make(recyclerView, "Error: Response not successful", Snackbar.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<ReqresObj<List<Model>>>, t: Throwable) {
                Snackbar.make(recyclerView, "ჩატვირთვა ვერ მოხერხდა: ${t.localizedMessage}", Snackbar.LENGTH_LONG).show()
            }
        })
    }
}
