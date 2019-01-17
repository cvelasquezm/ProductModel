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
                bat 'cd D:\productmodel\build'
				bat 'mvn clean install'
            }
        }
    }
}
