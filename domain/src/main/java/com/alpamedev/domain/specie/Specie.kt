package com.alpamedev.domain.specie

import com.alpamedev.domain.Base

data class Specie(
    override val name: String,
    override val url: String
): Base()
