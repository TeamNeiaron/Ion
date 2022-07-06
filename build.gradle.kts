import java.io.ByteArrayOutputStream

version = "1.0"
plugins {
    kotlin("jvm") version "1.7.0"
}

val mindustryVersion = "v130"
repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

sourceSets {
    main {
        java.srcDirs("src")
    }
    test {
        java.srcDir("test")
    }
}

dependencies {
    compileOnly("com.github.Anuken.Arc:arc-core:master-SNAPSHOT")
    compileOnly("com.github.Anuken.MindustryJitpack:core:13cf282470")
    implementation(files("libs/mnemotechnician/MKUI.jar"))
    // implementation("com.github.mnemotechnician:mkui:33") use this instead
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.register("jarAndroid") {
    group = "build"
    dependsOn("jar")

    doLast {
        val sdkRoot = System.getenv("ANDROID_HOME") ?: System.getenv("ANDROID_SDK_ROOT")
        if (sdkRoot == null || !File(sdkRoot).exists())
            throw GradleException("No valid Android SDK found. Ensure that ANDROID_HOME is set to your Android SDK directory.")
        val platformRoot = File("$sdkRoot/platforms/").listFiles()!!.sorted().reversed()
            .find { f -> File(f, "android.jar").exists() }
            ?: throw GradleException("No android.jar found. Ensure that you have an Android platform installed.")
        //collect dependencies needed for desugaring
        val allDependencies = configurations.compileClasspath.get().toList() +
                configurations.runtimeClasspath.get().toList() +
                listOf(File(platformRoot, "android.jar"))
        val dependencies = allDependencies.joinToString(" ") { "--classpath ${it.path}" }
        //dex and desugar files - this requires d8 in your PATH
        val paras = "$dependencies --min-api 14 --output ${project.name}Android.jar ${project.name}Desktop.jar"
        try {
            exec {
                commandLine = "d8 $paras".split(' ')
                workingDir = File("$buildDir/libs")
                standardOutput = System.out
                errorOutput = System.err
            }
        } catch (_: Exception) {
            val cmdOutput = ByteArrayOutputStream()
            logger.lifecycle("d8 cannot be found in your PATH, so trying to use an absolute path.")
            exec {
                commandLine = listOf("where", "d8")
                standardOutput = cmdOutput
                errorOutput = System.err
            }
            val d8FullPath = cmdOutput.toString().replace("\r", "").replace("\n", "")
            exec {
                commandLine = "$d8FullPath $paras".split(' ')
                workingDir = File("$buildDir/libs")
                standardOutput = System.out
                errorOutput = System.err
            }
        }
    }
}

tasks.jar {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    archiveFileName.set("${project.name}Desktop.jar")

    from(*configurations.runtimeClasspath.get().files.map { if (it.isDirectory) it else zipTree(it) }.toTypedArray())

    from(rootDir) {
        include("mod.hjson")
        include("icon.png")
    }

    from("../assets/") {
        include("**")
    }
}
task<Jar>("deploy") {
    dependsOn("jarAndroid")
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    archiveFileName.set("${project.name}.jar")
    from(
        zipTree("$buildDir/libs/${project.name}Desktop.jar"),
        zipTree("$buildDir/libs/${project.name}Android.jar")
    )
    doLast {
        delete { delete("$buildDir/libs/${project.name}Desktop.jar") }
        delete { delete("$buildDir/libs/${project.name}Android.jar") }
    }
}
