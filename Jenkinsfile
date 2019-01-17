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
				bat 'mvn install:install-file -Dfile=D:/productmodel/build'
            }
        }
		
		stage('Deploy') {
            steps {                
				bat 'echo "hola mundo"'
            }
        }
    }
}
