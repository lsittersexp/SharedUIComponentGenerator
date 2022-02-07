package com.github.lsittersexp.shareduicomponentgenerator.services

import com.intellij.openapi.project.Project
import com.github.lsittersexp.shareduicomponentgenerator.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
