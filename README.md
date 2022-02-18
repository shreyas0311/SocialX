# Add the following dependencies

dependencies {

    implementation 'androidx.appcompat:appcompat:1.4.1'
    implementation 'com.google.android.material:material:1.5.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.3' //used in layout creation
    testImplementation 'junit:junit:'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
    implementation 'com.squareup.retrofit2:retrofit:2.9.0' // connects HTTPS request into Java Interface
    implementation 'com.github.bumptech.glide:glide:4.12.0' //helps in setting of image
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0' // parses HTTPS requests into Object 
    implementation 'com.google.android.gms:play-services-auth:20.0.1' //used for google sign in authentication
}

# Colours used - #FF0303,#003E83,#E9040E
