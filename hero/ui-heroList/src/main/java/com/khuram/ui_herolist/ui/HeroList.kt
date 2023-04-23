package com.khuram.ui_herolist.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import coil.ImageLoader
import com.khuram.components.DefaultScreenUI
import com.khuram.core.domain.UIComponentState
import com.khuram.ui_herolist.components.HeroListFilter
import com.khuram.ui_herolist.components.HeroListItem
import com.khuram.ui_herolist.components.HeroListToolbar


@OptIn(ExperimentalComposeUiApi::class, ExperimentalAnimationApi::class)
@Composable
fun HeroList(
    state: HeroListState,
    events: (HeroListEvents) -> Unit,
    imageLoader: ImageLoader,
    navigateToDetailScreen: (Int) -> Unit
) {
    DefaultScreenUI(
        queue = state.errorQueue,
        onRemoveHeadFromQueue = {
            events(HeroListEvents.OnRemoveHeadFromQueue)
        },
        progressBarState = state.progressBarState
    ) {
        Column {
            HeroListToolbar(
                heroName = state.heroName,
                onHeroNameChanged = { heroName ->
                    events(HeroListEvents.UpdateHeroName(heroName))
                },
                onExecuteSearch = {
                    events(HeroListEvents.FilterHeros)
                },
                onShowFilterDialog = {
                    events(HeroListEvents.UpdateFilterDialogState(UIComponentState.Show))
                }
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ){
                items(state.filteredHeros){ hero ->
                    HeroListItem(
                        hero = hero,
                        onSelectHero = { heroId ->
                            navigateToDetailScreen(heroId)
                        },
                        imageLoader = imageLoader,
                    )
                }
            }
        }
        if(state.filterDialogState is UIComponentState.Show) {
            HeroListFilter(
                heroFilter = state.heroFilter,
                onUpdateHeroFilter = { heroFilter ->
                    events(HeroListEvents.UpdateHeroFilter(heroFilter))
                },
                attributeFilter = state.primaryAttribute,
                onUpdateAttributeFilter = { heroAttribute ->
                    events(HeroListEvents.UpdateAttributeFilter(heroAttribute))
                },
                onCloseDialog = {
                    events(HeroListEvents.UpdateFilterDialogState(UIComponentState.Hide))
                }
            )
        }
    }
}