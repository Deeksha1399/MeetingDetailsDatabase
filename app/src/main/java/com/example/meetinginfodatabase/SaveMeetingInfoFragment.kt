package com.example.meetinginfodatabase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_save_meeting_info.*

class SaveMeetingInfoFragment : Fragment() {

    private lateinit var database: MeetingInfoDatabase

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_save_meeting_info, container, false)

        database =
            Room.databaseBuilder(view.context, MeetingInfoDatabase::class.java, "MeetingInfo")
                .build()

        view.btnSaveMeeting.setOnClickListener {
            when {
                etMeetingID.text.toString() == "" ->
                    Toast.makeText(view.context, "Please enter Meeting ID", Toast.LENGTH_SHORT)
                        .show()

                etMeetingOrganizer.text.toString() == "" ->
                    Toast.makeText(
                        view.context,
                        "Please enter Meeting Organizer",
                        Toast.LENGTH_SHORT
                    ).show()

                etMeetingDate.text.toString() == "" ->
                    Toast.makeText(view.context, "Please enter Meeting date", Toast.LENGTH_SHORT)
                        .show()

                etMeetingTime.text.toString() == "" ->
                    Toast.makeText(view.context, "Please enter Meeting time", Toast.LENGTH_SHORT)
                        .show()

                else -> {
                    Thread {
                        database.meetDao().insert(
                            MeetingInfoEntity(
                                Integer.parseInt(etMeetingID.text.toString()),
                                etMeetingOrganizer.text.toString(),
                                etMeetingDate.text.toString(),
                                etMeetingTime.text.toString()
                            )
                        )
                    }.start()
                    Toast.makeText(view.context, "Successfully saved!", Toast.LENGTH_SHORT).show()
                    etMeetingID.setText("")
                    etMeetingOrganizer.setText("")
                    etMeetingDate.setText("")
                    etMeetingTime.setText("")
                }
            }
        }

        return view
    }
}