# SpiderAd-SDK

SDK android for publish advertising from SpiderAd  

 ## Installation

 Add it in your root build.gradle at the end of repositories:

```
allprojects {        
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
 Add the dependency

```
dependencies {
    ...
    implementation 'com.github.spider-ad:SpiderAd-SDK-Android:0.1.1'
}
```
 
## Usage
 Add affiliate id in AndroidManifest.xml

```xml
<meta-data
    android:name="com.spider.ad.sdk.AdView.AFFILIATE_ID"
    android:value="9999"/>
```
 - OBS: Affiliate id is your identification on SpiderAd 
    
#### Publish advertising on format 300X50
Insert layout in activity 
     
```xml
<include layout="@layout/spd_standard_banner">
</include>
```
    
Add code in onCreate function from activity 

```kotlin
...
import com.spider.ad.sdk.AdView

...
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    
    // On close button
    val adViewStdBanner = AdView(this, "divSpdStandardBanner")
    adviewStdBanner.initialize()

    // No close button
    val adViewStdBanner = AdView(this, "divSpdStandardBanner", false)
    adviewStdBanner.initialize()    
}
```

#### Publish advertising on format 300X250
Insert layout in activity

```xml
 <include layout="@layout/spd_retangulo">
</include>
```

Add code in onCreate function from activity 

```kotlin
...
import com.spider.ad.sdk.AdView

...
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    
    // On close button
    val adviewRetangulo = AdView(this, "divSpdRetangulo")
    adviewRetangulo.initialize()

    // No close button
    val adviewRetangulo = AdView(this, "divSpdRetangulo", false)
    adviewRetangulo.initialize()
}
```

## Support

Send email to devteam@spider.ad

## License
[MIT](https://choosealicense.com/licenses/mit/)