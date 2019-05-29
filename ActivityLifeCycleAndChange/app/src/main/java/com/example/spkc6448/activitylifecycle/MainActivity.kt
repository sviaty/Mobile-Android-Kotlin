package com.example.spkc6448.activitylifecycle

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent



class MainActivity : AppCompatActivity() {

    lateinit var value: String

    // Appelée lorsque votre activité est créée par le système et qu'elle entre dans l'état Created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Activity Life cycle", " onCreate")

        loadDataBundle()
        setupListenner()
    }

    // Appelée par le système lorsque l'activité entre dans l'état Started.
    // L'interface graphique devient visible à l'utilisateur, mais il ne peut pas encore interagir avec les différents éléments.
    override fun onStart() {
        super.onStart()
        Log.d("Activity life cycle", " onStart")
    }

    // Appelée lorsque l'activité entre dans l'état Resumed. L'activité devient entièrement opérationnelle.
    // L'utilisateur peut utiliser l'application et cliquer sur les différents éléments graphiques.
    override fun onResume() {
        super.onResume()
        Log.d("Activity life cycle", " onResume")
    }

    // Appelée lorsque l'activité entre dans l'état Paused. Cette méthode est le pendant de la méthode onResume() :
    // tout ce qui est initié dans onResume() doit être mis en pause dans cette méthode.
    override fun onPause() {
        super.onPause()
        Log.d("Activity life cycle", " onPause")
    }

    // Appelée lorsque l'activité entre dans l'état Stopped. Par exemple, lorsqu'une nouvelle activité est démarrée,
    // l'activité appelante va se retrouver dans cet état. Elle n'est donc plus visible à l'utilisateur. Les traitements liés à la mise à jour de l'interface graphique peuvent être arrêtés.
    override fun onStop() {
        super.onStop()
        Log.d("Activity life cycle", " onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Activity life cycle", " onRestart")
    }

    // Appelée lorsque l'activité est arrêtée. Par exemple, ce peut être après avoir appelée la méthode finish(),
    // ou si le système décide d'arrêter l'activité pour libérer de la mémoire.
    override fun onDestroy() {
        super.onDestroy()
        Log.d("Activity life cycle", " onDestroy")
    }

    private fun setupListenner() {
        btn_go_to_next_activity.setOnClickListener {
            changeActivity()
        }
    }

    private fun loadDataBundle() {
        val b = intent.extras
        if (b != null)
            value = b.getString("key")
    }

    private fun changeActivity(){
        val intent = Intent(this@MainActivity, OtherActivity::class.java)
        val b = Bundle()
        b.putString("key", "test MainActivity")
        intent.putExtras(b)
        startActivity(intent)
        finish()
    }
}
