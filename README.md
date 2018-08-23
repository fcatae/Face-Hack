# Face-Hack

This project aims to test some Cognitive services API's, searching for a person inside a group trained before.
The whole pipeline of constructing a model and checking if a person exists there, is shown above:

![Pipeline image](imgs/pipeline.png)

In order to use the solution, you must have a Face API key, generated on [Azure Portal](https://azure.microsoft.com/en-us/services/cognitive-services/face/).

## 1. Script

## 2. Back End

The already deployed public back end endpoint is located at https://bbsrv.azurewebsites.net/ .

The whole Python Back End is written with Flask, a really simple framework for developing REST API's and the whole code is done by calling Face API
from Azure. In order to consume our API, spin up our Flask Server and hit the endpoint ```/api/person/search``` with the following body:

``` json
{
    "image": "<BASE64_IMAGE_STRING_ENCODED>"
}
```

### 2.1 Spinning up locally

To run the back end locally, ou must set a enviroment variable called ```FACE_API``` with the Face API you created on Azure. After doing that, just get all the
dependencies running, inside the back end folder:

``` shell

pip3 install -r requirements.txt

```

And after that:

``` shell

python3 server.py

```

### 2.2 Spinning up with Docker



## 3. Front End
