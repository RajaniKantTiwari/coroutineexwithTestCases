package userapp.rk.ui.model

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import userapp.sapient.daggertestapp.db.MoviesDb
import java.io.IOException

@RunWith(JUnit4::class)
class MovieDatabaseTest {
private lateinit var movieDb:MoviesDb
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    @Before
    fun init(){
        movieDb= Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),MoviesDb::class.java
        ).allowMainThreadQueries().build()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        movieDb.close()
    }

    @Test
    fun insertAndGetUser() {
        val moviesResponse = MoviesResponse()
        moviesResponse.id = 100
        moviesResponse.title = "test"
        movieDb.moviesDao().saveFavourite(moviesResponse)
        moviesResponse.title?.let {
            val moviesListData = movieDb.moviesDao()
                .searchMoviesByTitle(it)
            moviesListData.observeForever {
                Assert.assertEquals(it.get(0).id, moviesResponse.id)
                Assert.assertEquals(it.get(0).title, moviesResponse.title)
            }
        }
    }
}