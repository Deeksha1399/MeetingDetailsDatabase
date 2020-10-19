package com.example.meetinginfodatabase

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnSaveMeetingInfo: Button
    private lateinit var btnSearchMeetingInfo: Button
    private lateinit var btnUpdateMeetingInfo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val saveMeetingInfoFragment = SaveMeetingInfoFragment()
        val updateMeetingInfoFragment = UpdateMeetingInfoFragment()
        val searchMeetingInfoFragment = SearchMeetingInfoFragment()


        btnSaveMeetingInfo = findViewById(R.id.btnSaveMeeting)
        btnSearchMeetingInfo = findViewById(R.id.btnSearchMeeting)
        btnUpdateMeetingInfo = findViewById(R.id.btnUpdateMeeting)

        btnSaveMeetingInfo.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.flFragment, saveMeetingInfoFragment)
                .commit()
        }

        btnSearchMeetingInfo.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.flFragment, searchMeetingInfoFragment)
                .commit()
        }

        btnUpdateMeetingInfo.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.flFragment, updateMeetingInfoFragment)
                .commit()
        }
    }
}