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

// bug in IntelliJ in which `libs` shows up as not being accessible
// see https://youtrack.jetbrains.com/issue/KTIJ-19369
@Suppress("DSL_SCOPE_VIOLATION")
plugins{
    `java-library`
    `publish-common`
    alias(libs.plugins.owaspDepCheck)
}

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
}

dependencyCheck {
    // fail the build if any vulnerable dependencies are identified (CVSS score > 0)
    failBuildOnCVSS = 0f;
}