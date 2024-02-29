plugin {

   // id 'application'// Apply the application plugin to add support for building a CLI application in Java.
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {

    implementation 'org.openjfx:javafx-controls:16' 
    implementation 'org.openjfx:javafx-media:16'
     // Dipendenza per JavaFX Media


    // Use JUnit Jupiter for testing.
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.1")

    // This dependency is used by the application.
    implementation("com.google.guava:guava:31.1-jre")
    implementation("com.googlecode.json-simple:json-simple:1.1")
    implementation("uk.co.caprica:vlcj:4.8.0")
     implementation 'org.json:json:20210307'
}

application {
    // Define the main class for the application.
    mainClass.set("com.meteoapp2.AppLauncher")
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
