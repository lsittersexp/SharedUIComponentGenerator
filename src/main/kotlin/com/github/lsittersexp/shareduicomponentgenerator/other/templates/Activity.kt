package other.templates

import com.android.tools.idea.wizard.template.*
import other.defaultPackageNameParameter
import other.templates.recipes.mvpActivitySetup

val mvpActivitySetupTemplate
    get() = template {
        name = "Shared UI Component Generator"
        description = "Creates a new activity along layout file."
        minApi = 16
        category = Category.Other
        formFactor = FormFactor.Mobile
        screens = listOf(
            WizardUiContext.FragmentGallery,
            WizardUiContext.MenuEntry,
            WizardUiContext.NewProject,
            WizardUiContext.NewModule
        )

        val packageNameParam = defaultPackageNameParameter
        val entityName = stringParameter {
            name = "Entity Name"
            default = "Spoon"
            help = "It will create `{Entity Name}Activity' and 'activity_{Entity Name}.xml'."
            constraints = listOf(Constraint.NONEMPTY)
        }
        val layoutName = stringParameter {
            name = "Layout Name"
            default = "my_act"
            help = "The name of the layout to create for the activity"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = { "${activityToLayout(entityName.value.toLowerCase())}s" }
        }

        widgets(
            TextFieldWidget(entityName),
            TextFieldWidget(layoutName),
            PackageNameWidget(packageNameParam)
        )

        recipe = { data: TemplateData ->
            mvpActivitySetup(
                data as ModuleTemplateData,
                packageNameParam.value,
                entityName.value,
                layoutName.value
            )
        }
    }


