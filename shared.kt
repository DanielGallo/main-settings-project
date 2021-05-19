import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs

fun createDeployBuildConfiguration(vcRoot: GitVcsRoot): BuildType {
    val deploy = BuildType {
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

    return deploy
}