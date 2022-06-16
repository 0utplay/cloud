import net.minecrell.gitpatcher.PatchExtension

plugins {
    id("net.minecraftforge.gitpatcher") version "0.10.+"
}

configure<PatchExtension> {
    submodule = "cloud"
    patches = file("patches")
    target = file("patched-cloud")
}

tasks.register("rebuildPatches") {
    dependsOn(tasks.makePatches)
}