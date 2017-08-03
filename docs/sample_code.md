# Example Android Kotlin Programs

## Activity
```
class KotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
    }
}
```


## Starting another Activity from an Activity in Kotlin
```
//starting KotlinActivity from MainActivity
var anotherActivity = Intent(this@MainActivity, KotlinActivity::class.java)
startActivity(anotherActivity)
```

## Activity3
```
class KotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
    }
}
```