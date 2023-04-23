package com.khuram.ui_herolist.di

import com.khuram.core.util.Logger
import com.khuram.hero_interactors.FilterHeros
import com.khuram.hero_interactors.GetHeros
import com.khuram.hero_interactors.HeroInteractors
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object HeroListModule {

    @Provides
    @Singleton
    fun providesGetHeros(
        interactors: HeroInteractors
    ): GetHeros {
        return interactors.getHeros
    }

    @Provides
    @Singleton
    fun providesFilterHeros(
        interactors: HeroInteractors
    ): FilterHeros {
        return interactors.filterHeros
    }

    @Provides
    @Singleton
    @Named("heroListLogger")
    fun provideLogger(): Logger {
        return Logger(
            tag = "HeroList",
            isDebug = true
        )
    }
}