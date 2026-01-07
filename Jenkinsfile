node {
    def repourl = "islamhamada/petshop"
    def mvnHome = tool name: 'maven', type: 'maven'
    def mvnCMD = "${mvnHome}/bin/mvn"
    def version = sh(script: "date +%s", returnStdout: true).trim()
    stage('Checkout') {
        checkout([$class: 'GitSCM',
         branches: [[name: '*/hetzner']],
         userRemoteConfigs: [[credentialsId: 'git',
         url: 'https://github.com/IslamHamada/petshop_configserver.git']]])
    }
    stage('Build and Push Image') {
        sh("${mvnCMD} clean install jib:build -DREPO_URL=${repourl} -DVERSION=${version}")
    }
    stage('Deploy') {
        sh("sed -i 's|IMAGE_URL|${repourl}|g' k8s/deployment.yaml")
        sh("sed -i 's|TAG|${version}|g' k8s/deployment.yaml")
        sh(k3s kubectl apply -f k8s/deployment.yaml)
    }
}