package com.khuram.hero_interactors

import com.khuram.core.domain.DataState
import com.khuram.core.domain.ProgressBarState
import com.khuram.core.domain.UIComponent
import com.khuram.hero_datasource.cache.HeroCache
import com.khuram.hero_domain.Hero
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class GetHeroFromCache(
    private val cache: HeroCache
) {
    fun execute(
        id: Int
    ): Flow<DataState<Hero>> = flow {
        try {
            emit(DataState.Loading(progressBarState = ProgressBarState.Loading))

            val cachedHero = cache.getHero(id) ?: throw Exception("That hero does not exist in the cache")

            emit(DataState.Data(cachedHero))

        } catch (e: Exception) {
            e.printStackTrace()
            emit(
                DataState.Response<Hero>(
                    uiComponent = UIComponent.Dialog(
                        title = "Error",
                        description = e.message ?: "Unknown Error"
                    )
                )
            )
        }

        finally {
            emit(DataState.Loading(progressBarState = ProgressBarState.Idle))
        }
    }
}