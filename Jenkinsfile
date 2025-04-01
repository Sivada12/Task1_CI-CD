pipeline {
    agent none // Choose nodes for specific stages
    stages {
        stage('Build') {
            agent { label 'master' } // Use master agent for the build
            steps {
                echo 'Building the project...'
                sh 'mvn clean install'
            }
        }
        
        stage('Checkout') {
            agent { label 'master' } // Use master agent for the code checkout
            steps {
                echo 'Checking out repository...'
                // Add your Git checkout commands here, like 'git clone' or 'checkout scm'
            }
        }
        
        stage('Run Tests') {
            parallel {
                stage('Smoke Tests') {
                    // Run smoke tests on the master node
                    agent { label 'master' }
                    steps {
                        echo 'Running Smoke Tests on Master...'
                        // Fully-qualified path to the SmokeTest class
                        sh 'mvn test -Dtest=com.example.SmokeTest'
                    }
                }
                stage('Regression Tests') {
                    // Run regression tests on node1
                    agent { label 'node1' }
                    steps {
                        echo 'Running Regression Tests on Node1...'
                        // Fully-qualified path to the Reg class
                        sh 'mvn test -Dtest=com.example.Reg'
                    }
                }
            }
        }
        
        stage('Generate Reports') {
            agent { label 'master' } // Generate reports on the master node
            steps {
                echo 'Publishing test reports...'
                // Add logic to publish reports from both Smoke and Regression tests
                // Example: Archive artifacts or aggregate results
            }
        }
    }
}