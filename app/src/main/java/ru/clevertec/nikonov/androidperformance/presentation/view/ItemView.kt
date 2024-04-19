package ru.clevertec.nikonov.androidperformance.presentation.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.net.toUri
import com.bumptech.glide.Glide
import ru.clevertec.nikonov.androidperformance.data.dto.Product
import ru.clevertec.nikonov.androidperformance.databinding.ItemViewBinding

internal class ItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    val b = ItemViewBinding.inflate(LayoutInflater.from(context), this, true)

    fun populate(item: Product) {
        b.itemTitle.text = item.title
        Glide.with(context).load(item.imageUrl.toUri()).into(b.itemIcon)
        b.itemRate.text = "${item.rate}/5.0"
        b.itemDescriptionLeft.removeAllViews()
        for (i in 0 until item.description.size / 2) {
            b.itemDescriptionLeft.addView(AppCompatTextView(context).apply {
                text = item.description[i]
            })
        }
        b.itemDescriptionRight.removeAllViews()
        for (i in item.description.size / 2..item.description.lastIndex) {
            b.itemDescriptionRight.addView(AppCompatTextView(context).apply {
                text = item.description[i]
            })
        }
        b.itemPrice.text = "${item.price} рублей"
        b.itemOfferDetailsContainer.removeAllViews()
        item.offerDetails.forEach {
            b.itemOfferDetailsContainer.addView(AppCompatTextView(context).apply {
                text = it
            })
        }
    }
}