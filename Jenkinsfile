node {
	def app
	def image = 'registry.hub.docker.com/lylio/quarcode'
	def branch = 'main'

	try {
		stage('Clone repository') {
	    	git branch: branch,
	        	credentialsId: 'Lylio-GitHub',
	        	url: 'https://github.com/Lylio/quarcode.git'
	    }

		stage('Build JAR') {
	    	docker.image('maven:3.8.4-openjdk-17').inside('-v /root/.m2:/root/.m2') {
	        	sh 'mvn -B clean package'
	        	stash includes: '**/*.jar', name: 'jar'
	    	}
	    }

	    stage('Build Image') {
	    	unstash 'jar'
			app = docker.build image
	    }

	    stage('Push') {
	    	docker.withRegistry('https://registry.hub.docker.com', 'dockerhub_id') {
				app.push("${env.BUILD_NUMBER}")
				app.push("latest")
	        }
	    }
	} catch (e) {
		echo 'Error occurred during build process!'
		echo e.toString()
		currentBuild.result = 'FAILURE'
	} finally {
        junit '**/target/surefire-reports/TEST-*.xml'
	}
}