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
         sh "mvn clean install"
        }
    }
    }
}
          
