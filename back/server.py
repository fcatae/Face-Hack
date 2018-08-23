import requests
from flask import Flask
import os
from dotenv import load_dotenv
import json
import base64

app = Flask(__name__)

# image_64_decode = base64.decodestring(image_64_encode)
# this will be the line to decode the base64 image coming from the post method
# have to read from the body

def get_face_id():
    data = {'url' : 'https://images.pexels.com/photos/415829/pexels-photo-415829.jpeg?auto=compress&cs=tinysrgb&h=350'}
    response = call('https://brazilsouth.api.cognitive.microsoft.com/face/v1.0/detect', data)
    return response[0]['faceId']
 
def submit_face_id(face_id):
    data = {
        "largePersonGroupId": "bancodobrasil",
        "faceIds": [face_id]
    }

    response = call('https://brazilsouth.api.cognitive.microsoft.com/face/v1.0/identify', data)
    return json.dumps(response[0])

def call(endpoint, data):
    load_dotenv('.env')
    face_key = os.getenv("FACE_KEY")
    headers = {'Content-Type' : 'application/json', 'Ocp-Apim-Subscription-Key' : face_key}
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
    face_id = get_face_id()
    return submit_face_id(face_id)

if __name__ == '__main__':
    app.run('0.0.0.0', port=5000)
