package com.marcosconforti.horocopeapp.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.marcosconforti.horocopeapp.R
import com.marcosconforti.horocopeapp.databinding.ActivityDetailBinding
import com.marcosconforti.horocopeapp.domain.model.HoroscopeInfo.Aquarius
import com.marcosconforti.horocopeapp.domain.model.HoroscopeInfo.Aries
import com.marcosconforti.horocopeapp.domain.model.HoroscopeInfo.Cancer
import com.marcosconforti.horocopeapp.domain.model.HoroscopeInfo.Capricorn
import com.marcosconforti.horocopeapp.domain.model.HoroscopeInfo.Escorpio
import com.marcosconforti.horocopeapp.domain.model.HoroscopeInfo.Geminis
import com.marcosconforti.horocopeapp.domain.model.HoroscopeInfo.Leo
import com.marcosconforti.horocopeapp.domain.model.HoroscopeInfo.Libra
import com.marcosconforti.horocopeapp.domain.model.HoroscopeInfo.Pisces
import com.marcosconforti.horocopeapp.domain.model.HoroscopeInfo.Sagitarius
import com.marcosconforti.horocopeapp.domain.model.HoroscopeInfo.Taurus
import com.marcosconforti.horocopeapp.domain.model.HoroscopeInfo.Virgo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    private val viewModel: DetailViewModel by viewModels()

    private val args: DetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        viewModel.getHoroscope(args.type)
    }

    private fun initUI() {
        initListeners()
        initUIState()
    }

    private fun initListeners() {
        binding.ivBack.setOnClickListener { onBackPressed() }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->
                    when (state) {
                        HoroscopeDetailState.Loading -> loadingState()
                        is HoroscopeDetailState.Success -> successState(state)
                        is HoroscopeDetailState.Error -> errorState()
                    }
                }
            }
        }
    }

    private fun loadingState(){
        binding.progressBar.isVisible = true
    }
    private fun successState(state: HoroscopeDetailState.Success) {
        binding.progressBar.isVisible = false
        binding.tvTitle.text = state.sign
        binding.tvDetail.text = state.data

       val image = when(state.horoscopeInfo){
            Aries -> R.drawable.detail_aries
            Taurus -> R.drawable.detail_taurus
            Cancer -> R.drawable.detail_cancer
            Geminis -> R.drawable.detail_gemini
            Leo -> R.drawable.detail_leo
            Virgo -> R.drawable.detail_virgo
            Escorpio -> R.drawable.detail_scorpio
            Libra -> R.drawable.detail_libra
            Sagitarius -> R.drawable.detail_sagittarius
            Capricorn -> R.drawable.detail_capricorn
            Aquarius -> R.drawable.detail_aquarius
            Pisces -> R.drawable.detail_pisces
        }
        binding.ivDetail.setImageResource(image)
    }
    private fun errorState() {
        binding.progressBar.isVisible = false
    }
}