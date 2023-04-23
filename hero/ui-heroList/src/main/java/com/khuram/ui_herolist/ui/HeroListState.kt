package com.khuram.ui_herolist.ui

import com.khuram.core.domain.ProgressBarState
import com.khuram.core.domain.Queue
import com.khuram.core.domain.UIComponent
import com.khuram.core.domain.UIComponentState
import com.khuram.hero_domain.Hero
import com.khuram.hero_domain.HeroAttribute
import com.khuram.hero_domain.HeroFilter


data class HeroListState(
    val progressBarState: ProgressBarState = ProgressBarState.Idle,
    val heros: List<Hero> = listOf(),
    val filteredHeros: List<Hero> = listOf(),
    val heroName: String = "",
    val heroFilter: HeroFilter = HeroFilter.Hero(),
    val primaryAttribute: HeroAttribute = HeroAttribute.Unknown,
    val filterDialogState: UIComponentState = UIComponentState.Hide,
    val errorQueue: Queue<UIComponent> = Queue(mutableListOf())
)
