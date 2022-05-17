-keep class androidx.appcompat.widget.** { *; }

-keep class androidx.fragment.app.Fragment { *; }

-keep class io.plaidapp.data.api.dribbble.model.** { *; }

-keepattributes LocalVariableTable, LocalVariableTypeTable

-keepattributes *Annotation*, Signature, Exception

#### -- Picasso --
 -dontwarn com.squareup.picasso.**

 #### -- OkHttp --
 -dontwarn com.squareup.okhttp.internal.**

 #### -- Apache Commons --
 -dontwarn org.apache.commons.logging.**


# startapp rule

-keep class com.startapp.** {
      *;
}
-keep class com.truenet.** {
      *;
}

-keepattributes Exceptions, InnerClasses, Signature, Deprecated, SourceFile,LineNumberTable, *Annotation*, EnclosingMethod
-dontwarn android.webkit.JavascriptInterface
-dontwarn com.startapp.**

-ignorewarnings