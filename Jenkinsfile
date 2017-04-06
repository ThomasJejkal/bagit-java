pipeline {
  agent any
  stages {
    stage('Download compliance suite') {
      steps {
        git 'https://github.com/loc-rdc/bagit-conformance-suite'
        git 'https://github.com/LibraryOfCongress/bagit-java'
      }
    }
    stage('Unit tests') {
      steps {
        sh '''pwd
ls'''
      }
    }
  }
}