Black Pearl Management Client
=============================

## Install 
 
To add the client to an existing maven/gradle project include the following into your build files.

### Maven
 
Add the following to your `maven.pom` file
 
```xml

<project>
  ...
    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>
  ...
    <dependencies>
      ...
        <dependency>
            <groupId>com.github.spectralogic</groupId>
            <artifactId>blackpearl_mgmt_client</artifactId>
            <version>4.1.1</version>
        </dependency>
    ...  
    </dependencies>
</project>

```

### Gradle

To include the client into Gradle include the following in the `build.gradle` file:

```groovy

allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}

dependencies {
    implementation 'com.github.spectralogic:blackpearl_mgmt_client:4.1.1'
}

```

## Usage

Create a client instance with `BlackPearlManagementService.getInstance()`

