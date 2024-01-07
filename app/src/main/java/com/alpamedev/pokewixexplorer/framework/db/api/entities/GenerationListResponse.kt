package com.alpamedev.pokewixexplorer.framework.db.api.entities

import com.alpamedev.domain.generation.Generation

data class GenerationListResponse(
    val count: Long,
    val next: String? = null,
    val previous: String? = null,
    val results: List<BaseResponse>
){
    fun toGenerations() = results.map { Generation(it.name, it.url) }
}
