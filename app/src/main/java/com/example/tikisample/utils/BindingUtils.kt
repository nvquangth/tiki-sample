package com.example.tikisample.utils

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.mvvmarchitecture.utils.GlideApp
import com.example.tikisample.R
import com.example.tikisample.data.model.Product
import com.example.tikisample.data.model.Progress
import java.text.DecimalFormat

/**
 * Created by Quang Nguyen on 6/29/20.
 */

@BindingAdapter("glideUrl")
fun ImageView.setGlideUrl(url: String?) {
    GlideApp.with(context)
        .load(url)
        .into(this)
}

@SuppressLint("SetTextI18n")
@BindingAdapter("discountPercent")
fun TextView.setDiscountPercent(discount: Float?) {
    this.text = "-$discount%"
}

@SuppressLint("SetTextI18n")
@BindingAdapter("textSell")
fun TextView.setTextSell(progress: Progress) {
    when {
        progress.percent ?: 0f <= 20 -> this.text = this.context.getString(R.string.fd_hot_sell)
        progress.percent ?: 0f <= 90 -> this.text =
            "${this.context.getString(R.string.fd_sell)} ${progress.qtyOrdered}"
        else -> this.text = this.context.getString(R.string.fd_new_sell)
    }
}

@BindingAdapter("iconHotDealVisibility")
fun ImageView.setIconHotDealVisibility(progress: Progress) {
    if (progress.percent ?: 0f <= 20) {
        this.visibility = View.VISIBLE
    } else {
        this.visibility = View.GONE
    }
}

@BindingAdapter("textPrice")
fun TextView.setTextPrice(product: Product) {

    val unit = "đ"

    val pattern = product.pricePrefix
        ?.map {
            if (it == '.') ','
            else '#'
        }
        ?.joinToString("")
    val numberFormat = DecimalFormat(pattern)
    val priceStr = numberFormat.format(product.price)?.replace(",", ".") + " " + unit

    this.text = priceStr
}