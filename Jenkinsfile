
pipeline {
	agent any
	
	stages {
		stage('Git Checkout') {
			steps {
				git credentialsId: 'git_credentials', url:''
			}
	}

    
      
    stage ('Maven Build'){
			steps{
			script {
				def rtMaven = Artifactory.newMavenBuild()
				rtMaven.tool = 'Maven'
                def buildInfo = rtMaven.run pom: './TestAutomation/Code/stryker/pom.xml', goals: 'clean install'
}
}
}

   
}
 }   
    
