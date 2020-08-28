package com.ysvg2tafy.studentdatabase

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Note
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.orm.SugarRecord
import com.orm.SugarRecord.first
import com.orm.SugarRecord.listAll
import kotlinx.android.synthetic.main.activity_main2.*


class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var total_items=SugarRecord.count<Student>(Student::class.java).toInt()
        Toast.makeText(this,total_items.toString(),Toast.LENGTH_SHORT).show()

        var data=""

        Thread{
            val DB = Student.listAll(Student::class.java)

            //println(DB.Name)

            for ( i in 0..total_items-1){

                data+= DB[i].Name +" "+ DB[i].Roll +"\n"
            }

            textView.text=data
        }.start()



    }
}
