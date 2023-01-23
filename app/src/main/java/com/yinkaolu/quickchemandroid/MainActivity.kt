package com.yinkaolu.quickchemandroid

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Text
import com.yinkaolu.quickchemandroid.ui.PeriodicTableDisplay
import com.yinkaolu.quickchemandroid.viewmodel.ElementsViewModel
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: ElementsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.elements.observe(this) { elements ->
            elements?.let {
                Toast.makeText(this, "Elements Loaded", Toast.LENGTH_LONG).show()
            }
        }
        viewModel.periodicTable.observe(this) { periodicTable ->
            periodicTable?.let {
                setContent {
                    PeriodicTableDisplay(periodicTable = it)
                }
            }
        }

        viewModel.loadErrorMessage.observe(this) { message ->
            message?.let {
                setContent {
                    //TODO: Display and handle error is more elegant way
                    Text(text = it)
                }
            }
        }
    }
}
