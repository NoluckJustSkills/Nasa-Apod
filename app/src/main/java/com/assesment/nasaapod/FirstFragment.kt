package com.assesment.nasaapod

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.widget.NestedScrollView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.assesment.nasaapod.core.util.MediaType
import com.assesment.nasaapod.databinding.FragmentFirstBinding
import com.assesment.nasaapod.domain.model.ApodInfo
import com.assesment.nasaapod.presentation.ApodInfoViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */


@AndroidEntryPoint
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private val binding get() = _binding!!
    private val apodInfoViewModel: ApodInfoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding= DataBindingUtil.inflate<FragmentFirstBinding>(
            inflater, R.layout.fragment_first, container, false
        ).apply {
            viewModel = apodInfoViewModel
            lifecycleOwner = viewLifecycleOwner
            callback = object : Callback {
                override fun addToFavorite(apod: ApodInfo) {
//                    apod.favorite = !apod.favorite
//                    apodDetailViewModel.addApodToFavorite(apod)
//                    val snackMessageStringId = if (apod.favorite) {
//                        R.string.added_to_favorite
//                    } else {
//                        R.string.removed_from_favorite
//                    }
//                    Snackbar.make(root, snackMessageStringId, Snackbar.LENGTH_LONG).show()
                }
            }

        }

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        apodInfoViewModel.getApodData()


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    interface Callback {
        fun addToFavorite(apod: ApodInfo)
    }
}