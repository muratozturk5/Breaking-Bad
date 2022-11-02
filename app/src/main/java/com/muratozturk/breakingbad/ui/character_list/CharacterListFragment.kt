package com.muratozturk.breakingbad.ui.character_list

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.muratozturk.breakingbad.R
import com.muratozturk.breakingbad.common.Resource
import com.muratozturk.breakingbad.databinding.FragmentCharacterListBinding
import com.muratozturk.breakingbad.domain.model.CharacterUI
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
                    when (response) {
                        is Resource.Loading -> {
                            Log.e("Resource", "Loading")
                        }
                        is Resource.Success -> {
                            Log.e("Resource", response.data.toString())

                            val charactersAdapter =
                                CharactersAdapter(response.data as ArrayList<CharacterUI>)
                            binding.recyclerView.adapter = charactersAdapter
                            charactersAdapter.onClick = ::clickCharacter

                            binding.recyclerView.layoutManager =
                                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                            binding.recyclerView.setHasFixedSize(true)
                        }
                        is Resource.Error -> {
                            Log.e("Resource", response.throwable.localizedMessage ?: "")
                        }
                    }

                }

            }
        }
    }

    private fun clickCharacter(id: Int) {
        findNavController().navigate(
            CharacterListFragmentDirections.actionCharacterListFragmentToCharacterDetailFragment(
                id
            )
        )
    }
}