pipeline {
    agent any

    tools {
        maven 'M3'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/cvelasquezm/ProductModel/blob/master/Jenkinsfile'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn -B package'
            }
        }
    }
}