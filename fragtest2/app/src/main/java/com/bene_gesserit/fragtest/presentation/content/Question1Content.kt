package com.bene_gesserit.fragtest.presentation.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bene_gesserit.fragtest.SurveyUiState
import com.bene_gesserit.fragtest.presentation.components.ComboButtons
import com.bene_gesserit.fragtest.ui.theme.Typography

@Composable
fun Question1Content(
    titleText: String,
    checkBoxText: String,
    description: String,
    modifier: Modifier = Modifier,
    onClick: (next: Int, checked: Boolean) -> Unit = { _, _ -> },
) {
    var checked by remember { mutableStateOf(false) }
    Column(modifier.fillMaxSize()) {
        Column(
            modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(titleText, style = Typography.titleLarge)
            Row(
                modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = checked,
                    onCheckedChange = { checked = it },
                    colors = CheckboxDefaults.colors(
                        uncheckedColor = Color.Gray,
                        checkedColor = Color.Gray
                    ),
                )
                Text(checkBoxText, style = Typography.bodyMedium, color = Color.Gray)
            }
            Text(
                description,
                style = Typography.bodyMedium,
                modifier = modifier.padding(horizontal = 16.dp),
                textAlign = TextAlign.Center
            )
        }
        ComboButtons(
            "Сейчас", "Раньше",
            modifier.padding(bottom = 16.dp),
            onLeftClick = { onClick.invoke(2, checked) },
            onRightClick = { onClick.invoke(3, checked) }
        )
    }
}

@Preview
@Composable
fun Question1Preview() {
    val state = SurveyUiState.StartState("Сообщить о симптомах")
    Question1Content(
        "Когда возникают симптомы",
        "Меня беспокоит только отдышка",
        "description",
        modifier = Modifier.background(color = Color.DarkGray)
    )
}