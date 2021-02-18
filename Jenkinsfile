node{
    stage('ScM Checkout'){
     git 'https://github.com/Emilmariya/Test-project.git'
    }
    stage('Compile-Package'){
         def mvnHome =  tool name: 'Maven 3.6', type: 'maven'
         sh "${mvnHome}/bin/mvn package"
    }
}
          
