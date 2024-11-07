package com.rajabi.noteapp.di

import androidx.compose.runtime.referentialEqualityPolicy
import com.rajabi.noteapp.domain.repository.NoteRepository
import com.rajabi.noteapp.domain.usecase.AddNoteUseCase
import com.rajabi.noteapp.domain.usecase.DeleteNoteUseCase
import com.rajabi.noteapp.domain.usecase.GetAllNotesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideGetAllNotesUseCase(
        noteRepository: NoteRepository
    ): GetAllNotesUseCase {
        return GetAllNotesUseCase(noteRepository)
    }

    @Singleton
    @Provides
    fun provideSaveNoteUseCase(
        noteRepository: NoteRepository
    ): AddNoteUseCase {
        return AddNoteUseCase(noteRepository)
    }

    @Singleton
    @Provides
    fun provideDeleteNoteUseCase(
        noteRepository: NoteRepository
    ): DeleteNoteUseCase {
        return DeleteNoteUseCase(
            noteRepository
        )
    }
}