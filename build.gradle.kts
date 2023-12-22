plugins {
    id("java")
    id("io.freefair.lombok") version "8.4"
}

group = "dev.badbird"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("net.ricecode:string-similarity:1.0.0")
}

tasks.test {
    useJUnitPlatform()
}