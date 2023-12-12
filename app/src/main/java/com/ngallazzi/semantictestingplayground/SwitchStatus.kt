package com.ngallazzi.semantictestingplayground

import androidx.annotation.DrawableRes

enum class SwitchStatus(@DrawableRes val imageRes: Int) {
    ON(R.drawable.pacman_lamp_on), OFF(R.drawable.pacman_lamp_off)
}