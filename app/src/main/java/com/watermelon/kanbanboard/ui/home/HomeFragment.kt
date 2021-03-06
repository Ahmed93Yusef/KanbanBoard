package com.watermelon.kanbanboard.ui.home

import android.graphics.ColorSpace
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAStyle
import com.watermelon.kanbanboard.databinding.FragmentHomeBinding
import com.watermelon.kanbanboard.ui.base.BaseFragment

/**
 * A simple [Fragment] subclass.
 * create an instance of this fragment.
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun setup() {}

    override fun callBack() {
        initPieChart()
    }

    private fun initPieChart() {
        val aaChartModel: AAChartModel = AAChartModel()
            .chartType(AAChartType.Column)
            .dataLabelsEnabled(true)
            .legendEnabled(false)
            .titleStyle(AAStyle().color("#008000"))
            .backgroundColor(ColorSpace.Rgb.ILLUMINANT_A)
            .categories(arrayOf("ToDo", "In Progress", "Done"))
            .series(
                arrayOf(
                    AASeriesElement()
                        .enableMouseTracking(true)
                        .data(arrayOf(4, 6, 8)),
                )
            )
            .animationDuration(3000)
        binding.homePieChart.apply {
            aa_drawChartWithChartModel(aaChartModel)
            aa_updateChartWithOptions(aaChartModel, true)
        }
    }

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate
}