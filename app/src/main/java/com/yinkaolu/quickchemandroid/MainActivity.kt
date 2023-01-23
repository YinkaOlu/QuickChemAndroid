package com.yinkaolu.quickchemandroid

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.yinkaolu.quickchemandroid.viewmodel.ElementsViewModel
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: ElementsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.elements.observe(this, Observer { elements ->
            elements?.let {
                Toast.makeText(this, "Elements Loaded", Toast.LENGTH_LONG).show()
            }
        })

        viewModel.periodicTable.observe(this, Observer { periodicTable ->
            periodicTable?.let {
                it.actinide
            }
        })
    }
}
