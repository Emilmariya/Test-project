pipeline { 
    agent any

    stages {
        stage('Build') {
            
            steps {
                git url:'https://github.com/Emilmariya/Test-project.git'
                echo 'Building..'
                bat "mvn clean"
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                bat "mvn test"
            }
        }
        stage('compile') {
            steps {
                echo 'compile..'
                
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
