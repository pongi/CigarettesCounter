package com.pongi.cigarettescounter.util

import android.content.Context
import android.util.DisplayMetrics


/**
 * dpからpixelへの変換
 * @param dp
 * @param context
 * @return float pixel
 */
fun dpToPx(dp: Int, context: Context): Float {
    val metrics = context.getResources().getDisplayMetrics()
    return dp * metrics.density
}

/**
 * pixelからdpへの変換
 * @param px
 * @param context
 * @return float dp
 */
fun pxToDp(px: Int, context: Context): Float {
    val metrics = context.getResources().getDisplayMetrics()
    return px / metrics.density
}