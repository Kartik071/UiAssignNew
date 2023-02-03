package com.example.dagger2impl.core.di

import com.example.dagger2impl.view.MainActivity
import com.example.dagger2impl.ViewModelModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [FakeStoreModule::class,ViewModelModule::class])
@Singleton
interface ProductComponent {
    // fun useCase() : UseCase
    fun mainAct(mainActivity: MainActivity)
}