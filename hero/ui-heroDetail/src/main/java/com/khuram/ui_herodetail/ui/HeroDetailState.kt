package com.khuram.ui_herodetail.ui

import com.khuram.core.domain.ProgressBarState
import com.khuram.core.domain.Queue
import com.khuram.core.domain.UIComponent
import com.khuram.hero_domain.Hero

data class HeroDetailState(
    val progressBarState: ProgressBarState = ProgressBarState.Idle,
    val hero: Hero? = null,
    val errorQueue: Queue<UIComponent> = Queue(mutableListOf())
)