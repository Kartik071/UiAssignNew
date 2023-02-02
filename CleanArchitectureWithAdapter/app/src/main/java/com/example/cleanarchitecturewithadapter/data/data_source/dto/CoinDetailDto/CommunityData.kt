package com.example.cleanarchitecturewithadapter.data.data_source.dto.CoinDetailDto


import com.google.gson.annotations.SerializedName

data class CommunityData(
    @SerializedName("facebook_likes")
    val facebookLikes: Any,
    @SerializedName("reddit_accounts_active_48h")
    val redditAccountsActive48h: Double,
    @SerializedName("reddit_average_comments_48h")
    val redditAverageComments48h: Double,
    @SerializedName("reddit_average_posts_48h")
    val redditAveragePosts48h: Double,
    @SerializedName("reddit_subscribers")
    val redditSubscribers: Double,
    @SerializedName("telegram_channel_user_count")
    val telegramChannelUserCount: Any,
    @SerializedName("twitter_followers")
    val twitterFollowers: Double
)