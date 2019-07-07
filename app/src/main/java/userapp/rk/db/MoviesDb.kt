package userapp.sapient.daggertestapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import userapp.rk.ui.model.MoviesResponse

/**
 * Database to store movies
 */
@Database(entities = [MoviesResponse::class], version = 1, exportSchema = false)
abstract class MoviesDb : RoomDatabase() {
    abstract fun moviesDao(): MoviesDao
}