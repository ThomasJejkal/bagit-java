pipeline {
  agent any
  stages {
    stage('Unit tests') {
      steps {
        sh 'gradle test'
      }
    }
    stage('Integration tests') {
      steps {
        sh 'gradle integrationTest'
      }
    }
  }
}