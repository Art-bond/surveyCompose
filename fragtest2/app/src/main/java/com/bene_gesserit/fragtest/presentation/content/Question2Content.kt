package com.bene_gesserit.fragtest.presentation.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bene_gesserit.fragtest.DropListContent
import com.bene_gesserit.fragtest.presentation.components.Dropdown
import com.bene_gesserit.fragtest.presentation.components.MainButton
import com.bene_gesserit.fragtest.ui.theme.Typography

@Composable
fun Question2Content(
    data: List<DropListContent>,
    modifier: Modifier = Modifier,
    onClick: (next: Int, map: Map<String, String>) -> Unit = { _, _ -> },
) {
    val map: MutableMap<String, String> = mutableMapOf()
    Column(modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            data.forEach { item ->
                map[item.title] = item.dropList.first()
                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                ) {
                    Text(item.title, style = Typography.titleLarge)
                    Dropdown(item.dropList) { select ->
                        map[item.title] = select
                    }
                }
            }
        }
        MainButton("Далее") {
            onClick(4, map)
        }
    }
}