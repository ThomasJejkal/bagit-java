pipeline {
  agent any
  stages {
    stage('Download compliance suite') {
      steps {
        git 'https://github.com/loc-rdc/bagit-conformance-suite'
      }
    }
    stage('Unit tests') {
      steps {
        sh './gradlew test'
      }
    }
  }
}