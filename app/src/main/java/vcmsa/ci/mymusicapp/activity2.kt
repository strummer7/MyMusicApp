package vcmsa.ci.mymusicapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class activity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val songList = findViewById<TextView>(R.id.textViewList)
        val averageRating = findViewById<TextView>(R.id.textViewAverage)
        val buttonList = findViewById<Button>(R.id.buttonList)
        val average = findViewById<Button>(R.id.buttonAverage)
        val back = findViewById<Button>(R.id.buttonBack)

        val fullList = StringBuilder()
        for (i in MainActivity.songList.indices)
            fullList.append("song:${MainActivity.songList[i]}\n")

        songList.text = fullList.toString()
        buttonList.setOnClickListener {
            val list = StringBuilder("song list")
        }
}
    }