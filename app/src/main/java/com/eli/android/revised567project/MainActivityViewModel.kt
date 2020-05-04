package com.eli.android.revised567project

import androidx.lifecycle.ViewModel

private const val MENU_START_BUTTON = 97
private const val MENU_HELP_BUTTON = 98
private const val MENU_QUIT_BUTTON = 99

class MainActivityViewModel : ViewModel() {
    var menuButton: Int? = null
}