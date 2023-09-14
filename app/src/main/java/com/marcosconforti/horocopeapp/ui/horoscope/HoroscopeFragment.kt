package com.marcosconforti.horocopeapp.ui.horoscope

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.marcosconforti.horocopeapp.databinding.FragmentHoroscopeBinding
import com.marcosconforti.horocopeapp.domain.model.HoroscopeInfo
import com.marcosconforti.horocopeapp.domain.model.HoroscopeModel
import com.marcosconforti.horocopeapp.domain.model.HoroscopeModel.*
import com.marcosconforti.horocopeapp.ui.horoscope.adapter.HoroscopeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeFragment : Fragment() {

    private var _binding: FragmentHoroscopeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HoroscopeViewModel by viewModels()

    private lateinit var horoscopeAdapter: HoroscopeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHoroscopeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
    }

    private fun initUI() {
        initUIState()
        initRecycler()
    }

    private fun initRecycler() {
        horoscopeAdapter = HoroscopeAdapter(onItemSelected = {
            val type = when (it) {
                Aquarius -> HoroscopeInfo.Aquarius
                Aries -> HoroscopeInfo.Aries
                Cancer -> HoroscopeInfo.Cancer
                Capricorn -> HoroscopeInfo.Capricorn
                Escorpio -> HoroscopeInfo.Escorpio
                Geminis -> HoroscopeInfo.Geminis
                Leo -> HoroscopeInfo.Leo
                Libra -> HoroscopeInfo.Libra
                Pisces -> HoroscopeInfo.Pisces
                Sagitarius -> HoroscopeInfo.Sagitarius
                Taurus -> HoroscopeInfo.Taurus
                Virgo -> HoroscopeInfo.Virgo
            }
            findNavController().navigate(
                HoroscopeFragmentDirections.actionHoroscopeFragmentToDetailActivity(type)
            )
        })

        binding.rvHoroscope.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = horoscopeAdapter
        }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.horoscope.collect {
                    horoscopeAdapter.updateList(it)
                }
            }
        }

    }

}