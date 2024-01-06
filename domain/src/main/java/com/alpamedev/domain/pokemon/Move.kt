package com.alpamedev.domain.pokemon

import com.alpamedev.domain.Base

data class Move(
    override val name: String,
    override val url: String
): Base()
