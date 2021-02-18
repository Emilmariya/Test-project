pipeline{
    agent any
    environment{
        PATH = "/Newstrykerproject/pom.xml:$PATH"
    }
    stages{
    stage('ScM Checkout'){
     git credentialsId: 'git_credentials', url:'https://github.com/Emilmariya/Test-project.git'
    }
    stage('Compile-Package'){
         sh "mvn clean install"
    }
    }
}
          
