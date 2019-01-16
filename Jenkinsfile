pipeline {
    agent any

    tools {
        maven 'M3'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/cvelasquezm/ProductModel.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn -B package'
            }
        }
    }
}
