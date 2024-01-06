package com.alpamedev.domain.pokemon

import com.alpamedev.domain.Base

data class Type(
    val slot: Long,
    override val name: String,
    override val url: String
): Base()