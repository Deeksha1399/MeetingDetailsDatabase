package com.example.meetinginfodatabase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [(MeetingInfoEntity::class)], version = 1, exportSchema = false)
abstract class MeetingInfoDatabase : RoomDatabase() {
    abstract fun meetDao(): MeetingInfoDAO
}