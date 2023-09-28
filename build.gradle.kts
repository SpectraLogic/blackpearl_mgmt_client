/*
 * ****************************************************************************
 *   Copyright 2016-2023 Spectra Logic Corporation. All Rights Reserved.
 *   Licensed under the Apache License, Version 2.0 (the "License"). You may not use
 *   this file except in compliance with the License. A copy of the License is located at
 *   http://www.apache.org/licenses/LICENSE-2.0
 *   or in the "license" file accompanying this file.
 *   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 *   CONDITIONS OF ANY KIND, either express or implied. See the License for the
 *   specific language governing permissions and limitations under the License.
 * **************************************************************************
 */

plugins {
    `java-library`
    `maven-publish`
    alias(libs.plugins.owaspDepCheck)
    alias(libs.plugins.versions)
}

group = "com.spectralogic.ds3"
version = "4.1.3-SNAPSHOT"

dependencies {
    // handle transitive jackson deps
    implementation(platform(libs.jacksonBom))

    implementation(libs.okhttp)
    implementation(libs.okioJvm)
    implementation(libs.reactivexRxjava)
    implementation(libs.retrofit)
    implementation(libs.retrofitConverterJackson)
    implementation(libs.retrofitAdapterRxjava2)
    implementation(libs.slf4jApi)

    testImplementation(libs.assertjCore)
    testImplementation(libs.junit)
    testImplementation(libs.junitJupiterApi)
    testImplementation(libs.reactivexRxjava)
    testImplementation(libs.slf4jSimple)

    testRuntimeOnly(libs.junitVintageEngine)
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
    withJavadocJar()
    withSourcesJar()
}

val integrationTest by sourceSets.creating
integrationTest.compileClasspath += sourceSets.main.get().output
integrationTest.runtimeClasspath += sourceSets.main.get().output
configurations[integrationTest.implementationConfigurationName].extendsFrom(configurations.testImplementation.get())
configurations[integrationTest.runtimeOnlyConfigurationName].extendsFrom(configurations.testRuntimeOnly.get())

val integrationTestTask = tasks.register<Test>("integrationTest") {
    description = "Runs integration tests."
    group = "verification"

    testClassesDirs = integrationTest.output.classesDirs
    classpath = configurations[integrationTest.runtimeClasspathConfigurationName] + integrationTest.output

    shouldRunAfter(tasks.test)
    useJUnitPlatform()
}

tasks.check {
    dependsOn(integrationTestTask)
}

dependencyCheck {
    // fail the build if any vulnerable dependencies are identified (CVSS score > 0)
    failBuildOnCVSS = 0f;
}

publishing {
    repositories {
        maven {
            name = "internal"
            val releasesRepoUrl = "https://artifacts.eng.sldomain.com/repository/spectra-releases/"
            val snapshotsRepoUrl = "https://artifacts.eng.sldomain.com/repository/spectra-snapshots/"
            url = uri(if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl)
            credentials {
                username = extra.has("artifactsUsername").let {
                    if (it) extra.get("artifactsUsername") as String else null
                }
                password = extra.has("artifactsPassword").let {
                    if (it) extra.get("artifactsPassword") as String else null
                }
            }
        }
    }
    publications {
        create<MavenPublication>(project.name) {
            from(components["java"])
        }
    }
}

tasks.register("publishToInternalRepository") {
    group = "publishing"
    description = "Publishes all Maven publications to the internal Maven repository."
    dependsOn(tasks.withType<PublishToMavenRepository>().matching {
        it.repository == publishing.repositories["internal"]
    })
}

publishing.publications.filterIsInstance<MavenPublication>().forEach { pub ->
    pub.pom {
        name.set("${project.group}:${project.name}")
        url.set("https://github.com/SpectraLogic/blackpearl_mgmt_client")
        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        developers {
            developer {
                name.set("Spectra Logic Developers")
                email.set("developer@spectralogic.com")
                organization.set("Spectra Logic")
                organizationUrl.set("https://spectralogic.com/")
            }
        }
        scm {
            connection.set("scm:git:https://github.com/SpectraLogic/blackpearl_mgmt_client.git")
            developerConnection.set("scm:git:https://github.com/SpectraLogic/blackpearl_mgmt_client.git")
            url.set("https://github.com/SpectraLogic/blackpearl_mgmt_client")
        }
    }
}

tasks.wrapper {
    // to upgrade the gradle wrapper, bump the version below and run ./gradlew wrapper twice
    gradleVersion = "8.3"
}