package com.bene_gesserit.fragtest.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.bene_gesserit.fragtest.presentation.components.MainButton

@Composable
fun StartScreen(text: String, onClick: () -> Unit) {
    Column {
        MainButton(text, onClick = onClick)
    }
}