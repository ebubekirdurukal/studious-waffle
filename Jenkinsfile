pipeline {
    agent any
    triggers {
	    //Execute weekdays every 1 hour starting at minute 0
        cron('0 */1 * * 1-5')
    }
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
            parallel {
                stage('Test On Windows') {
                    steps {
                    sh 'newman run  /Users/sahabt/Documents/Personal/JenkinsSunum.postman_collection.json'
                    }
                }
                stage('Test On Linux') {
                    steps {
                    sh 'newman run  /Users/sahabt/Documents/Personal/JenkinsSunum.postman_collection.json'
                    }
                }
            }
        }

        stage('Load Test'){
            steps{
            sh 'cd ../bin'
            sh 'jmeter -n -t /Users/sahabt/Documents/Personal/Spring-Jenkins/LoadTest.jmx'
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