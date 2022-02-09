package other.templates.recipes

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.addAllKotlinDependencies
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest
import other.templates.someActivity
import other.templates.someActivityLayout

fun RecipeExecutor.mvpActivitySetup(
    moduleData: ModuleTemplateData,
    packageName: String,
    entityName: String,
    layoutName: String
) {
    val (projectData, srcOut, resOut) = moduleData

    addAllKotlinDependencies(moduleData)

    val activityClass = "${entityName}sActivity"
    val activityTitle = "$entityName Activity"
    // This will generate new manifest (with activity) to merge it with existing
//    generateManifest(
//        moduleData = moduleData,
//        activityClass = activityClass,
//        activityTitle = activityTitle,
//        packageName = packageName,
//        isLauncher = false,
//        hasNoActionBar = true,
//        generateActivityTitle = true,
//        requireTheme = false,
//        useMaterial2 = true
//    )

    save(
        someActivity(packageName, entityName, layoutName, projectData),
        srcOut.resolve("$activityClass.kt"),
        true
    )
    save(
        someActivityLayout(packageName, entityName),
        resOut.resolve("layout/$layoutName.xml")
    )
}
