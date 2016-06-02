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
      <id>Spectra-Github</id>
      <url>http://dl.bintray.com/spectralogic/ds3</url>
    </repository>
  </repositories>
  ...
    <dependencies>
      ...
      <dependency>
        <groupId>com.spectralogic.ds3</groupId>
        <artifactId>bp-mgmt-client</artifactId>
        <version>1.0.0</version>
      </dependency>
    ...  
    </dependencies>
</project>

```

### Gradle

To include the client into Gradle include the following in the `build.gradle` file:

```groovy

repositories {
    ...
    maven {
        url 'http://dl.bintray.com/spectralogic/ds3'
    }
    ...
}

dependencies {
    ...
    compile 'com.spectralogic.ds3:bp-mgmt-client:1.0.0'
    ...
}

```

## Usage

Create a client instance with `BlackPearlManagementService.getInstance()`

