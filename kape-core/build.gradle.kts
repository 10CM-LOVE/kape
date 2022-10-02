plugins {
    kotlin("jvm") version "1.6.21"
    id("org.jetbrains.dokka") version "1.6.21"
    `maven-publish`
    signing
}

tasks {
    javadoc {
        options.encoding = "UTF-8"
    }

    create<Jar>("sourcesJar") {
        archiveClassifier.set("sources")
        from(sourceSets["main"].allSource)
    }

    create<Jar>("javadocJar") {
        archiveClassifier.set("javadoc")
        dependsOn("dokkaHtml")
        from("$buildDir/dokka/html")
    }
}

publishing {
    publications {
        create<MavenPublication>(project.name) {
            from(components["java"])
            artifact(tasks["sourcesJar"])
            artifact(tasks["javadocJar"])
        }
    }
}