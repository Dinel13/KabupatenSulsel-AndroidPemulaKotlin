package com.fiqri.kabsulsel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvKab: RecyclerView
    private var list: ArrayList<Kabupaten> = arrayListOf()
    private var title: String = "Mode List"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionbar = supportActionBar
        actionbar!!.title = "Home"

        rvKab = findViewById(R.id.rv_kab)
        rvKab.setHasFixedSize(true)

        list.addAll(KabupatenData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvKab.layoutManager = LinearLayoutManager(this)
        val listUnivAdapter = ListAdapter(list)
        rvKab.adapter = listUnivAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.about -> {
                title = "Tentang Saya"
                val iAbout = Intent(this@MainActivity, About::class.java)
                startActivity(iAbout)
            }
            R.id.action_grid -> {
                title = "Grid"
                tampilGrid()
            }
            R.id.action_list -> {
                title = "List"
                showRecyclerList()
            }
            R.id.action_cardview -> {
                title = "Card"
                tampilCard()
            }
        }
        tampilBar(title)
    }

    private fun tampilCard() {
        rvKab.layoutManager = LinearLayoutManager(this)
        val carddapter = cardAdapter(list)
        rvKab.adapter = carddapter

    }


    private fun tampilGrid() {

        rvKab.layoutManager = LinearLayoutManager(this)
        val gridAdapter = gridAAdapter(list)
        rvKab.adapter = gridAdapter
    }


    private fun tampilBar(title: String) {
        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = title
        }

    }
}