pipeline {
    agent none
    stages {
        stage('High Priority Tests on Master') {
            agent { label 'master' }
            steps {
                sh 'docker compose down || true'
                sh 'docker compose up --scale chrome=2 -d'
                sh 'docker compose run --rm java-tests mvn test -Dtags=@high -DrunMode=docker'
            }
            post {
                always {
                    sh 'docker compose down || true'
                }
            }
        }
        stage('Medium Priority Tests on Agent One') {
            agent { label 'agent-one' }
            steps {
                sh 'docker compose down || true'
                sh 'docker compose up --scale chrome=2 -d'
                sh 'docker compose run --rm java-tests mvn test -Dtags=@medium -DrunMode=docker'
            }
            post {
                always {
                    sh 'docker compose down || true'
                }
            }
        }
        stage('Low Priority Tests on Agent Two') {
            agent { label 'agent-two' }
            steps {
                sh 'docker compose down || true'
                sh 'docker compose up --scale chrome=2 -d'
                sh 'docker compose run --rm java-tests mvn test -Dtags=@low -DrunMode=docker'
            }
            post {
                always {
                    sh 'docker compose down || true'
                }
            }
        }
    }
}