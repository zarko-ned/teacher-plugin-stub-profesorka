plugins {
    id("java")
    `maven-publish`
}
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
group = "com.github.zarko-ned"
version = "1.0.0"

repositories {
    mavenCentral()
}


dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation("org.springframework:spring-web:6.1.6")
    //implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.16.2")
    implementation("jakarta.annotation:jakarta.annotation-api:2.1.1")
    implementation("jakarta.activation:jakarta.activation-api:2.1.1")
    implementation("jakarta.xml.bind:jakarta.xml.bind-api:3.0.1")

    implementation("org.eclipse.jgit:org.eclipse.jgit:6.7.0.202309050840-r")
    implementation("org.zeroturnaround:zt-zip:1.17")
}

tasks.test {
    useJUnitPlatform()
}


publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}
