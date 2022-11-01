package com.muratozturk.breakingbad.ui.detail


import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.muratozturk.breakingbad.R
import com.muratozturk.breakingbad.common.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {
    private val viewModel: DetailViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    private fun collectData() {
        with(viewModel) {
            viewLifecycleOwner.lifecycleScope.launchWhenStarted {
                character.collect{ response->
                    when (response) {
                        is Resource.Loading -> Log.e("loading", "loading")
                        is Resource.Success -> {
                            Log.e("data", response.data.toString())

                        }
                        is Resource.Error -> Log.e("throwable", response.throwable.toString())
                    }
                }

            }
        }
    }
}