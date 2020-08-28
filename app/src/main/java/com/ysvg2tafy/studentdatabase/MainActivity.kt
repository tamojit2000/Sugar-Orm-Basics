package com.ysvg2tafy.studentdatabase

import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.orm.SugarContext
import com.orm.SugarDb
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.IOException

open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SugarContext.init(this)


        button.setOnClickListener {
            val obj=Student(editText.text.toString(),editText2.text.toString())
            obj.save()
            Toast.makeText(this,"Done",Toast.LENGTH_SHORT).show()
        }

        button2.setOnClickListener {
            startActivity(Intent(this,Main2Activity::class.java))
        }

        button3.setOnClickListener {
            try {
                copyDatabase()
                Toast.makeText(this,"Copied",Toast.LENGTH_SHORT).show()
            } catch (e: IOException) {
                e.printStackTrace()
                Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT).show()
            }
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        SugarContext.terminate()
    }

    @Throws(IOException::class)
    open fun copyDatabase() {
        val actualFile = File(SugarDb(this@MainActivity).db.path)
        val cuurentfile = File(actualFile.toString())
        Log.e("actualPath", actualFile.toString())
        val newFile = File.createTempFile(
            "sugarFiles",
            ".db",
            externalCacheDir
        )


        Log.e("newPath", newFile.toString())
        val yes =
            FileUtils.copyFile(cuurentfile, newFile)
        if (yes) {
            Log.e("result", "" + true)
        }
    }

}
