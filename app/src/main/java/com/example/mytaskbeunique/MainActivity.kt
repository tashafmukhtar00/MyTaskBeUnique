package com.example.mytaskbeunique

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mytaskbeunique.adapter.CustomAdapter
import com.example.mytaskbeunique.adapter.imagemodel.DataX
import com.example.mytaskbeunique.model.DataY
import com.example.mytaskbeunique.network.*
import com.example.mytaskbeunique.viewmodel.MyViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private val TAG: String = "tAshaf"
    private lateinit var viewModel: MyViewModel

    private lateinit var continueButton: ImageView
    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        initViews()



        continueButton.setOnClickListener {
            val moveToNextScreen = Intent(applicationContext, SecondActivity::class.java)
            startActivity(moveToNextScreen)

        }


        /** Setting up LiveData observation relationship **/
        viewModel.property.observe(this, Observer { newProperty ->

            //   Toast.makeText(applicationContext, "me " + newProperty.size, Toast.LENGTH_SHORT).show()
            val customAdapter = CustomAdapter(applicationContext, newProperty)
            val layoutManager = GridLayoutManager(applicationContext, 2)
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = customAdapter
        })


//        MarsApi.retrofitService.getProperties().enqueue(
//            object : Callback<List<MarsProperties>> {
//                override fun onResponse(
//                    call: Call<List<MarsProperties>>,
//                    response: Response<List<MarsProperties>>
//                ) {
//                    textView.text =  "${response.body()?.size} has been read from server"
//                }
//
//                override fun onFailure(call: Call<List<MarsProperties>>, t: Throwable) {
//                    TODO("Not yet implemented")
//                }
//
//            }
        //        )


        InterestApi.retrofitService.getPhotsX().enqueue(
            object : Callback<List<DataX>> {
                override fun onResponse(
                    call: Call<List<DataX>>,
                    response: Response<List<DataX>>
                ) {

                    Log.d(TAG, "onResponse: " + (response.body()?.size))

                }

                override fun onFailure(call: Call<List<DataX>>, t: Throwable) {
                    Log.d(TAG, "onResponse: " + t.message)
                }

            }
        )


    }

    private fun initViews() {

        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        continueButton = findViewById(R.id.imageView_continue)
        recyclerView = findViewById(R.id.recyclerview_images)
    }
}