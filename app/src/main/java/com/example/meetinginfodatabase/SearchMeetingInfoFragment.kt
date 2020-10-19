package com.example.meetinginfodatabase

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.room.Room
import kotlinx.android.synthetic.main.fragment_search_meeting_info.*
import kotlinx.android.synthetic.main.fragment_search_meeting_info.view.*

class SearchMeetingInfoFragment : Fragment() {

    private lateinit var database: MeetingInfoDatabase
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_search_meeting_info, container, false)

        database =
            Room.databaseBuilder(view.context, MeetingInfoDatabase::class.java, "MeetingInfo")
                .build()

        view.btnSearchMeeting.setOnClickListener {
            val list: ArrayList<MeetingInfoEntity> = ArrayList()
            if (etSearchMeetingID.text.toString() == "") {
                Toast.makeText(
                    view.context,
                    "Please enter Meeting ID to search",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Thread {
                    list.addAll(
                        database.meetDao()
                            .search(Integer.parseInt(etSearchMeetingID.text.toString()))
                    )
                    tvDisplaySearchResult.post {
                        if (list.isEmpty())
                            Toast.makeText(view.context, "Empty", Toast.LENGTH_SHORT).show()
                        else {
                            val uList: ArrayList<String> = ArrayList()
                            list.forEach {
                                uList.add(it.meetingID.toString())
                                uList.add(it.meetingOrganizer)
                                uList.add(it.meetingDate)
                                uList.add(it.meetingTime)
                            }
                            tvDisplaySearchResult.text = """Meeting ID: ${uList[0]}
                                                            Meeting Organizer: ${uList[1]}
                                                            Meeting Date: ${uList[2]}
                                                            Meeting Time: ${uList[3]}"""
                        }
                    }
                }.start()
                etSearchMeetingID.setText("")
            }
        }

        return view
    }
}