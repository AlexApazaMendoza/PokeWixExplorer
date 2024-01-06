package com.alpamedev.domain.pokemon

import com.alpamedev.domain.Base

data class Stat (
    override val name: String,
    override val url: String,
    val baseStat: Long
): Base()
