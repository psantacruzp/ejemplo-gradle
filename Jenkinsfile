pipeline {
    agent any
	
	parameters {
		choice choices: ['gradle', 'maven'], description: 'Indicar la herramienta de construccion.', name: 'buildTool'
	}

    stages {
        stage('Pipeline') {
            steps {
                script {
					println 'Pipeline'
					if (params.buildTool == 'gradle'){
						def ejecucion = load 'gradle.groovy'
						ejecucion.call()
					} else {
						def ejecucion = load 'maven.groovy'
						ejecucion.call()
					}
                }
            }
        }
	}
	post {
		always {
			slackSend channel: '#jenkins-ci', color: 'normal', message: "${username}, ${env.STAGE_NAME}, ${} - Se ha ejecutado un Pipeline", teamDomain: 'dipdevopsusac-tr94431', tokenCredentialId: 'slack-token'
		}
		success{
			slackSend channel: '#jenkins-ci', color: '#29AE4A', message: 'Jesus Ruiz ' + env.JOB_NAME + ' ' + params.buildTool + ' Ejecucion exitosa', teamDomain: 'dipdevopsusac-tr94431', tokenCredentialId: 'slack-token'
		}
        failure {
            slackSend channel: '#jenkins-ci', color: '#EC4D34', message: 'Ejecución Fallida ', teamDomain: 'dipdevopsusac-tr94431', tokenCredentialId: 'slack-token'
        }
    }
}