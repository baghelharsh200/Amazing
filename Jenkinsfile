pipeline {
    agent any

    tools {
        // Ensure Maven is available in Jenkins
        maven 'Maven' 
    }

    stages {
        stage('Checkout') {
            steps {
                // Pull the code from the Git repository
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                // Compile the code
                sh 'mvn clean compile'
            }
        }
        
        stage('Test') {
            steps {
                // Run tests
                sh 'mvn test'
            }
        }
        
        stage('Package') {
            steps {
                // Package the application into a JAR file
                sh 'mvn package'
            }
        }
        
        stage('Archive Artifacts') {
            steps {
                // Archive the JAR file as a build artifact
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }

    post {
        always {
            // Cleanup and send a message or email on build completion
            echo "Pipeline execution completed."
        }
        success {
            echo "Build succeeded!"
        }
        failure {
            echo "Build failed."
        }
    }
}
