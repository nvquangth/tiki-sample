package com.example.tikisample.widgets

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods
import com.example.tikisample.R

/**
 * Created by Quang Nguyen on 8/2/20.
 */

@BindingMethods(
    BindingMethod(
        type = LineProgressBar::class,
        attribute = "lpbBgColor",
        method = "setBgColor"
    ),
    BindingMethod(
        type = LineProgressBar::class,
        attribute = "lpbProgressColor",
        method = "setProgressColor"
    ),
    BindingMethod(
        type = LineProgressBar::class,
        attribute = "lpbMaxProgress",
        method = "setMaxProgress"
    ),
    BindingMethod(
        type = LineProgressBar::class,
        attribute = "lpbProgress",
        method = "setProgress"
    )
)
class LineProgressBar(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private var paint = Paint()
    private var bgColor = Color.RED
    private var progressColor = Color.GRAY
    private var maxProgress = 100
    private var progress = 0

    init {
        context.theme.obtainStyledAttributes(attrs, R.styleable.LineProgressBar, 0, 0).apply {
            try {
                bgColor = getColor(R.styleable.LineProgressBar_lpbBackgroundColor, bgColor)
                progressColor =
                    getColor(R.styleable.LineProgressBar_lpbProgressColor, progressColor)
                maxProgress = getInteger(R.styleable.LineProgressBar_lpbMaxProgress, maxProgress)
                progress = getInteger(R.styleable.LineProgressBar_lpbProgress, progress)
            } finally {
                recycle()
            }
        }
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val radius = height / 2f
        val widthProgress = height + progress * (width - height) / maxProgress.toFloat()
        val radiusArr = floatArrayOf(
            radius, radius,
            radius, radius,
            radius, radius,
            radius, radius
        )

        val path1 = Path()
        path1.addRoundRect(
            RectF(0f, 0f, width.toFloat(), height.toFloat()),
            radiusArr,
            Path.Direction.CW
        )
        paint.color = bgColor
        canvas?.drawPath(path1, paint)
        path1.close()


        val path2 = Path()
        path2.addRoundRect(
            RectF(0f, 0f, widthProgress, height.toFloat()),
            radiusArr,
            Path.Direction.CW
        )
        paint.color = progressColor
        canvas?.drawPath(path2, paint)
        path2.close()
    }

    fun setBgColor(color: Int) {
        bgColor = color
        invalidate()
    }

    fun setProgressColor(color: Int) {
        progressColor = color
        invalidate()
    }

    fun setMaxProgress(p: Int) {
        maxProgress = p
        invalidate()
    }

    fun setProgress(p: Int) {
        progress = p
        invalidate()
    }
}