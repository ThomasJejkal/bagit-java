pipeline {
  agent any
  stages {
    stage('Generate Javadoc') {
      steps {
        sh './gradlew javadoc'
      }
    }
    stage('Check Dependencies') {
      steps {
        sh './gradlew dependencyCheck'
      }
    }
    stage('Check Code Quality') {
      steps {
        sh './gradlew test pmdMain findbugsMain pmdMain cpdCheck'
      }
    }
    stage('Reports') {
      steps {
        parallel(
          "Reports": {
            sh './gradlew jacocoTestReport -x integrationTest'
            
          },
          "publish unit tests": {
            junit(testResults: '**/build/test-results/**/*.xml', allowEmptyResults: true)
            
          }
        )
      }
    }
  }
}