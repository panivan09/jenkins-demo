
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
                    ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQC+vjuFhAup42HNgjQnhpH9VSdt7hbAqyYDvQdSz9/eqAqQo/dqPHHUXBUMYfmBTU4RZ4DtvGJjoIvFNWhW5JjSGfd4x3LGmXpzkPcigbWqPNdRRTc2Bajrd53VySAdfi6WQOysjJoMRh1xh12bM/MYQX0gEuqCRcBzxUrvkL7ypywAksc8Sk7ACPbcZNgMTmZgJ3E1bIN3nK4FeKlkYU0U9K4KFLB1EKqaxad5WoIeawnSY+3nVNDEQugnXEmzcqFMVm7bLKGhlKaPU402zdFXDsN0mAmg3LJ9Kq7ehJ/XhJ7btwdwKMHN31ZIQPtwNo49yvlW8FVr6fZy7asdsKul8g+47Qjtt3nmXr2zIpnzIqck4cLflkkDiARzDgKAEnrnMule3bIYxYbYSXQZNyFoRrCWRS5gW/cslocQwvQNs4IPEoKWl/EgHfo+xsZpQykgo6oXOSwbg+Avp9MhASdcFhYot2GsN1bX1BVealP532a/LYPedw7zORqELNtg0Ks= pante@DESKTOP-QOHP7CV panivan09@192.168.1.81 'uname -a'
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