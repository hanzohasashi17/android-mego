package com.example.mego.ui.screens.onboarding.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mego.R
import com.example.mego.ui.composables.CommonSubmitButton
import com.example.mego.ui.composables.onboard.SkipButton
import com.example.mego.ui.theme.Dimension
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen() {

    val pagerState = rememberPagerState(pageCount = { 3 }, initialPage = 0)
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Dimension.COMMON_WIDTH_WRAP.dp)
            .statusBarsPadding(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                Modifier
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .padding(bottom = 8.dp),
            ) {
                repeat(pagerState.pageCount) { iteration ->
                    val color =
                        if (pagerState.currentPage == iteration) MaterialTheme.colorScheme.primary else Color.LightGray
                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                            .clip(CircleShape)
                            .background(color)
                            .size(16.dp)
                    )
                }
            }
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