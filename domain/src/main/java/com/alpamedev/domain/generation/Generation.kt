package com.alpamedev.domain.generation

import com.alpamedev.domain.Base

data class Generation(
    override val name: String?,
    override val url: String?
): Base()