
pipeline {
    agent any;

    environment {
        // Указываем путь к SSH ключу
        SSH_KEY_PATH = 'C:\\Users\\pante\\.ssh\\id_rsa'
        //SSH_KEY_PATH = 'C:\\test-ssh\\id_rsa'
    }

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


       //stage('Test SSH Connection') {
       //    steps {
       //        // Параметр -o StrictHostKeyChecking=no отключает проверку ключа хоста, что предотвращает проблемы при первом подключении
       //        bat """
       //            ssh -i C:\\test-ssh\\id_rsa panivan09@192.168.1.81 uname -a
       //        """
       //    }
       //}


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



        stage('Setup SSH Connection') {
            steps {
                script {
                    // Настройка удалённого сервера
                    def remote = [:]
                    remote.name = 'Raspberry Pi'
                    remote.host = '192.168.1.81'
                    remote.user = 'panivan09'
                    remote.identityFile = SSH_KEY_PATH
                    remote.allowAnyHosts = true

                    // Тест SSH подключения
                    sshCommand remote: remote, command: 'uname -a'
                }
            }
        }
    }
}