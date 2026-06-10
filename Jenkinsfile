pipeline {

    agent any

    tools {
        jdk 'JDK25'
        maven 'Maven3'
    }

    stages {

        stage('Checkout') {

            steps {

                echo 'Cloning GitHub Repository'

                git branch: 'main',
                    url: 'https://github.com/Trip-Harshit2505/GUIElementsAutomation.git'
            }
        }

        stage('Clean') {

            steps {

                echo 'Cleaning Project'

                bat 'mvn clean'
            }
        }

        stage('Build') {

            steps {

                echo 'Compiling Project'

                bat 'mvn compile'
            }
        }

        stage('Execute Tests') {

            steps {

                echo 'Running TestNG Suite'

                bat 'mvn test -DsuiteXmlFile=testng.xml'
            }
        }

        stage('Archive Reports') {

            steps {

                archiveArtifacts artifacts: 'reports/**/*.*',
                                 fingerprint: true

                archiveArtifacts artifacts: 'screenshots/**/*.*',
                                 fingerprint: true

                archiveArtifacts artifacts: 'test-output/**/*.*',
                                 fingerprint: true
            }
        }
    }

    post {

	    always {
	
	        echo 'Execution Completed'
	    }
	
	    success {
	
	        echo 'Build Successful'
	
	        emailext(
	            subject: "SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
	            body: """
	                Build Successful
	
	                Project: ${env.JOB_NAME}
	
	                Build Number: ${env.BUILD_NUMBER}
	
	                Build URL:
	                ${env.BUILD_URL}
	            """,
	            attachmentsPattern: "reports/*.html"
	        )
	    }
	
	    failure {
	
	        echo 'Build Failed'
	
	        emailext(
	            subject: "FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
	            body: """
	                Build Failed
	
	                Project: ${env.JOB_NAME}
	
	                Build Number: ${env.BUILD_NUMBER}
	
	                Build URL:
	                ${env.BUILD_URL}
	            """,
	            attachmentsPattern: "reports/*.html"
	        )
	    }
	}
}