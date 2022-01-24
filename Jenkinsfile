pipeline {
    agent any

    stages {
        stage('Build Test & JAR') {
            steps {
                script {
					println 'Se realiza ejecución de gradle'
                    bat "gradle clean build"
                }
            }
        }
		
        stage('Sonar') {
            steps {
                script {
					println 'Se ejecuta revisión de Sonar'
					def scannerHome = tool 'sonar-scanner';
                    withSonarQubeEnv('sonar-server'){
                    bat "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=ejemplo-gradle -Dsonar.sources=src -Dsonar.java.binaries=build"
					}
                }
            }
        }

        stage('Run') {
            steps {
                script {
					println 'Se realiza ejecución la aplicación'
					bat "nohup bash gradle bootRun &"
                }
            }
        }
        stage('TestApp') {
            steps {
                script {
					println 'Se prueba la ejecución'
                    bat "start chrome http://localhost:8081/rest/mscovid/test?msg=testing"
                }
            }
        }
        stage('Nexus') {
            steps {
                script {
                    println 'Se realiza ejecución de gradle'
                }
            }
        }
    }
}
