package com.example.retrofitexample

data class QuoteList(
        val count: Long,
        val totalCount: Long,
        val page: Long,
        val totalPages: Long,
        val lastItemIndex: Long,
        val results: List<Result>
)