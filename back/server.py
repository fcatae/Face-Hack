import requests
from flask import Flask

app = Flask(__name__)

def get_face_id():
    data = {'url' : 'https://images.pexels.com/photos/415829/pexels-photo-415829.jpeg?auto=compress&cs=tinysrgb&h=350'}
    headers = {'Content-Type' : 'application/json', 'Ocp-Apim-Subscription-Key' : ''}
    
    r = requests.post('https://brazilsouth.api.cognitive.microsoft.com/face/v1.0/detect', json=data, headers=headers)
    json_response_id = r.json()[0]['faceId']
    return json_response_id
    

def submit_face_id(face_id):
    data = {
        "largePersonGroupId": "bancodobrasil",
        "faceIds": [
            "11515864-b0a2-4034-a77f-559c9b481682"
        ]
    }

    headers = {'Content-Type' : 'application/json', 'Ocp-Apim-Subscription-Key' : ''}
    
    r = requests.post('https://brazilsouth.api.cognitive.microsoft.com/face/v1.0/identify', json=data, headers=headers)
    print(r.json())

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
    submit_face_id('asasdasd')
    app.run('0.0.0.0', port=5000)
