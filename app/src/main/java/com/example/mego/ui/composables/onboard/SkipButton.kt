package com.example.mego.ui.composables.onboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.mego.R

@Composable
fun SkipButton(
    onSkipClick: () -> Unit,
    enabled: Boolean
) {
    Row(
        modifier = Modifier.wrapContentWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            enabled = enabled,
            onClick = onSkipClick,
            colors = ButtonColors(
                containerColor = Color.Transparent,
                contentColor = MaterialTheme.colorScheme.primary,
                disabledContainerColor = Color.Transparent,
                disabledContentColor = Color.Transparent
            )
        ) {
            Text(
                text = stringResource(R.string.onboarding_skip_button)
            )
        }
    }
}