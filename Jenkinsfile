pipeline {
   agent any

   tools {
      // Install the Maven version configured as "M3" and add it to the path.
      maven "M3"
   }
    triggers {
        cron('0 8 * * *')
    }
    parameters {
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'master', name: 'BRANCH', type: 'PT_BRANCH'
        string(name: 'EMAIL', defaultValue: 'defaultEmail', description: 'Email of user')
        string(name: 'PASSWORD', defaultValue: 'defaultPassword', description: 'Password')
        string(name: 'ACCESS_USER_URL', defaultValue: 'defaultUrl', description: 'Url to access the site')
    }

       stages {
           stage('Build') {
               steps {
                   // Get some code from a GitHub repository
                   git 'https://github.com/Chemosa/DiplomaTestRailQA29.git'

                   // Run Maven on a Unix agent.
                   // sh "mvn -Dmaven.test.failure.ignore=true clean package"

                   // To run Maven on a Windows agent, use
                   bat "mvn clean -Demail=${params.EMAIL} -Dpassword=${params.PASSWORD} -DaccessAddress=${params.ACCESS_USER_URL} -DapiKey=${params.API_KEY} test"
               }
           }

           stage('Reporting') {
                script {
                     allure([
                           includeProperties: false,
                           jdk: '',
                           properties: [],
                           reportBuildPolicy: 'ALWAYS',
                           results: [[path: 'target/allure-results']]
                                ])
                        }
                      }

         post {
            // If Maven was able to run the tests, even if some of the test
            // failed, record the test results and archive the jar file.
            success {
               junit '**/target/surefire-reports/TEST-*.xml'
            }
         }
   }
}
