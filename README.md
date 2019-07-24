# SpiderAd-SDK

SDK android for publish advertising from SpiderAd  

 ## Installation

 Add it in your root build.gradle at the end of repositories:

```json
allprojects {        
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
 Add the dependency

```json
dependencies {
    ...
    implementation 'com.github.spider-ad:SpiderAd-SDK-Android:0.1.1'
}
```
 
## Usage
 Add afiiliate id in AndroidManifest.xml

```xml
<meta-data
    android:name="com.spider.ad.sdk.AdView.AFFILIATE_ID"
    android:value="9999"/>
```
    
Insert layout in activity for publish advertising

 - Banner 300X50
     
```xml
<LinearLayout
    android:id="@+id/adview"
    android:layout_width="300dp"
    android:layout_height="50dp"
    android:layout_alignParentBottom="true"
    android:orientation="horizontal"
    android:layout_centerInParent="true"></LinearLayout>         
```
    
Add code in onCreate function from activity 

```kotlin
val adContainer = findViewById(R.id.adview) as LinearLayout

val adview = AdView(this, adContainer, "divSpdStandardBanner")
adview.initialize()
```

##Support

Send email to devteam@spider.ad

## License
[MIT](https://choosealicense.com/licenses/mit/)