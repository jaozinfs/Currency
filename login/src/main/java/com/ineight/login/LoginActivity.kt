package com.ineight.login

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.ineight.common.base.BaseActivity
import com.ineight.common.getTextString
import com.ineight.common.setVisibility
import com.ineight.common.toastMessage
import com.ineight.domain.Result
import com.ineight.domain.usecase.InsertUserUseCase
import com.ineight.router.Features
import com.ineight.router.goTo
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.inject

class LoginActivity : BaseActivity() {

    private val userUseCase: InsertUserUseCase by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        materialButton.setOnClickListener {
            GlobalScope.launch {
                val livedata = userUseCase.insert(
                    InsertUserUseCase.Params(
                        name.getTextString(),
                        email.getTextString()
                    )
                )
                withContext(Dispatchers.Main) {
                    livedata.observe(this@LoginActivity, Observer {
                        when (it) {
                            Result.Loading -> {
                                showProgress(true)
                            }
                            is Result.Error -> {
                                showProgress(false)
                            }
                            is Result.Sucess<*> -> {
                                goTo(Features.Home)
                            }
                        }
                    })
                }
            }
        }
    }

    override fun showProgress(visibility: Boolean) {
        progress.setVisibility(visibility)
    }

}