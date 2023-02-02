package com.example.cleanarchitecturewithadapter.data.data_source.dto.CoinDetailDto


import com.example.cleanarchitecturewithadapter.domain.model.CoinDetail
import com.google.gson.annotations.SerializedName

data class CoinDetailDto(
    @SerializedName("additional_notices")
    val additionalNotices: List<Any>,
    @SerializedName("asset_platform_id")
    val assetPlatformId: Any,
    @SerializedName("block_time_in_minutes")
    val blockTimeInMinutes: Double,
    @SerializedName("categories")
    val categories: List<String>,
    @SerializedName("coingecko_rank")
    val coingeckoRank: Double,
    @SerializedName("coingecko_score")
    val coingeckoScore: Double,
    @SerializedName("community_data")
    val communityData: CommunityData,
    @SerializedName("community_score")
    val communityScore: Double,
    @SerializedName("country_origin")
    val countryOrigin: String,
    @SerializedName("description")
    val description: Description,
    @SerializedName("detail_platforms")
    val detailPlatforms: DetailPlatforms,
    @SerializedName("developer_data")
    val developerData: DeveloperData,
    @SerializedName("developer_score")
    val developerScore: Double,
    @SerializedName("genesis_date")
    val genesisDate: String,
    @SerializedName("hashing_algorithm")
    val hashingAlgorithm: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: Image,
    @SerializedName("last_updated")
    val lastUpdated: String,
    @SerializedName("links")
    val links: Links,
    @SerializedName("liquidity_score")
    val liquidityScore: Double,
    @SerializedName("localization")
    val localization: Localization,
    @SerializedName("market_cap_rank")
    val marketCapRank: Double,
    @SerializedName("market_data")
    val marketData: MarketData,
    @SerializedName("name")
    val name: String,
    @SerializedName("platforms")
    val platforms: Platforms,
    @SerializedName("public_Doubleerest_score")
    val publicDoubleerestScore: Double,
    @SerializedName("public_notice")
    val publicNotice: Any,
    @SerializedName("sentiment_votes_down_percentage")
    val sentimentVotesDownPercentage: Double,
    @SerializedName("sentiment_votes_up_percentage")
    val sentimentVotesUpPercentage: Double,
    @SerializedName("status_updates")
    val statusUpdates: List<Any>,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("tickers")
    val tickers: List<Ticker>
) {
    fun toCoinDetail(): CoinDetail {
        return CoinDetail(
            name = name,
            image = image.large,
            marketCap = marketData.marketCap.usd.toDouble(),
            price = marketData.currentPrice.usd,
            pricePercentageChange = marketData.priceChangePercentage24h,
            lowPrice = marketData.low24h.usd,
            highPrice = marketData.high24h.usd,
            description = description.en


        )

    }
}