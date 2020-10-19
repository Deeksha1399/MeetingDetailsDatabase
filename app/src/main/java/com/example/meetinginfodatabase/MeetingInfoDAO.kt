package com.example.meetinginfodatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface MeetingInfoDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(meetingInfoEntity: MeetingInfoEntity)

    @Query("SELECT * FROM MeetingInfo WHERE `Meeting ID` LIKE :etMeetingID ")
    fun search(etMeetingID: Int): List<MeetingInfoEntity>

    @Query("UPDATE MeetingInfo SET `Meeting Time` = :editMeetingTime WHERE `Meeting ID` LIKE :editMeetingID")
    fun updateTime(editMeetingTime: String, editMeetingID: Int)

}