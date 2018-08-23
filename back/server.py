import requests
from flask import Flask, request
import os
from dotenv import load_dotenv
import json
import base64

app = Flask(__name__)

load_dotenv('.env')    
face_key = os.getenv("FACE_KEY") 

def get_face_id(face_image):
    data = {'url' : 'https://images.pexels.com/photos/415829/pexels-photo-415829.jpeg?auto=compress&cs=tinysrgb&h=350'}
    response = call_get('https://brazilsouth.api.cognitive.microsoft.com/face/v1.0/detect', face_image)
    return response[0]['faceId']
 
def submit_face_id(face_id):
    data = {
        "largePersonGroupId": "bancodobrasil",
        "faceIds": [face_id]
    }

    response = call_submit('https://brazilsouth.api.cognitive.microsoft.com/face/v1.0/identify', data)
    return json.dumps(response[0])

def call_get(endpoint, data):
    headers = {'Content-Type' : 'application/octet-stream', 'Ocp-Apim-Subscription-Key' : face_key}
    r = requests.post(endpoint, headers=headers, data=data)    
    return r.json()

def call_submit(endpoint, json):
    headers = {'Content-Type' : 'application/json', 'Ocp-Apim-Subscription-Key' : face_key}
    r = requests.post(endpoint, headers=headers, json=json)    
    return r.json()

@app.route('/')
def hello_world():
    return 'Hello, World!\n'

@app.route('/healthz', methods=['GET', 'POST'])
def health_check():
    return 'Everything working!\n'

@app.route('/api/person/search', methods=['POST'])
def person_search():
    request_data = request.get_json(force=True)
    image = request_data['image']
    decoded_image = base64.b64decode(image)
    face_id = get_face_id(decoded_image)
    return submit_face_id(face_id)

if __name__ == '__main__':       
    app.run('0.0.0.0', port=5000)
