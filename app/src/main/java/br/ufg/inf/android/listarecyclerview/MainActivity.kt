package br.ufg.inf.android.listarecyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.Adapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.ufg.inf.android.listarecyclerview.databinding.ActivityMainBinding
import br.ufg.inf.android.listarecyclerview.databinding.ProductItemBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val adapter = ProductAdapter(
            list = getList(),
            onItemClickListener = { item ->
                val intent = Intent(this, DetailActivity::class.java).apply {
                    putExtra("item", item)
                }
                startActivity(intent)
                finish()
            }
        )
        binding.recyclerView.adapter = adapter

    }

    private fun getList(): List<Product> {
        return listOf(
            Product(
                R.drawable.notebook,
                "Notebook Dell Inspiron",
                "Eletrônico",
                4500.00,
                "Preto",
                "15.6\"",
                "Em estoque",
                "Dell Store"
            ),
            Product(
                R.drawable.celular,
                "Smartphone Samsung Galaxy S21",
                "Eletrônico",
                3500.00,
                "Cinza",
                "6.5\"",
                "Em estoque",
                "Samsung Oficial"
            ),
            Product(
                R.drawable.mouse,
                "Mouse Gamer RGB",
                "Acessório",
                250.00,
                "Preto",
                "Médio",
                "Em estoque",
                "Logitech Store"
            ),
            Product(
                R.drawable.fone,
                "Fone de Ouvido Bluetooth",
                "Acessório",
                150.00,
                "Branco",
                "Único",
                "Fora de estoque",
                "JBL Oficial"
            ),
            Product(
                R.drawable.tv,
                "Smart TV 50\" 4K",
                "Eletrônico",
                3200.00,
                "Preto",
                "50\"",
                "Em estoque",
                "LG Brasil"
            ),
            Product(
                R.drawable.relogio,
                "Relógio Inteligente Xiaomi",
                "Acessório",
                700.00,
                "Preto",
                "1.4\"",
                "Em estoque",
                "Xiaomi Store"
            ),
            Product(
                R.drawable.teclado,
                "Teclado Mecânico RGB",
                "Acessório",
                350.00,
                "Preto",
                "Padrão ABNT2",
                "Em estoque",
                "Razer Store"
            ),
            Product(
                R.drawable.impressora,
                "Impressora Multifuncional HP",
                "Eletrônico",
                1200.00,
                "Branco",
                "A4",
                "Em estoque",
                "HP Oficial"
            ),
            Product(
                R.drawable.cadeira,
                "Cadeira Gamer Ergonômica",
                "Móveis",
                1800.00,
                "Vermelho e Preto",
                "Grande",
                "Fora de estoque",
                "Kabum!"
            ),
            Product(
                R.drawable.monitor,
                "Monitor 27\" Full HD",
                "Eletrônico",
                1300.00,
                "Preto",
                "27\"",
                "Em estoque",
                "Samsung Oficial"
            ),
            Product(
                R.drawable.camera,
                "Câmera Canon EOS Rebel T7",
                "Fotografia",
                2800.00,
                "Preto",
                "Único",
                "Em estoque",
                "Canon Store"
            ),
            Product(
                R.drawable.hd,
                "HD Externo 2TB Seagate",
                "Armazenamento",
                600.00,
                "Preto",
                "2TB",
                "Em estoque",
                "Amazon"
            ),
            Product(
                R.drawable.ssd,
                "SSD Kingston NVMe 1TB",
                "Armazenamento",
                850.00,
                "Preto",
                "1TB",
                "Fora de estoque",
                "Kingston Oficial"
            ),
            Product(
                R.drawable.alexa,
                "Echo Dot 4ª Geração Alexa",
                "Casa Inteligente",
                380.00,
                "Branco",
                "Pequeno",
                "Em estoque",
                "Amazon"
            ),
            Product(
                R.drawable.fogao,
                "Fogão 4 bocas Electrolux",
                "Eletrodoméstico",
                1400.00,
                "Inox",
                "Médio",
                "Em estoque",
                "Magazine Luiza"
            ),
            Product(
                R.drawable.microondas,
                "Microondas 30L Brastemp",
                "Eletrodoméstico",
                1100.00,
                "Preto",
                "30L",
                "Fora de estoque",
                "Brastemp Oficial"
            ),
            Product(
                R.drawable.geladeira,
                "Geladeira Frost Free Brastemp",
                "Eletrodoméstico",
                3400.00,
                "Inox",
                "Grande",
                "Em estoque",
                "Casas Bahia"
            ),
            Product(
                R.drawable.ventilador,
                "Ventilador Arno Silence Force",
                "Eletrodoméstico",
                250.00,
                "Branco",
                "Médio",
                "Em estoque",
                "Americanas"
            ),
            Product(
                R.drawable.bicicleta,
                "Bicicleta Caloi Aro 29",
                "Esporte",
                2200.00,
                "Preto e Azul",
                "Aro 29",
                "Em estoque",
                "Centauro"
            ),
            Product(
                R.drawable.fitness,
                "Kit Halteres 10kg",
                "Esporte",
                150.00,
                "Preto",
                "10kg",
                "Em estoque",
                "Decathlon"
            )
        )
    }

}