
pipeline {
	agent any
	
	stages {
		stage('Git Checkout') {
			steps {
				git credentialsId: 'git_credentials', url:'https://github.com/Emilmariya/Test-project.git'
			}
	}

    
      
    stage ('Maven Build'){
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
    
