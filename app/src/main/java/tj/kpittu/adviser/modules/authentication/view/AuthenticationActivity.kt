package tj.kpittu.adviser.modules.authentication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import tj.kpittu.adviser.R

class AuthenticationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)
        supportFragmentManager.beginTransaction().replace(R.id.container,LoginFragment()).commit()


    }
}