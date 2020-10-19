package com.example.meetinginfodatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MeetingInfo")
data class MeetingInfoEntity(
    @PrimaryKey @ColumnInfo(name = "Meeting ID") val meetingID: Int,
    @ColumnInfo(name = "Meeting Organizer") val meetingOrganizer: String,
    @ColumnInfo(name = "Meeting Date") val meetingDate: String,
    @ColumnInfo(name = "Meeting Time") val meetingTime: String
)