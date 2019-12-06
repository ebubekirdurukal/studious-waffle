pipeline {
agent any

stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean install'
            }
        }
        stage('Unit Tests') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
                stage('API Tests') {
                    steps {
                        sh 'newman run  /Users/sahabt/Documents/Personal/JenkinsSunum.postman_collection.json'
                    }
                }

        stage('Deploy') {
            when {
              expression {
                currentBuild.result == null || currentBuild.result == 'SUCCESS'
              }
            }
            steps {
                echo 'Deployment to Test'
            }
        }
    }
   }