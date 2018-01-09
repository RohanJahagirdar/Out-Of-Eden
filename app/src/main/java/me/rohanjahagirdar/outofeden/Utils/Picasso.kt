package me.rohanjahagirdar.outofeden.Utils

import android.content.Context
import com.squareup.picasso.Picasso

/**
 * Created by Rohan Jahagirdar on 07-01-2018.
 */


public val Context.picasso: Picasso
    get() = Picasso.with(this)
