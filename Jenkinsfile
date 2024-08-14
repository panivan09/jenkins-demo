
pipeline {
    agent any;

    stages {
        stage("Build") {
            steps {
                echo 'Building...'
                bat """
                    mvn clean install -DskipTests=true
                """
            }
        }
        stage("Test") {
            steps {
                echo 'Testing...'
                bat """
                    mvn test -Dsurefire.useFile=false
                """
            }
        }

        stage("Deploy") {
            steps {
                echo 'Deploying...'

                // Копирование артефакта в целевую директорию
                bat """
                    copy target\\jenkins-demo-0.0.1-SNAPSHOT.jar D:\\Workspace\\Jenkins\\deployments\\jenkins-demo-0.0.1-SNAPSHOT.jar
                """

                // Запуск приложения
                bat """
                    cd D:\\Workspace\\Jenkins\\deployments
                    start java -jar D:\\Workspace\\Jenkins\\deployments\\jenkins-demo-0.0.1-SNAPSHOT.jar
                """
            }
        }
    }
}