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
    fun insertTest(test: Test)

    @Query("SELECT * FROM test_table")
    fun getAllTests(): LiveData<List<Test>>

    @Query("SELECT * FROM test_table WHERE patientId = :patientId")
    fun getTestsForPatient(patientId: Long): LiveData<List<Test>>

    @Update
    fun updateTest(test: Test)

    @Delete
    fun deleteTest(test: Test)

    @Query("DELETE FROM test_table")
    fun deleteAllTest()
}
