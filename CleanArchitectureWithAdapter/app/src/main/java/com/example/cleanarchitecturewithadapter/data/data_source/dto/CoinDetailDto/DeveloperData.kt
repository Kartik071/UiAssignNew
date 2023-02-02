package com.example.cleanarchitecturewithadapter.data.data_source.dto.CoinDetailDto


import com.google.gson.annotations.SerializedName

data class DeveloperData(
    @SerializedName("closed_issues")
    val closedIssues: Double,
    @SerializedName("code_additions_deletions_4_weeks")
    val codeAdditionsDeletions4Weeks: CodeAdditionsDeletions4Weeks,
    @SerializedName("commit_count_4_weeks")
    val commitCount4Weeks: Double,
    @SerializedName("forks")
    val forks: Double,
    @SerializedName("last_4_weeks_commit_activity_series")
    val last4WeeksCommitActivitySeries: List<Double>,
    @SerializedName("pull_request_contributors")
    val pullRequestContributors: Double,
    @SerializedName("pull_requests_merged")
    val pullRequestsMerged: Double,
    @SerializedName("stars")
    val stars: Double,
    @SerializedName("subscribers")
    val subscribers: Double,
    @SerializedName("total_issues")
    val totalIssues: Double
)