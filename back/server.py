import requests
from flask import Flask

app = Flask(__name__)

def get_face_id():
    data = {'url' : 'https://images.pexels.com/photos/415829/pexels-photo-415829.jpeg?auto=compress&cs=tinysrgb&h=350'}
    response = call('https://brazilsouth.api.cognitive.microsoft.com/face/v1.0/detect', data)
    print(response)
 
def submit_face_id(face_id):
    data = {
        "largePersonGroupId": "bancodobrasil",
        "faceIds": [face_id]
    }

    response = call('https://brazilsouth.api.cognitive.microsoft.com/face/v1.0/identify', data)
    print(response)

def call(endpoint, data):
    headers = {'Content-Type' : 'application/json', 'Ocp-Apim-Subscription-Key' : ''}
    r = requests.post(endpoint, json=data, headers=headers)
    return r.json()

@app.route('/')
def hello_world():
    return 'Hello, World!\n'

@app.route('/healthz')
def health_check():
    return 'Everything working!\n'

@app.route('/api/person/search', methods=['POST'])
def person_search():
    face_id = get_face_id
    submit_face_id()

if __name__ == '__main__':
    get_face_id()
    app.run('0.0.0.0', port=5000)
