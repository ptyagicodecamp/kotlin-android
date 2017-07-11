type: doc
layout: reference
category: "Syntax"
title: "Example Android Kotlin Programs"
---

## Activity
```
class KotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
    }
}
```