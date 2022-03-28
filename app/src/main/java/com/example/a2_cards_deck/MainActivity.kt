package com.example.a2_cards_deck

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.a2_cards_deck.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val card = CardBKT("hearts", 4)
        println(card.toString())
        val cardC = CardC("clubs", 10)
        println(cardC.toString())
        val cardC2 = CardC("clubs")
        println(cardC2.toString())
        val cardB2 = CardBKT("diamonds", 12)
        println(card.compareTo(cardB2))
        val deck = Deck.createDeckWithJokers()
        println(deck.toString())
        deck.shuffleDeck()
        println(deck.toString())
        val dealtCards = ArrayList<CardB>()
        for (i in 0..4) {
            dealtCards.add(deck.dealCard())
        }
        println(dealtCards)
        deck.addCard(dealtCards[0])
        deck.addCard(dealtCards[1])
        deck.addCard(dealtCards[1])
        println(deck)
        deck.sortDeck()
        println(deck)
        while (!deck.isEmpty) {
            deck.dealCard()
        }
        println(deck)

        val games = FolderKT()
        games.setName("games")
        val photos = FolderKT()
        photos.setName("photos")
        val rootDir = FolderKT(games, photos)
        rootDir.setName("root")
        val doca2 = FileKT("exe")
        doca2.setName("doca2")
        doca2.setParent(games)
        println(doca2.getFullPath())

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}