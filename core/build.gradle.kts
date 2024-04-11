version = "0.1.0"

plugins {
    id("java-library")
}

dependencies {
    api(project(":api"))

    addon("labyswaypoints", true, "net.labymod.addons:waypoints:1.0.0")
}

labyModProcessor {
    referenceType = net.labymod.gradle.core.processor.ReferenceType.DEFAULT
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}