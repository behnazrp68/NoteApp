package com.rajabi.noteapp.di

import android.content.Context
import androidx.room.Room
import com.rajabi.noteapp.data.db.NoteDao
import com.rajabi.noteapp.data.db.NoteDataBase
import com.rajabi.noteapp.data.repository.datasource.NoteLocalDataSource
import com.rajabi.noteapp.data.repository.datasourceimple.NoteLocalDataSourceImpl
import com.rajabi.noteapp.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Singleton
    @Provides
    fun provideNoteDao(noteDataBase: NoteDataBase): NoteDao {
        return noteDataBase.getNoteDao()
    }

    @Singleton
    @Provides
    fun provideNoteDataBase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, NoteDataBase::class.java, "note_data_base")
            .fallbackToDestructiveMigration().build()


    @Singleton
    @Provides
    fun provideNoteLocalDataSource(noteDao: NoteDao): NoteLocalDataSource =
        NoteLocalDataSourceImpl(noteDao)
}