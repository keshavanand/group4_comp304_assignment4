package com.group4_comp304_assignment4
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
@Dao
interface TestDao {
    @Insert
    suspend fun insertTest(test: Test)

    @Query("SELECT * FROM test_table")
    fun getAllTests(): LiveData<List<Test>>

    @Query("SELECT * FROM test_table WHERE patientId = :patientId")
    suspend fun getTestsForPatient(patientId: Long): LiveData<List<Test>>

    @Update
    suspend fun updateTest(test: Test)

    @Delete
    suspend fun deleteTest(test: Test)
}
