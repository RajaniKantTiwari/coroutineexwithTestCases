package userapp.sapient.daggertestapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import userapp.rk.ui.model.MoviesResponse

/**
 * Database to save favourite movies
 */
@Dao
interface MoviesDao {
    /**
     * get all Favourite movies from list
     */
    @Query("SELECT * FROM MoviesResponse")
    fun getFavouriteMovies(): LiveData<List<MoviesResponse>>
    /**
     * Insert favourite movie into Database
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveFavourite(moviesResponse: MoviesResponse)
    /**
     * delete movies from database if unselected
     */
    @Delete
    fun delete(moviesResponse: MoviesResponse)
    /**
     * get All Favourite movies which match search condition
     */
    @Query("SELECT * FROM MoviesResponse where title LIKE '%' || :title || '%'")
    fun searchMoviesByTitle(title:String): LiveData<List<MoviesResponse>>
}