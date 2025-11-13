package com.example.taskmanager

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.taskmanager.databinding.ActivityUsertaskBinding
import com.example.taskmanager.dataclass.Dao
import com.example.taskmanager.dataclass.Data
import com.example.taskmanager.dataclass.UserDatabase
import java.util.Calendar


@Suppress("DEPRECATION")
class Usertask : AppCompatActivity() {

    companion object{

        const val savechanges = "Save Changes"
        const val save = "Save"
        const val edit = "data"
    }
    lateinit var binding: ActivityUsertaskBinding
    private lateinit var dao: Dao
    var id = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        binding = ActivityUsertaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db= Room.databaseBuilder(
            applicationContext,
            UserDatabase::class.java,
            "user.db"
                    ).allowMainThreadQueries().build()

        dao=db.userDao()

        if (intent.hasExtra(edit)) {
            binding.saveBtn.text = savechanges
            val data = intent.getParcelableExtra<Data>(edit)
            binding.apply {
                hk1.setText(data?.title)
                hk2.setText(data?.description)
                hk3.setText(data?.date)
                id = data!!.id
            }
        }
            binding.hk3.setOnClickListener {
                showDatePicker()
            }


        binding.saveBtn.setOnClickListener {
            val title = binding.hk1.text.toString().trim()
            val description = binding.hk2.text.toString().trim()
            val date = binding.hk3.text.toString().trim()

            if (binding.saveBtn.text.toString() == save){
                addinfo(title,description,date)
            }else{
                updateinfo(title,description,date)
            }
        }
        binding.backBtn.setOnClickListener {
            val bb = Intent(this@Usertask, MainActivity::class.java)
            startActivity(bb)

        }

    }
    private fun updateinfo(title: String, description: String, date: String) {
        val user= Data(id,title,description,date)
        dao.updateUser(user)
        startActivity(Intent(this@Usertask,MainActivity::class.java))

        finish()
    }

    private fun addinfo(title: String, description: String, date: String) {
        val user= Data(id,title,description,date)
        dao.addUser(user)
        finish()
    }

    private fun showDatePicker() {
        val cldr = Calendar.getInstance()
        val month = cldr.get(Calendar.MONTH)
        val day = cldr.get(Calendar.DAY_OF_MONTH)
        val year = cldr.get(Calendar.YEAR)

        val dt1 = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->

            val formattedDate =
                String.format("%02d/%02d/%04d",selectedMonth + 1, selectedDay,  selectedYear)

            binding.hk3.setText(formattedDate)

        }, year, month, day)
        dt1.show()
    }
}