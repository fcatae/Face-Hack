import glob
import requests

path = ''
key = ""
endpoint = ""

def cognitive_header(content_type):
    return {
        'Content-Type' : content_type, 
        'Ocp-Apim-Subscription-Key' : key
    }
    
def create_large_person_group(group_id, name, userdata):
    uri = endpoint + "/largepersongroups/" + group_id
    headers = cognitive_header('application/json')
    body = { 'name' : name, 'userData' : userdata }
    
    requests.put(uri, json = body, headers = headers)

def create_person( group_id, name, userdata ):
    uri = endpoint + "/largepersongroups/" + group_id + "/persons"
    headers = cognitive_header('application/json')
    body = {'name' : name, 'userData' : userdata}
     
    r = requests.post( uri, json = body, headers = headers )
    response_json = r.json()
    person_id =  response_json['personId']
    print( 'person id = ', person_id )
    return person_id

def add_face( group_id, image_path, person_id ):
    uri = endpoint + "/largepersongroups/" + group_id + "/persons/" + person_id + '/persistedfaces'
    headers = cognitive_header('application/octet-stream')
    binary_file = open( image_path, 'rb' )

    requests.post( uri, data = binary_file, headers = headers )

def train(  group_id ):
    uri = endpoint + "/largepersongroups/" + group_id + "/train" 
    headers = cognitive_header('application/json')

    requests.post( uri, headers = headers )

def get_train_status( group_id ):
    uri = endpoint + "/largepersongroups/" + group_id + '/training'
    headers = cognitive_header('application/json')

    r = requests.get( uri, headers = headers )  
    return r.json()     

def main():
    #Cria grupo de pessoas (fraudadores)
    group_id = "my_group_id"
    create_large_person_group( group_id, "my_group_name", "primeiro teste" )

    # Adiciona as imagens (fotos) dos fraudadores
    for file_path in glob.glob( path + "/*.jpg" ):
        person_name = "name_" + file_path
        person_id = create_person( group_id, person_name, "fraudador" )
        add_face( group_id, file_path, person_id )
    
    # Treina o modelo
    train( group_id )

    print( get_train_status( group_id ) )
        
if __name__ == "__main__":
    main()
