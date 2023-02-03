package com.example.dagger2impl.view


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.dagger2impl.R
import com.example.dagger2impl.core.di.DaggerProductComponent
import com.example.dagger2impl.core.di.ProductComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    //    lateinit var useCase: UseCase
    
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userData: ProductComponent = DaggerProductComponent.builder().build()
        userData.mainAct(this)
        val viewModel =
            ViewModelProvider(this, viewModelFactory)[ProductViewModel::class.java]
        viewModel.getData()

    }

    private fun observeViewModel(){


    }
}