package com.example.movieapp.data.repositoryImpl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.movieapp.data.database.MovieDao
import com.example.movieapp.data.mapper.DbMapper
import com.example.movieapp.domain.dataBaseRepository.DatabaseRepository
import com.example.movieapp.domain.enteties.Movie
import javax.inject.Inject

class DatabaseRepositoryImpl @Inject constructor(
    private val movieDao: MovieDao,
    private val mapper: DbMapper
) : DatabaseRepository {

//    private var firebaseAuth: FirebaseAuth? = null
//    private val firebaseDatabase = FirebaseDatabase.getInstance()
//    private val referenceUsers = firebaseDatabase.getReference("Users")
//
//    private val list = getListFavouriteMovie()

    override fun getListFavouriteMovie(): LiveData<List<Movie>> {
//        firebaseAuth = FirebaseAuth.getInstance()
//
//        firebaseAuth?.uid?.let {
//            CoroutineScope(Dispatchers.IO).launch {
//                movieDao.deleteMoviesFromDb()
//            }
//
//            referenceUsers.child(it).child("listFavouriteMovies").addValueEventListener(object : ValueEventListener {
//                override fun onDataChange(snapshot: DataSnapshot) {
//                    for (data in snapshot.children) {
//                        CoroutineScope(Dispatchers.IO).launch {
//                            movieDao.addMovieToDb(mapper.mapMovieToDbMovie(data.getValue(Movie::class.java)!!))
//                        }
//                    }
//                }
//
//                override fun onCancelled(error: DatabaseError) {
//                }
//
//            })
//        }
        return MediatorLiveData<List<Movie>>().apply {
            addSource(movieDao.getListMovieFromDb()) {
                value = mapper.mapListDbMovieToListMovie(it)
            }
        }
    }


    override suspend fun getMovie(movieId: Int): Movie {
        movieDao.getMovieFromDb(movieId)?.let {
            mapper.mapDbMovieToMovie(it)
        }
        throw RuntimeException("Exception in mapper Movie == null")
    }

    override suspend fun deleteMovieFromDb(movieId: Int) {
        movieDao.deleteMovieFromDb(movieId)

//        firebaseAuth = FirebaseAuth.getInstance()
//        firebaseAuth?.uid?.let {
//            referenceUsers.child(it)
//                .child("listFavouriteMovies")
//                .setValue(movieDao.getListMovieFromDb().value)
//        }
    }

    override suspend fun addMovieToDb(movie: Movie) {
        movieDao.addMovieToDb(
            mapper.mapMovieToDbMovie(movie)
        )

//        firebaseAuth = FirebaseAuth.getInstance()
//        firebaseAuth?.uid?.let {
//            referenceUsers.child(it)
//                .child("listFavouriteMovies")
//                .setValue(list)
//        }
    }


}