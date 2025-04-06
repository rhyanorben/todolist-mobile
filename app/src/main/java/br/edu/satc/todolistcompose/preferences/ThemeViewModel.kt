package br.edu.satc.todolistcompose.preferences

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import br.edu.satc.todolistcompose.ui.theme.ThemeMode

class ThemeViewModel (private val prefs: ThemePreference) : ViewModel() {

    private val _themeMode = mutableStateOf(prefs.getThemeMode())
    val themeMode: State<ThemeMode> = _themeMode

    fun setThemeMode(mode: ThemeMode) {
        _themeMode.value = mode
        prefs.saveThemeMode(mode)
    }
}