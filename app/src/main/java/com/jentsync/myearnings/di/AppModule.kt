package com.jentsync.myearnings.di




import com.jentsync.myearnings.data.local_storage.EarnedCashDataBase
import com.jentsync.myearnings.repository.EarnedCashRepository
import com.jentsync.myearnings.viewmodel.EarnedCashViewModel
import com.jentsync.myearnings.viewmodel.SettingsViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel


val appModule = module {
//  Define dependency injection here

    single { EarnedCashDataBase.getDatabase(get()).earnedCashDao() }
    single { EarnedCashRepository(get()) }
    viewModel{ EarnedCashViewModel(get())}


    viewModel{ SettingsViewModel(get()) }


}