package com.muratozturk.breakingbad.ui.character_detail

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.muratozturk.breakingbad.R
import com.muratozturk.breakingbad.common.LoadingScreen
import com.muratozturk.breakingbad.common.Resource
import com.muratozturk.breakingbad.common.glideImage
import com.muratozturk.breakingbad.databinding.FragmentCharacterDetailBinding
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailFragment : Fragment(R.layout.fragment_character_detail) {

    private val binding by viewBinding(FragmentCharacterDetailBinding::bind)
    private val viewModel: CharacterDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        collectData()
    }

    private fun collectData() {
        with(viewModel) {
            viewLifecycleOwner.lifecycleScope.launchWhenStarted {
                state.collect { response ->
                    when (response) {
                        is Resource.Loading -> {
                            LoadingScreen.displayLoadingWithText(
                                requireContext(), resources.getString(R.string.please_wait), false
                            )
                        }
                        is Resource.Success -> {
                            LoadingScreen.hideLoading()
                            with(binding) {
                                with(response.data) {
                                    imageView.glideImage(img)
                                    imageViewBanner.glideImage(img, true)
                                    textView.text = name
                                    nickNameText.text = nickname
                                    birthDataText.text = birthday
                                    portrayedText.text = portrayed
                                    occupationText.text = occupation.joinToString()
                                    appearanceText.text = appearance.joinToString()
                                    statusText.text = status
                                }

                            }
                        }
                        is Resource.Error -> {
                            LoadingScreen.hideLoading()
                            Log.e("Resource", response.throwable.localizedMessage ?: "")
                        }
                    }

                }

            }
        }
    }
}