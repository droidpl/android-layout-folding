package com.github.droidpl.android.lfolding

import com.github.droidpl.android.lfolding.tasks.UnfoldTask
import com.github.droidpl.android.lfolding.utils.Utils
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task

public class LFoldingPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        if(Utils.isAndroidPlugin(project)){
            project.afterEvaluate {
                Utils.getVariants(project).all { variant ->
                    String variantNameCap = variant.getName().capitalize();
                    Task foldingTask = project.tasks.create("unfold${variantNameCap}Resources", UnfoldTask) {
                        taskVariant variant
                    }
                    Task mergeTask = project.tasks.getByName("preBuild")
                    mergeTask?.finalizedBy foldingTask
                }
                //Always add main subfolders
                UnfoldTask.addFolder(project, "main")
            }
        }
    }
}