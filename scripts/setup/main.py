import glob
import requests

path = ''

#subscription key
key = ""

endpoint = ""

headers = {'Content-Type' : 'application/json', 'Ocp-Apim-Subscription-Key' : key}
headers_with_file = {'Content-Type' : 'application/octet-stream', 'Ocp-Apim-Subscription-Key' : key}


def create_large_person_group( group_id, name, userdata ):
    uri = endpoint + "/largepersongroups/" + group_id
    body = {'name' : name, 'userData' : userdata}
    r = requests.put( uri, json = body, headers = headers )



def create_person( group_id, name, userdata ):
     uri = endpoint + "/largepersongroups/" + group_id + "/persons"
     body = {'name' : name, 'userData' : userdata}
     r = requests.post( uri, json = body, headers = headers )
     response_jason = r.json()
     person_id =  response_jason['personId']
     print( 'person id = ', person_id )
     return person_id



def add_face( group_id, image_path, person_id ):
    uri = endpoint + "/largepersongroups/" + group_id + "/persons/" + person_id + '/persistedfaces'
    binary_file = open( image_path, 'rb' )
    r = requests.post( uri, data = binary_file, headers = headers_with_file )



def train(  group_id ):
    uri = endpoint + "/largepersongroups/" + group_id + "/train" 
    r = requests.post( uri, headers = headers )



def get_train_status( group_id ):
    uri = endpoint + "/largepersongroups/" + group_id + '/training'
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
    # execute only if run as a script
    main()