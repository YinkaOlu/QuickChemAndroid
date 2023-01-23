package com.yinkaolu.quickchemandroid.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yinkaolu.quickchemandroid.data.model.Element
import com.yinkaolu.quickchemandroid.data.model.PeriodicTable

/**
 * TODO: Update Design of periodic table
 */
@Composable
fun PeriodicTableDisplay(
    periodicTable: PeriodicTable
) {

    Column {
        ElementRow(row = periodicTable.actinide, title = "Actinides")
        ElementRow(row = periodicTable.mElements, title = "Metal Elements")
        ElementRow(row = periodicTable.alkaliMetal, title = "Alkali Metals")
        ElementRow(row = periodicTable.lanthanide, title = "Lanthanoids")
        ElementRow(row = periodicTable.diatomicNonmetal, title = "Diatomic Non Metals")
        ElementRow(row = periodicTable.alkalineEarthMetals, title = "Alkaline Earth Metals")
        ElementRow(row = periodicTable.metalloid, title = "Metalloids")
        ElementRow(row = periodicTable.nobleGas, title = "Noble Gases")
        ElementRow(row = periodicTable.polyatomicNonmetal, title = "Polyatomic Non Metal")
        ElementRow(row = periodicTable.postTransitionMetal, title = "Post Transition Metal")
        ElementRow(row = periodicTable.transitionMetal, title = "Transition Metal")
    }
}

@Composable
fun ElementRow(
    title: String,
    row: ArrayList<Element>
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ){
        Text(text = title, modifier = Modifier.fillMaxWidth())
        LazyColumn {
            items(row) { element ->
                ElementCell(element = element)
            }
        }
    }

}

@Composable
fun ElementCell(
    element: Element,
    shouldExpandOnDefault: Boolean = false
) {
    var isExpanded by remember {
        mutableStateOf(shouldExpandOnDefault)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(28.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .clickable(onClick = { isExpanded = !isExpanded})
                .fillMaxWidth()
        ) {
            Row {
                Text(text = element.symbol)
            }
            Row {
                Text(text = element.atomicNumber)
            }
            if (isExpanded) {
                Row {
                    Text(text = element.summary)
                }
            }
        }
    }
}

@Preview
@Composable
fun PeriodicTablePreview() {
    PeriodicTableDisplay(periodicTable = PeriodicTable(
        mElements = arrayListOf(
            Element(
                symbol = "Z",
                atomicNumber = "30",
                summary = "A metal element"
            )
        )
    )
    )
}

