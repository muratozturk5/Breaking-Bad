package com.muratozturk.breakingbad.ui.character_list

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.muratozturk.breakingbad.R
import com.muratozturk.breakingbad.databinding.FragmentCharacterListBinding
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterListFragment : Fragment(R.layout.fragment_character_list) {

    private val binding by viewBinding(FragmentCharacterListBinding::bind)
    private val viewModel: CharacterListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            collectData()
        }

    }

    private fun collectData() {
        with(viewModel) {
            viewLifecycleOwner.lifecycleScope.launchWhenStarted {
                state.collect { response ->
                    if (response.isLoading) {
                        Log.e("Loading", "true")
                    } else {
                        Log.e("Loading", "false")
                    }

                    Log.e("Characters", response.characters.toString())
                    Log.e("Error", response.error)

                }

            }
        }
    }
}