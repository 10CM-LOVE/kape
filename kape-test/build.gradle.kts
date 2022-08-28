plugins {
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

dependencies {
    api(project(":${rootProject.properties.getValue("smallName")}-core"))
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "17"
    }

    shadowJar {
        archiveBaseName.set(project.name)
        archiveClassifier.set("")
        archiveVersion.set("")
    }
}