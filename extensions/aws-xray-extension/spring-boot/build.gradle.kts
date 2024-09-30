
description = "Extension for integration AWS Xray Tracing into the Message Listeners in a Spring Boot Application"

val springBootVersion: String by project

configurations.all {
    resolutionStrategy.eachDependency {
        if (requested.group.startsWith("com.fasterxml.jackson")) {
            // 2.17.2 is incompatible but needed by other subprojects
            useVersion("2.15.2")
        }
    }
}

dependencies {
    implementation(platform("org.springframework.boot:spring-boot-dependencies:$springBootVersion"))

    api(project(":aws-xray-extension-core"))
    implementation("org.springframework:spring-context")
    implementation("org.springframework.boot:spring-boot-autoconfigure")
    implementation(project(":java-dynamic-sqs-listener-spring-core"))

    testImplementation("org.checkerframework:checker-qual:3.7.1")
    testImplementation("org.springframework:spring-test")
    testImplementation("org.springframework.boot:spring-boot-test")
    testImplementation(project(":elasticmq-sqs-client"))
}
