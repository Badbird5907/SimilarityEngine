plugins {
    id("java")
    id("io.freefair.lombok") version "8.4"
}

group = "dev.badbird"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("net.ricecode:string-similarity:1.0.0")
    implementation("dev.badbird.simhash:Simhash:1.0-SNAPSHOT")
    implementation("com.google.guava:guava:33.0.0-jre")
}

tasks.test {
    useJUnitPlatform()
}