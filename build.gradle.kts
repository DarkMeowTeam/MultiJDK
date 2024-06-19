plugins {
    kotlin("jvm")
    `java-gradle-plugin`
    `maven-publish`
}

gradlePlugin {
    plugins {
        create("multi-jdk") {
            id = "net.darkmeow.multi-jdk"
            displayName = "multi-jdk"
            description = "Compile for multiple JDKs"
            implementationClass = "net.darkmeow.multijdk.MultiJdkPlugin"
        }
    }
}

group = "net.darkmeow"
version = "1.0"

java {
    withSourcesJar()
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    val kotlinVersion: String by project
    compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
}

tasks {
    compileJava {
        options.encoding = "UTF-8"
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }

    compileKotlin {
        kotlinOptions {
            jvmTarget = "17"
            freeCompilerArgs += listOf(
                "-Xbackend-threads=0"
            )
        }
    }
}