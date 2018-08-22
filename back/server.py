from flask import Flask
app = Flask(__name__)

def get_face_id():
    pass

def submit_face_id(face_id):
    pass

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
    app.run('0.0.0.0', port=5000)
