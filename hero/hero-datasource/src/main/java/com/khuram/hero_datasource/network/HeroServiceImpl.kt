package com.khuram.hero_datasource.network

import com.khuram.hero_domain.Hero
import io.ktor.client.request.*


class HeroServiceImpl(
    private val httpClient: io.ktor.client.HttpClient,
): HeroService {

    override suspend fun getHeroStats(): List<Hero> {
        return httpClient.get<List<HeroDto>> {
            url(EndPoints.HERO_STATS)
        }.map { it.toHero() }
    }
}