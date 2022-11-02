package com.muratozturk.breakingbad.ui.character_detail

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.muratozturk.breakingbad.R
import com.muratozturk.breakingbad.common.Resource
import com.muratozturk.breakingbad.databinding.FragmentCharacterListBinding
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailFragment : Fragment(R.layout.fragment_character_detail) {

    private val binding by viewBinding(FragmentCharacterListBinding::bind)
    private val viewModel: CharacterDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        collectData()
    }

    private fun collectData() {
        with(viewModel)
        {
            viewLifecycleOwner.lifecycleScope.launchWhenStarted {
                state.collect { response ->
                    when (response) {
                        is Resource.Loading -> {
                            Log.e("Resource", "Loading")
                        }
                        is Resource.Success -> {
                            Log.e("Resource", response.data.toString())
                        }
                        is Resource.Error -> {
                            Log.e("Resource", response.throwable.localizedMessage ?: "")
                        }
                    }

                }

            }
        }
    }
}