import org.jetbrains.kotlin.cli.jvm.compiler.getSourceRootsCheckingForDuplicates
import org.jetbrains.kotlin.js.inline.clean.removeDuplicateImports

plugins {
    kotlin("jvm") version "2.0.20"
}

group = "com.huang"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    implementation("com.alibaba", "fastjson", "2.0.52")

    implementation(files("D:\\Projects\\idea\\PluginDemoCollection\\libs\\coolrequest-tool.jar"))
}

//此配置用于将第三方依赖同项目打包成jar
tasks.withType<Jar> {
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(8)
}