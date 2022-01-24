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
}