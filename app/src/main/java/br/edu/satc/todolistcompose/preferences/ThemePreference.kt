package br.edu.satc.todolistcompose.preferences

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import androidx.core.content.edit
import br.edu.satc.todolistcompose.ui.theme.ThemeMode

class ThemePreference(context: Context) {

    private val prefs = context.getSharedPreferences("theme_prefs", Context.MODE_PRIVATE)

    fun saveThemeMode(mode: ThemeMode) {
        prefs.edit {
            putString("theme_mode", mode.name)
        }
    }

    fun getThemeMode(): ThemeMode {
        return ThemeMode.valueOf(prefs.getString("theme_mode", ThemeMode.SYSTEM.name)!!)
    }

    fun isSystemInDarkTheme(): Boolean {
        val uiMode = Resources.getSystem().configuration.uiMode
        return (uiMode and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES
    }

}