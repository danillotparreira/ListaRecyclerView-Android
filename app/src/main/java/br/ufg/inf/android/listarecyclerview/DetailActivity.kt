package br.ufg.inf.android.listarecyclerview

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.ufg.inf.android.listarecyclerview.databinding.ActivityDetailBinding
import java.text.NumberFormat
import java.util.Locale

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val item = intent.getSerializableExtra("item", Product::class.java)
        item?.let { product ->
            binding.apply {
                image.setImageResource(item.image)
                description.text = item.description
                type.text = item.type
                value.text = item.valueReal
                color.text = item.color
                size.text = item.size
                avaliable.text = item.avaliable
                soldBy.text = item.soldBy
            }
        }
        val intentMain = Intent(this, MainActivity::class.java)
        binding.apply {
            button.setOnClickListener {
                startActivity(intentMain)
                finish()
            }
            imgBack.setOnClickListener{
                startActivity(intentMain)
                finish()
            }
        }
    }
}