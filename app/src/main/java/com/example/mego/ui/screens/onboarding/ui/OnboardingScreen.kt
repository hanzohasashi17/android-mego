package com.example.mego.ui.screens.onboarding.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mego.R
import com.example.mego.ui.composables.CommonSubmitButton
import com.example.mego.ui.composables.onboard.PageIndicator
import com.example.mego.ui.composables.onboard.SkipButton
import com.example.mego.ui.theme.Dimension
import kotlinx.coroutines.launch

@Composable
fun OnboardingScreen() {
    val pagerState = rememberPagerState(pageCount = { 3 }, initialPage = 0)
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Dimension.COMMON_WIDTH_WRAP.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PageIndicator(
                pagerState = pagerState
            )
            SkipButton(
                onSkipClick = {
                    coroutineScope.launch {
                        pagerState.scrollToPage(2)
                    }
                },
                enabled = pagerState.currentPage < 2
            )
        }
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .weight(2f),
            userScrollEnabled = false
        ) { page ->
            when (page) {
                0 -> OnboardItem(
                    image = R.drawable.onboard1,
                    title = stringResource(R.string.onboarding_title_1),
                    description = stringResource(R.string.onboarding_description_1)
                )

                1 -> OnboardItem(
                    image = R.drawable.onboard2,
                    title = stringResource(R.string.onboarding_title_2),
                    description = stringResource(R.string.onboarding_description_2)
                )

                2 -> OnboardItem(
                    image = R.drawable.onboard3,
                    title = stringResource(R.string.onboarding_title_3),
                    description = stringResource(R.string.onboarding_description_3)
                )
            }
        }
        Row(
            modifier = Modifier
                .padding(bottom = 28.dp)
                .fillMaxWidth()
        ) {
            if (pagerState.currentPage < 2) {
                CommonSubmitButton(
                    text = stringResource(id = R.string.onboarding_continue_button),
                ) {
                    coroutineScope.launch {
                        pagerState.scrollToPage(pagerState.currentPage + 1)
                    }
                }
            } else {
                CommonSubmitButton(text = stringResource(R.string.onboarding_submit_button)) {
                    /*TODO*/
                }
            }
        }
    }
}