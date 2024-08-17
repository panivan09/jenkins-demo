
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


        //stage('SSH-agent') {
        //    steps {
        //        powershell """
        //            Start-Process ssh-agent -NoNewWindow -Wait
        //            ssh-add C:\\Users\\pante\\.ssh\\id_rsa
        //        """
        //    }
        //}


        stage('Test SSH Connection') {
            steps {
                // Параметр -o StrictHostKeyChecking=no отключает проверку ключа хоста, что предотвращает проблемы при первом подключении
                bat """
                    ssh -i C:\\test-ssh\\id_rsa panivan09@192.168.1.81 uname -a
                """
            }
        }


        //stage("Deploy") {
        //    steps {
        //        echo 'Deploying to Raspberry Pi...'
        //        // Копирование файла на Raspberry Pi
        //        bat """
        //            scp -v target/jenkins-demo-0.0.1-SNAPSHOT.jar panivan09@raspberry.local:/home/panivan09/deployments/jenkins-demo-0.0.1-SNAPSHOT.jar
        //        """
//
        //        // Запуск приложения на Raspberry Pi
        //        bat """
        //            ssh panivan09@raspberry.local 'nohup java -jar /home/panivan09/deployments/jenkins-demo-0.0.1-SNAPSHOT.jar > /home/panivan09/deployments/jenkins-demo-app.log 2>&1 &'
        //        """
        //    }
        //}
    }
}