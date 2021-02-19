pipeline{
    agent any
    environment{
        PATH = "/opt/Maven 3.6/bin:$PATH"
    }
    stages{
    stage('ScM Checkout'){
        steps{
            git credentialsId: 'git_credentials', url:'https://github.com/Emilmariya/Test-project.git'
        }
    }
    stage('Clean install'){
        steps{
         script {
				def rtMaven = Artifactory.newMavenBuild()
				rtMaven.tool = 'Maven'
                def buildInfo = rtMaven.run pom: './Newstrykerproject/pom.xml', goals: 'clean install'
}
        }
    }
    }
}
          
