package com.bene_gesserit.fragtest.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bene_gesserit.fragtest.ui.theme.Typography

@Composable
fun MainButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        TextButton(
            modifier = Modifier
                .wrapContentSize(),
            shape = RoundedCornerShape(corner = CornerSize(4.dp)),
            colors = ButtonDefaults.filledTonalButtonColors(containerColor = Color.Gray),
            onClick = onClick,
        ) {
            Text(text, style = Typography.bodyLarge)
        }
    }
}