package com.muratozturk.breakingbad.ui.episode_list

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.muratozturk.breakingbad.R
import com.muratozturk.breakingbad.common.Resource
import com.muratozturk.breakingbad.databinding.FragmentEpisodeListBinding
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EpisodeListFragment : Fragment(R.layout.fragment_episode_list) {
    private val binding by viewBinding(FragmentEpisodeListBinding::bind)
    private val viewModel: EpisodeListViewModel by viewModels()

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
                            Log.i("Resource", "Loading")
                        }
                        is Resource.Success -> {
                            Log.e("Resource", response.data.toString())
                            val adapter = EpisodeAdapter(response.data)
                            binding.episodeRecycler.adapter = adapter
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