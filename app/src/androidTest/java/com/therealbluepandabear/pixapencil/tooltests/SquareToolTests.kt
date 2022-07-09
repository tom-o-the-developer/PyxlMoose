package com.therealbluepandabear.pixapencil.tooltests

import android.graphics.Color
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.therealbluepandabear.pixapencil.activities.canvas.CanvasActivity
import com.therealbluepandabear.pixapencil.algorithms.SquarePreviewAlgorithm
import com.therealbluepandabear.pixapencil.extensions.getPixel
import com.therealbluepandabear.pixapencil.fragments.canvas.pixelGridViewInstance
import com.therealbluepandabear.pixapencil.models.Coordinates
import com.therealbluepandabear.pixapencil.tooltests.helper.ToolTestsHelper
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class SquareToolTests {
    @get:Rule
    val activityRule = ActivityScenarioRule(CanvasActivity::class.java)

    @Test
    fun stt_1() {
        activityRule.scenario.onActivity {
            ToolTestsHelper.prepare(it)

            val squareAlgorithm = SquarePreviewAlgorithm(it.primaryAlgorithmInfoParameter)
            squareAlgorithm.compute(Coordinates(0, 0), Coordinates(2, 2))

            assert(pixelGridViewInstance.pixelGridViewBitmap.getPixel(Coordinates(0, 0)) == Color.BLACK)
            assert(pixelGridViewInstance.pixelGridViewBitmap.getPixel(Coordinates(1, 0)) == Color.BLACK)
            assert(pixelGridViewInstance.pixelGridViewBitmap.getPixel(Coordinates(2, 0)) == Color.BLACK)
            assert(pixelGridViewInstance.pixelGridViewBitmap.getPixel(Coordinates(0, 1)) == Color.BLACK)
            assert(pixelGridViewInstance.pixelGridViewBitmap.getPixel(Coordinates(0, 2)) == Color.BLACK)
            assert(pixelGridViewInstance.pixelGridViewBitmap.getPixel(Coordinates(2, 1)) == Color.BLACK)
            assert(pixelGridViewInstance.pixelGridViewBitmap.getPixel(Coordinates(2, 2)) == Color.BLACK)
            assert(pixelGridViewInstance.pixelGridViewBitmap.getPixel(Coordinates(1, 2)) == Color.BLACK)
        }
    }
}