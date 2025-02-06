package br.ufg.inf.android.listarecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.ufg.inf.android.listarecyclerview.databinding.ProductItemBinding

class ProductAdapter(
    private val list: List<Product>,
    private val onItemClickListener: (Product) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    inner class ViewHolder(
        private val productItemBinding: ProductItemBinding
    ) :
        RecyclerView.ViewHolder(productItemBinding.root) {
        private lateinit var item: Product

        init {
            productItemBinding.root.setOnClickListener {
                if (::item.isInitialized)
                    onItemClickListener(item)
            }
        }

        fun bind(item: Product) {
            this.item = item
            productItemBinding.apply {
                image.setImageResource(item.image)
                txtDescription.text = item.description
                txtType.text = item.type
                txtValue.text = item.valueReal
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder = ViewHolder(
        ProductItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }


}