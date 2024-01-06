package com.alpamedev.domain.pokemon

import com.alpamedev.domain.Base

data class Ability(
    val slot: Long,
    val isHidden: Boolean,
    override val name: String,
    override val url: String
): Base()
