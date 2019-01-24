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
				//bat 'mvn install:install-file -Dfile=D:/productmodel/build'
				bat 'mvn clean install'
            }
        }
		
	stage('Deploy') {
            steps {                
				bat 'java -jar C:/Users/cesavemr/.m2/repository/com/sura/productmodel/0.0.1-SNAPSHOT/productmodel-0.0.1-SNAPSHOT.jar'
            }
        }
    }
}
