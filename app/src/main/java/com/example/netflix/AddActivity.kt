package com.example.netflix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        var addBtn:Button=findViewById(R.id.buttonAdd)

        var name:EditText=findViewById(R.id.tiName)
        var desc:EditText=findViewById(R.id.tiDesc)

        addBtn.setOnClickListener {
            var movie=DataMovie(0,R.drawable.news_img,name.text.toString(),desc.text.toString())
            GlobalScope.launch(Dispatchers.IO) {
                val dao = AppDataBase.getInstance(it.context).movieDao()

                    dao.insertGame(movie)
                   /* Snackbar.make(
                        findViewById(android.R.id.content),
                        "This movie added succ!",
                        Snackbar.LENGTH_SHORT
                    ).show()*/
                    startActivity(Intent(findViewById(android.R.id.content), HomeActivity::class.java))

                }
            }
        }



    }
