
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

                echo 'Stopping existing service...'
                bat 'sc stop JenkinsDemoService || echo Service not running || exit 0'

                echo 'Copying new jar...'
                bat 'copy target\\jenkins-demo-0.0.1-SNAPSHOT.jar D:\\Workspace\\Jenkins\\deployments\\jenkins-demo-0.0.1-SNAPSHOT.jar'

                echo 'Starting service...'
                bat 'sc start JenkinsDemoService'
            }
        }
    }
}