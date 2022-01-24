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
					bat "start /b gradle bootRun"
					sleep 15
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
					nexusPublisher nexusInstanceId: 'nexus-server', nexusRepositoryId: 'test-gradle', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: '', filePath: 'C:/Users/psantacruz/Documents/diplomado-devops/ejemplo-gradle2/ejemplo-gradle/build/DevOpsUsach2020-0.0.1.jar']], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '0.0.1']]]
				}
			}
        }
    }
}