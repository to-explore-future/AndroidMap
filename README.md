# AndroidMap
关于android的所有知识，都容纳到这个仓库中，随着我的知识领域的扩张，这个项目也会越来越完善。

本Module依赖ButterKnife,ButterKnife需要在项目的**Build.gradle**中添加配置，不过我没上传，所以需要你自己添加
```java
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:2.3.3'
        //本注释的下面一行添加到指定位置，重新编译
        classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8'
    }
}
```
