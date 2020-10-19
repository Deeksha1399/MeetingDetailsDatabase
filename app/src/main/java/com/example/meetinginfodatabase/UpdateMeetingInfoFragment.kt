package com.example.meetinginfodatabase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_update_meeting_info.*

class UpdateMeetingInfoFragment : Fragment() {

    private lateinit var database : MeetingInfoDatabase

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_update_meeting_info, container, false)

        database=Room.databaseBuilder(view.context, MeetingInfoDatabase::class.java,"MeetingInfo").build()

        view.btnUpdateMeeting.setOnClickListener {
            when {
                etUpdateMeetingID.text.toString() == "" ->
                    Toast.makeText(view.context, "Please enter Meeting ID", Toast.LENGTH_SHORT).show()

                etUpdateMeetingTime.text.toString() == "" ->
                    Toast.makeText(view.context, "Please enter Meeting time", Toast.LENGTH_SHORT).show()

                else -> {
                    Thread {
                        database.meetDao().updateTime(etUpdateMeetingTime.text.toString(),
                                Integer.parseInt(etUpdateMeetingID.text.toString())
                        )
                    }.start()
                    Toast.makeText(view.context, "Successfully saved!", Toast.LENGTH_SHORT).show()
                    etUpdateMeetingID.setText("")
                    etUpdateMeetingTime.setText("")
                }
            }
        }
        return view
    }
}