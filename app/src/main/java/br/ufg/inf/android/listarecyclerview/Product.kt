package br.ufg.inf.android.listarecyclerview

import java.io.Serializable
import java.text.NumberFormat
import java.util.Locale

data class Product(
    val image: Int,
    val description: String,
    val type: String,
    val value: Double,
    val color: String,
    val size: String,
    val avaliable: String,
    val soldBy: String
) : Serializable {
    val valueReal: String
        get() = NumberFormat.getCurrencyInstance(Locale("pt", "BR")).format(value)
}