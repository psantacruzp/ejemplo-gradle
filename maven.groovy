/*
	forma de invocación de método call:
	def ejecucion = load 'script.groovy'
	ejecucion.call()
*/

def call(){
  
    stage('Compile') {
        bat "mvn clean compile -e"
    }
		
	stage('Sonar') {
        def scannerHome = tool 'sonar-scanner';
        withSonarQubeEnv('sonar-server') {
        bat "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=ejemplo-maven-developer -Dsonar.sources=src -Dsonar.java.binaries=build"
			}
	}
          
    stage('Test') {
        bat "mvn clean test -e"
    }
	
    stage('Package') {
        bat "mvn clean package -e"
    }
		
    stage('Run') {
        bat "start /min mvn spring-boot:run &"
    }
	
    stage('Test Applications') {
        bat "start chrome http://localhost:8081/rest/mscovid/test?msg=testing"
	}
}

return this;