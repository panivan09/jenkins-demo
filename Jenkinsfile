
pipeline {
    agent any;

    environment {
        // Указываем путь к SSH ключу
        SSH_KEY_PATH = 'C:\\Users\\pante\\.ssh\\id_rsa'
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

        stage("Test") {
            steps {
                echo 'Testing...'
                bat """
                    mvn test -Dsurefire.useFile=false
                """
            }
        }

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

        //stage('Create File on Remote Server') {
        //    steps {
        //        script {
        //            def remote = [:]
        //            remote.name = 'Raspberry Pi'
        //            remote.host = '192.168.1.81'
        //            remote.user = 'panivan09'
        //            remote.identityFile = SSH_KEY_PATH
        //            remote.allowAnyHosts = true
//
        //            // Создание пустого файла на удалённом сервере
        //            sshCommand remote: remote, command: 'touch /home/panivan09/deployments/jenkins-demo-0.0.1-SNAPSHOT.jar'
        //        }
        //    }
        //}


        stage('Check File Existence') {
            steps {
                script {
                    def remote = [:]
                    remote.name = 'Raspberry Pi'
                    remote.host = '192.168.1.81'
                    remote.user = 'panivan09'
                    remote.identityFile = SSH_KEY_PATH
                    remote.allowAnyHosts = true

                    // Проверка существования каталога на удалённом сервере
                    def dirExists = sshCommand remote: remote, command: '[ -d /home/panivan09/deployments ] && echo "Directory exists" || echo "Directory does not exist"'

                    if (!dirExists.contains("Directory exists")) {
                        echo "The directory does not exist on the server. Creating directory..."
                        sshCommand remote: remote, command: 'mkdir -p /home/panivan09/deployments'
                    }

                    // Проверка существования файла на удалённом сервере
                    def fileExists = sshCommand remote: remote, command: '[ -f /home/panivan09/deployments/jenkins-demo-0.0.1-SNAPSHOT.jar ] && echo "File exists" || echo "File does not exist"'

                    // Логика на основе результата
                    if (fileExists.contains("File exists")) {
                        echo "The file exists on the server."
                    } else {
                        echo "The file does not exists on the server."

                        // Создаем пустой JAR файл на удалённый сервере
                        sshCommand remote: remote, command: 'touch /home/panivan09/deployments/jenkins-demo-0.0.1-SNAPSHOT.jar'
                    }
                }
            }
        }

        stage('Deploy Application') {
            steps {
                script {
                    def remote = [:]
                    remote.name = 'Raspberry Pi'
                    remote.host = '192.168.1.81'
                    remote.user = 'panivan09'
                    remote.identityFile = SSH_KEY_PATH
                    remote.allowAnyHosts = true

                    // Копируем JAR файл на удалённый сервер
                    sshPut remote: remote, from: 'target/jenkins-demo-0.0.1-SNAPSHOT.jar', into: '/home/panivan09/deployments/jenkins-demo-0.0.1-SNAPSHOT.jar'

                    // Запускаем приложение на удалённом сервере
                    sshCommand remote: remote, command: '''
                        nohup java -jar /home/panivan09/deployments/jenkins-demo-0.0.1-SNAPSHOT.jar
                    '''
                }
            }
        }



    }
}