plugins {
    id("application")
    id("java")
}

repositories {
    mavenCentral()
}


dependencies {
    implementation("com.googlecode.json-simple:json-simple:1.1")
    implementation("org.openjfx:javafx-controls:16")
    implementation("org.openjfx:javafx-media:16")
    implementation("org.json:json:20210307")
    testImplementation("junit:junit:4.12")
    
}

sourceSets {
    main {
        resources {
            srcDirs("src/main/resources/assets")
        }
}
}
tasks {
    withType<JavaCompile>().configureEach { options.encoding = "UTF-8" }
    withType<JavaExec>().configureEach { defaultCharacterEncoding = "UTF-8" }
    withType<Javadoc>().configureEach { options.encoding = "UTF-8" }
    withType<Test>().configureEach { defaultCharacterEncoding = "UTF-8" }
}
application {
    mainClass.set("com.meteoapp2.Interfaccia")
}


   