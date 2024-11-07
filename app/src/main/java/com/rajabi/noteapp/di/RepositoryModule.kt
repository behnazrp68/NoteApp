package com.rajabi.noteapp.di

import com.rajabi.noteapp.data.repository.NoteRepositoryImpl
import com.rajabi.noteapp.data.repository.datasource.NoteLocalDataSource
import com.rajabi.noteapp.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideNoteRepository(
        noteLocalDataSource : NoteLocalDataSource
    ) : NoteRepository{
        return NoteRepositoryImpl(
            noteLocalDataSource
        )
    }
}