plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    //dependency for Apache Commons Library
    implementation("org.apache.commons:commons-math3:3.6.1")
    //dependency for jfreechart
    implementation("org.jfree:jfreechart:1.5.5")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}