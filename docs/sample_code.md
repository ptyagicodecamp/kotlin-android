# Example Android Kotlin Programs

# Activity
```
class KotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
    }
}
```
[Checkout source code in Github](https://github.com/ptyagicodecamp/kotlin-android/blob/develop/app/src/main/java/org/pcc/kotlinandroid/samples/KotlinActivity.kt#L7-L13)


# Starting another Activity from an Activity in Kotlin
```
//starting KotlinActivity from MainActivity
var anotherActivity = Intent(this@MainActivity, KotlinActivity::class.java)
startActivity(anotherActivity)
```

# Activity3
```
class KotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
    }
}
```
