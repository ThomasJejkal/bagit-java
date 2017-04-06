pipeline {
  agent any
  stages {
    stage('Tests') {
      steps {
        parallel(
          "unit tests": {
            sh './gradlew test'
            
          },
          "Findbugs": {
            sh './gradlew findbugsMain'
            
          },
          "PMD": {
            sh './gradlew pmd'
            
          },
          "cpd check": {
            sh './gradlew cpdCheck'
            
          }
        )
      }
    }
    stage('Reports') {
      steps {
        parallel(
          "generate code coverage": {
            sh './gradlew jacocoTestReport -x integrationTest'
            
          },
          "publish unit tests": {
            junit(testResults: '**/build/test-results/**/*.xml', allowEmptyResults: true)
            
          }
        )
      }
    }
    stage('javadoc') {
      steps {
        sh './gradlew javadoc'
      }
    }
    stage('check dependencies') {
      steps {
        sh './gradlew dependencyCheck'
      }
    }
  }
}