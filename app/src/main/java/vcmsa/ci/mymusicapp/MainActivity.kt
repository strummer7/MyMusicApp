package vcmsa.ci.mymusicapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    companion object{
        val songList = arrayListOf<String>()
        val artistList = arrayListOf<String>()
        val ratingList = arrayListOf<Int>()
        val commentList = arrayListOf<String>()
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val songTitle = findViewById<TextView>(R.id.textViewTitle)
        val artistName = findViewById<TextView>(R.id.textViewName)
        val rating = findViewById<TextView>(R.id.textViewRating)
        val comment = findViewById<TextView>(R.id.textViewComment)

        val buttonAdd = findViewById<Button>(R.id.buttonAdd)
        val buttonExit = findViewById<Button>(R.id.buttonExit)
        val buttonNext = findViewById<Button>(R.id.buttonViewList)

        buttonAdd.setOnClickListener {
            val song = songTitle.text.toString()
            val artist = artistName.text.toString()
            val ratingStr = rating.text.toString()
            val comment = comment.text.toString()
            if (song.isBlank()||artist.isBlank()||ratingStr.isBlank()||comment.isBlank()){
                Toast.makeText(this,"please fill in all fields", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val rating= ratingStr.toIntOrNull()
            if (rating== null || rating <=0){
                Toast.makeText(this,"rating must be a positive number", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            songList.add(song)
            artistList.add(artist)
            ratingList.add(rating)
            commentList.add(comment)
            Toast.makeText(this,"item added to packing list!", Toast.LENGTH_LONG).show()

            songTitle.text.clear()
            artistName.text.clear()
        }
        buttonNext.setOnClickListener {
startActivity(Intent(this,activity2::class.java))
        }
        buttonExit.setOnClickListener {
            finish()
        }
    }
}

private fun Any.clear() {
    TODO("Not yet implemented")
}

