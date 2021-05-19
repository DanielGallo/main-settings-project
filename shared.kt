fun createDeployBuildConfiguration(vcs: GitVcsRoot): BuildType {
    val deploy = BuildType {
        id("deploy_" + vcs.id)
        name = "Deploy"
        type = BuildTypeSettings.Type.DEPLOYMENT

        vcsRoot(vcs)

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