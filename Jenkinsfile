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
                }
            }
        }
		
    }
}