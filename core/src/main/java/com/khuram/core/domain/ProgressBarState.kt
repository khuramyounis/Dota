package com.khuram.core.domain

sealed class ProgressBarState {

    object Loading: ProgressBarState()

    object Idle: ProgressBarState()
}