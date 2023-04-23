package com.khuram.ui_herolist.ui

import com.khuram.core.domain.UIComponentState
import com.khuram.hero_domain.HeroAttribute
import com.khuram.hero_domain.HeroFilter


sealed class HeroListEvents {

    object GetHeros: HeroListEvents()

    object FilterHeros: HeroListEvents()

    data class UpdateHeroName(
        val heroName: String
    ): HeroListEvents()

    data class UpdateHeroFilter(
        val heroFilter: HeroFilter
    ): HeroListEvents()

    data class UpdateFilterDialogState(
        val uiComponentState: UIComponentState
    ): HeroListEvents()

    data class UpdateAttributeFilter(
        val attribute: HeroAttribute
    ): HeroListEvents()

    object OnRemoveHeadFromQueue: HeroListEvents()
}