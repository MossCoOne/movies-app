package com.mossco.za.moviesapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MoviesDatabaseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg nowPlayingMovies: NowPlayingMovie)

    @Query("SELECT * FROM NowPlayingMovie")
    fun getNowPlayingMovies(): LiveData<List<NowPlayingMovie>>
}