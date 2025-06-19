pipeline {
    agent any
    stages {
        stage('Create CR Minion') {
            steps {
                script {
                    def crMinion = '''
apiVersion: example.com/v1
kind: Minion
metadata:
  name: my-minion
spec:
  replicas: 3
  version: "v1.0"
'''
                    writeFile file: 'minion-cr.yaml', text: crMinion
                    sh 'kubectl apply -f minion-cr.yaml'
                }
            }
        }
    }
}
