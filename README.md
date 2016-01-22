# Android Layout Folding

![Android plugin](https://img.shields.io/badge/Android%20plugin-active-green.svg)
![Gradle](https://img.shields.io/badge/Gradle-compatible-brightgreen.svg)
[ ![Download](https://api.bintray.com/packages/droidpl/maven/AndroidLayoutFolding/images/download.svg) ](https://bintray.com/droidpl/maven/AndroidLayoutFolding/_latestVersion)

Gradle plugin for Android that allows a project to define folders inside the layout directory. Basically
it uses the normal merging mechanism that the android plugin uses by itself, declaring 
the folders recursively as resources directory.

Take the following structure as an example:
```
src/main/res/layout/
    myLayout.xml
    activities/layout/
        activity1.xml
        activity2.xml
src/debug/res/layout/
    activities/layout/
        activity1.xml
```

As you may notice it also supports different build variants, flavours and dimensions.

# Instructions
Add the plugin to the classpath of your root build.gradle:
```groovy
buildscript {
    dependencies {
        classpath 'com.github.droidpl:lfolding:1.0'
    }
}
```

Apply this plugin to the build.gradle your project:
```groovy
apply plugin: "lfolding"
```

This will enable the behaviour automatically.

# License
```
The MIT License (MIT)
Copyright (c) 2016 Javier de Pedro López

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
```