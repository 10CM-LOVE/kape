plugins {
    kotlin("jvm") version "1.6.21"
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    repositories {
        maven("https://papermc.io/repo/repository/maven-public/")
    }

    dependencies {
        implementation(kotlin("stdlib"))
        compileOnly("io.papermc.paper:paper-api:1.19-R0.1-SNAPSHOT")
    }
}