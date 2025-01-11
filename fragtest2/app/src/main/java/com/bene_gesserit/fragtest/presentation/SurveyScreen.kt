package com.bene_gesserit.fragtest.presentation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.bene_gesserit.fragtest.DataViewModel
import com.bene_gesserit.fragtest.SurveyUiState
import com.bene_gesserit.fragtest.presentation.content.Question1Content
import com.bene_gesserit.fragtest.presentation.content.Question2Content
import com.bene_gesserit.fragtest.presentation.content.Question4Content

@Composable
fun SurveyScreen(viewModel: DataViewModel = DataViewModel()) {

    BackHandler {
        viewModel.previous()
    }

    SurveyInnerScreen(viewModel.uiState.value) { next, data ->
        viewModel.next(next, data)
    }


}

@Composable
private fun SurveyInnerScreen(
    uiState: SurveyUiState,
    onClick: (next: Int, data: Map<String, String>) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.DarkGray),
        contentAlignment = Alignment.Center
    ) {
        when (uiState) {
            is SurveyUiState.StartState -> StartScreen(uiState.buttonText) {
                onClick.invoke(1, mapOf())
            }

            is SurveyUiState.Question1 -> Question1Content(
                titleText = uiState.titleText,
                checkBoxText = uiState.checkBox,
                description = uiState.description
            ) { id, checked ->
                onClick.invoke(id, mapOf(uiState.checkBox to checked.toString()))
            }

            is SurveyUiState.Question2 -> Question2Content(uiState.listCheckBox) { id, map ->
                onClick.invoke(id, map )
            }

            is SurveyUiState.Question4 -> Question4Content()
        }
    }
}


@Preview
@Composable
fun SurveyScreenPreview() {
    val state = SurveyUiState.StartState("Сообщить о симптомах")
    SurveyInnerScreen(state) { _, _ -> }
}

