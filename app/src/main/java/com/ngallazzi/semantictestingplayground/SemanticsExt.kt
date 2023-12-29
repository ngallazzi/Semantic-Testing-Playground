package com.ngallazzi.semantictestingplayground

import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.semantics.SemanticsPropertyReceiver

val DrawableIdSemanticsProperty = SemanticsPropertyKey<Int>("DrawableResId")

var SemanticsPropertyReceiver.drawableId by DrawableIdSemanticsProperty