package com.example.taskwebgridcardview

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    private val websites = arrayOf(
        GridItem("Yandex", R.drawable.yandex),
        GridItem("Gismeteo", R.drawable.gismeteo),
        GridItem("Google", R.drawable.google),
        GridItem("Apple", R.drawable.apple),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val gridView: GridView = findViewById(R.id.gridView)
        val adapter = GridAdapter(this, websites)
        gridView.adapter = adapter

        gridView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, WebViewActivity::class.java)
            intent.putExtra("url", getWebsiteUrl(websites[position].name))
            startActivity(intent)
        }
    }

    private fun getWebsiteUrl(name: String): String {
        return when (name) {
            "Yandex" -> "https://www.yandex.ru"
            "Gismeteo" -> "https://www.gismeteo.ru"
            "Google" -> "https://www.google.com"
            "Apple" -> "https://www.apple.com"
            else -> "https://www.google.com"
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_exit -> {
                finishAffinity()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}