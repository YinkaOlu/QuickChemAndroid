package com.yinkaolu.quickchemandroid

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.yinkaolu.quickchemandroid.data.model.PeriodicTable
import com.yinkaolu.quickchemandroid.viewmodel.ElementsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var periodicTable: PeriodicTable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialProgressBar.visibility = View.VISIBLE

        val model = ElementsViewModel()
        model.elements.observe(this, Observer { elements ->
            elements?.let {
                Toast.makeText(this, "Elements Loaded", Toast.LENGTH_LONG).show()
            }
        })

        model.periodicTable.observe(this, Observer { periodicTable ->
            periodicTable?.let {
                elementList.apply {
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = ElementListAdaptor(it)
                }
                initialProgressBar.visibility = View.INVISIBLE
                elementList.visibility = View.VISIBLE
            }
        })
    }
}
