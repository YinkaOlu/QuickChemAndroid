package com.yinkaolu.quickchemandroid

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.yinkaolu.quickchemandroid.viewmodel.ElementsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var periodicTable: PeriodicTable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialProgressBar.visibility = View.VISIBLE

        val model = ElementsViewModel()
        model.getElements().observe(this, Observer { elements ->
            elements?.let {
                periodicTable = PeriodicTable(it)
                elementList.apply {
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = ElementListAdaptor(periodicTable)
                }
                initialProgressBar.visibility = View.INVISIBLE
                elementList.visibility = View.VISIBLE
            }
        })
    }
}
