package com.example.phonesshop.app

import android.app.Application
import com.example.core.retrofit.RetrofitFactory
import com.example.product_details.di.ProductDetailsModule
import com.example.product_details.ui.product_details.ProductDetailsViewModel
import com.example.product_list.di.ProductListModule
import com.example.product_list.ui.product_list.ProductListViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
    private val retrofitModule = module {
        factory { RetrofitFactory() }
    }
    private val productDetailsModule = module {
        ProductDetailsModule().apply{
            single { provideDetApi(get()) }
            single {provideDetRepository(get())}
            single {provideDetInteractor(get())}
            viewModel{ ProductDetailsViewModel(get()) }
        }
    }
    private val productListModule = module {
        ProductListModule().apply{
            single { provideApi(get()) }
            single {provideRepository(get())}
            single {provideInteractor(get())}
            viewModel{ ProductListViewModel(get()) }
        }
    }

    private fun initKoin() {
        startKoin{
            androidLogger()
            androidContext(this@App)

            modules(
                retrofitModule,
                productListModule,
                productDetailsModule

            )
        }
    }

}