pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://files.minecraftforge.net/maven/")
    }
}

if (file("patched-cloud").exists()) {
    includeBuild("patched-cloud")
}

rootProject.name = "cloudnet-cloud-command-fork"
