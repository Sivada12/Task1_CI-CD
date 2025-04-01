pipeline {
    agent none
    stages {
        stage('Build') {
            agent { label 'master' } 
            steps {
                echo 'Building the project...'
                bat 'mvn clean install'
            }
        }
        
        stage('Build') {
            agent { label 'master' } 
            steps {
                echo 'Checking out repository...'
                git credentialsId: 'a79ed2e2-b2da-4422-9f8d-5c2febe66268', url: 'https://github.com/Sivada12/Task1_CI-CD.git'
            }
        }
        
        stage('Run Tests') {
            parallel {
                stage('Smoke Tests') {
                    agent { label 'master' }
                    steps {
                        echo 'Running Smoke Tests on Master...'
                        bat 'mvn test -Dtest=com.example.SmokeTest'
                    }
                }
                stage('Regression Tests') {
                    agent { label 'node1' }
                    steps {
                        echo 'Running Regression Tests on Node1...'
                        bat 'mvn test -Dtest=com.example.Reg'
                    }
                }
            }
        }
    }
}
