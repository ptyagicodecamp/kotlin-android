## [Getting started with developing Android apps in Kotlin](https://ptyagicodecamp.github.io/getting-started-with-developing-android-apps-in-kotlin.html)

## Sample code for Kotlin

# Activity
```
class KotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
    }
}
```