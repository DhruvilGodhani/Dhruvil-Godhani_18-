package com.example.q2

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("NotificationPrefs", MODE_PRIVATE)

        val switchSound = findViewById<Switch>(R.id.switchSound)
        val switchVibration = findViewById<Switch>(R.id.switchVibration)
        val switchLED = findViewById<Switch>(R.id.switchLED)
        val switchShowBanners = findViewById<Switch>(R.id.switchShowBanners)
        val switchShowContent = findViewById<Switch>(R.id.switchShowContent)
        val switchLockScreen = findViewById<Switch>(R.id.switchLockScreen)
        val btnSave = findViewById<Button>(R.id.btnSave)

        // Load saved preferences
        switchSound.isChecked = sharedPreferences.getBoolean("sound", false)
        switchVibration.isChecked = sharedPreferences.getBoolean("vibration", false)
        switchLED.isChecked = sharedPreferences.getBoolean("led", false)
        switchShowBanners.isChecked = sharedPreferences.getBoolean("banners", false)
        switchShowContent.isChecked = sharedPreferences.getBoolean("content", false)
        switchLockScreen.isChecked = sharedPreferences.getBoolean("lockScreen", false)

        // Save button click listener
        btnSave.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.putBoolean("sound", switchSound.isChecked)
            editor.putBoolean("vibration", switchVibration.isChecked)
            editor.putBoolean("led", switchLED.isChecked)
            editor.putBoolean("banners", switchShowBanners.isChecked)
            editor.putBoolean("content", switchShowContent.isChecked)
            editor.putBoolean("lockScreen", switchLockScreen.isChecked)
            editor.apply()

            // Show confirmation dialog
            showBottomSheetDialog()
        }
    }

    private fun showBottomSheetDialog() {
        val bottomSheetDialog = BottomSheetDialog(this)
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_confirmation)
        bottomSheetDialog.show()
    }
}
