package com.example.taskmanager

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.example.taskmanager.databinding.ActivityMainBinding
import com.example.taskmanager.dataclass.Dao
import com.example.taskmanager.dataclass.Data
import com.example.taskmanager.dataclass.UserDatabase
import com.example.taskmanager.dataclass.infoAdapter

class MainActivity : AppCompatActivity(), infoAdapter.handleclicks {
    lateinit var binding: ActivityMainBinding
    private lateinit var dao: Dao

    lateinit var adapter: infoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db= Room.databaseBuilder(
            applicationContext,
            UserDatabase::class.java,
            "user.db"
        ).allowMainThreadQueries().build()

        dao=db.userDao()
        showview()
        binding.addUserBtn.setOnClickListener {
            val anything = Intent(this@MainActivity, Usertask::class.java)
            startActivity(anything)
        }
    }
    override fun onResume() {
        super.onResume()
        showview()
    }

    private fun showview() {
        dao.getAllUser().apply {
            adapter= infoAdapter(this@MainActivity,this)
            binding.kkName.adapter=adapter
        }
    }

    override fun ed(data: Data) {
        val everything = Intent(this@MainActivity,Usertask::class.java)
        everything.putExtra("data",data)
        startActivity(everything)
    }

    override fun dlt(data: Data) {
        dao.delete(data)
        showview()
    }

}


