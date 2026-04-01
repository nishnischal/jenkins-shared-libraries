def call(String Project, String ImageTag, String dockerhubuser) {
    withCredentials([usernamePassword(
        credentialsId: 'docker-hub-cred',
        passwordVariable: 'dockerHubPass',
        usernameVariable: 'dockeHubUser'
    )]) {
        sh "docker login -u ${dockerhubuser} -p ${dockerhubpass}"
    }

    sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
}
