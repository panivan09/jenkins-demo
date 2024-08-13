pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Используйте Maven для сборки проекта
                sh 'mvn clean install'
            }
        }
    }
}