package com.bene_gesserit.fragtest.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bene_gesserit.fragtest.ui.theme.Typography

@Composable
fun ComboButtons(
    leftButtonText: String,
    rightButtonText: String,
    modifier: Modifier = Modifier,
    onLeftClick: () -> Unit = {},
    onRightClick: () -> Unit = {},
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Absolute.SpaceEvenly
    ) {
        TextButton(
            modifier = Modifier
                .wrapContentSize(),
            shape = RoundedCornerShape(corner = CornerSize(4.dp)),
            colors = ButtonDefaults.filledTonalButtonColors(containerColor = Color.Gray),
            onClick = onLeftClick,
        ) {
            Text(leftButtonText, style = Typography.bodyLarge)
        }
        TextButton(
            modifier = Modifier
                .wrapContentSize(),
            shape = RoundedCornerShape(corner = CornerSize(4.dp)),
            colors = ButtonDefaults.filledTonalButtonColors(containerColor = Color.Gray),
            onClick = onRightClick,
        ) {
            Text(rightButtonText, style = Typography.bodyLarge)
        }
    }
}