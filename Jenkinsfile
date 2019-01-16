pipeline {
    agent any

    tools {
        maven 'M3'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/triologygmbh/jenkinsfile'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn -B package'
            }
        }
    }
}