package com.group4_comp304_assignment4
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
@Dao
interface NurseDao {
    @Insert
    suspend fun insertNurse(nurse: Nurse)

    @Query("SELECT * FROM nurse_table")
    fun getAllNurses(): LiveData<List<Nurse>>

    @Query("SELECT * FROM nurse_table WHERE nurseId = :nurseId")
    fun getNurseById(nurseId: Long): LiveData<Nurse?>

    @Query("SELECT * FROM nurse_table WHERE nurseId = :nurseId and password = :password")
    fun getNurseByIdAndPassword(nurseId: Long, password: String): LiveData<Nurse?>

    @Update
    suspend fun updateNurse(nurse: Nurse)

    @Delete
    suspend fun deleteNurse(nurse: Nurse)

    @Query("DELETE FROM nurse_table")
    suspend fun deleteAllNurse()
}
