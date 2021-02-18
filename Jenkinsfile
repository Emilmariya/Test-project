pipeline{
    agent any
    environment{
        PATH = "/Newstrykerproject/pom.xml:$PATH"
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
          
