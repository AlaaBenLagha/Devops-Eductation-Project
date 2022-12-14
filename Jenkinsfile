pipeline {
    agent any
    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M2_HOME"
    }
    
    environment { 

       registry = "alaaben/devops_project" 
       registryCredential = 'dockerhub_devops' 
       dockerImage = '' 

    }

    stages {
        stage('Git') {
            steps {
              echo 'Pulling from git ..';
                git branch: 'main', url: 'https://github.com/AlaaBenLagha/Devops-Eductation-Project.git';

               
            }

        }
       
        stage('Testing maven') {
            steps{
                sh 'mvn -version'
            }
        }
       
        stage('mvn clean') {
            steps{
                sh """mvn clean"""
            }
        }
       
        stage('mvn compile') {
            steps{
                sh """mvn compiler:compile"""
            }
        }
       
       
       
      stage(" SonarQube") {
            steps{
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
            }
        }
        stage("Running Tests")
        {
            steps{
                sh 'mvn test'
            }
        }
       
        
        stage("Nexus")
        {
            steps{
                sh 'mvn deploy'
            }
        }
        
   
        
        stage('Building our image') { 

            steps { 

                script { 

                    dockerImage = docker.build("alaaben/devops_project:lastest") 

                }

            } 

        }
        
        stage('Deploy our image') { 

            steps { 

                script { 

                    docker.withRegistry( '', "dockerhub_devops") { 

                        dockerImage.push() 

                    }

                } 

            }

        } 
        
        stage('docker composer') { 

            steps { 

                sh "docker-compose up -d" 

            }

        }
   
        
    }
}