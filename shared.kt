import jetbrains.buildServer.configs.kotlin.v2019_2.VcsRoot
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script

fun createDeployBuildConfiguration(vcRoot: VcsRoot): BuildType {
    return BuildType {
        id("deploy_" + vcRoot.id)
        name = "Deploy"
        type = BuildTypeSettings.Type.DEPLOYMENT

        vcs {
            root(vcRoot)
        }

        triggers {
            vcs {
            }
        }

        steps {
            script {
                name = "Run Deployment"
                scriptContent = """
                    echo "Deploying!"
                """.trimIndent()
            }
        }
    }
}