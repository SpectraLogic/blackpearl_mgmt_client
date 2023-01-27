/*
 * ****************************************************************************
 *   Copyright 2023 Spectra Logic Corporation. All Rights Reserved.
 *   Licensed under the Apache License, Version 2.0 (the "License"). You may not use
 *   this file except in compliance with the License. A copy of the License is located at
 *   http://www.apache.org/licenses/LICENSE-2.0
 *   or in the "license" file accompanying this file.
 *   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 *   CONDITIONS OF ANY KIND, either express or implied. See the License for the
 *   specific language governing permissions and limitations under the License.
 * **************************************************************************
 */

rootProject.name = "blackpearl-mgmt-client"

include("bp-mgmt-client")
include("integration")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
    versionCatalogs {
        create("libs") {
            version("assert4j", "3.24.2")
            version("hamcrest", "1.3")
            version("jackson", "2.14.1")
            version("junit-jupiter", "5.9.2")
            version("junit", "4.13.2")
            version("okhttp", "4.10.0")
            version("okio-jvm", "3.3.0")
            version("reactivex", "3.1.6")
            version("retrofit", "2.9.0")
            version("slf4j", "1.7.36")

            library("jacksonBom", "com.fasterxml.jackson", "jackson-bom").versionRef("jackson")
            library("okhttp", "com.squareup.okhttp3", "okhttp").versionRef("okhttp")
            library("okioJvm", "com.squareup.okio", "okio-jvm").versionRef("okio-jvm")
            library("reactivexRxjava", "io.reactivex.rxjava3", "rxjava").versionRef("reactivex")
            library("retrofit", "com.squareup.retrofit2", "retrofit").versionRef("retrofit")
            library("retrofitConverterJackson", "com.squareup.retrofit2", "converter-jackson").versionRef("retrofit")
            library("retrofitAdapterRxjava2", "com.squareup.retrofit2", "adapter-rxjava2").versionRef("retrofit")
            library("slf4jApi", "org.slf4j", "slf4j-api").versionRef("slf4j")

            // test only libraries
            library("assertjCore", "org.assertj", "assertj-core").versionRef("assert4j")
            library("hamcrestLibrary", "org.hamcrest", "hamcrest-library").versionRef("hamcrest")
            library("junit", "junit", "junit").versionRef("junit")
            library("junitJupiterApi", "org.junit.jupiter", "junit-jupiter-api").versionRef("junit-jupiter")
            library("junitVintageEngine", "org.junit.vintage", "junit-vintage-engine").versionRef("junit-jupiter")
            library("slf4jSimple", "org.slf4j", "slf4j-simple").versionRef("slf4j")

            // gradle plugins
            plugin("owaspDepCheck","org.owasp.dependencycheck").version("8.0.1")
            plugin("versions", "com.github.ben-manes.versions").version("0.44.0")
        }
    }
}