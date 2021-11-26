package com.myroutefomeque.mirutafomeque.preference

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.myroutefomeque.mirutafomeque.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}