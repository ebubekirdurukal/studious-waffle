pipeline {
agent any

stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Ui Test'){
         steps {
                        sh 'java -jar target/demo-0.0.1-SNAPSHOT.jar'
                    }

        }

    }
   }