pipeline {
  agent any
  stages {
    stage('Unit tests') {
      steps {
        sh './gradlew test'
      }
    }
    stage('Find bugs') {
      steps {
        sh './gradlew findbugsMain'
      }
    }
    stage('PMD') {
      steps {
        sh './gradlew pmdmain'
      }
    }
    stage('cpd Check') {
      steps {
        sh './gradlew cpdCheck'
      }
    }
    stage('code coverage report') {
      steps {
        sh './gradlew jacocoTestReport -x integrationTest'
      }
    }
    stage('javadoc') {
      steps {
        sh './gradlew javadoc'
      }
    }
  }
}