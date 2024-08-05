plugins {
    id("java")
    //setup Gradle Versions Plugin
    id("se.patrikerdes.use-latest-versions") version "0.2.18"
    id("com.github.ben-manes.versions") version "0.51.0"
    //setup entry point in our App
    id("application")
    //use the Checkstyle plugin
    checkstyle
    //use JaCoCo plugin
    jacoco
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

//setup entry point in our App
application {
    mainClass = "hexlet.code.App"
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.11.0-RC1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
//для интерактивнного ввода в консоль Gradle
tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}