package com.github.droidpl.android.lfolding.tasks

import com.android.build.gradle.api.BaseVariant
import org.gradle.api.DefaultTask
import org.gradle.api.Project
import org.gradle.api.tasks.TaskAction

public class UnfoldTask extends DefaultTask {

    private BaseVariant taskVariant

    public void taskVariant(BaseVariant variant){
        taskVariant = variant
    }

    @TaskAction
    public void runTask() {
        if (!taskVariant.getBuildType() != null) {
            addFolder(getProject(), "src/${taskVariant.getBuildType().getName()}/res/layout")
        }
        if (!taskVariant.getFlavorName().isEmpty()) {
            addFolder(getProject(), "src/${taskVariant.getFlavorName()}/res/layout")
        }
        addFolder(getProject(), "src/${taskVariant.getName()}/res/layout", "")
    }

    public static void addFolder(Project project, String variantName){
        addFolder(project, variantName, "")
    }

    public static void addFolder(Project project, String variantName, String subdir){
        String dirName = "src/${variantName}/res/layout$subdir"
        try {
            project.file(dirName).eachDir {dir ->
                String newSubdir = "$dirName/$dir.name"
                project.android.sourceSets[variantName].res.srcDirs += newSubdir
                addFolder(project, variantName, newSubdir)
            }
        } catch(FileNotFoundException ignored){
            //Skip
        }
    }
}