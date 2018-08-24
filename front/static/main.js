


function previewFile() {
    let preview = document.querySelector('imgSupostoFraude');
    let result_field = document.querySelector('#result_field');
    const file = document.querySelector('input[type=file]').files[0];
    const reader = new FileReader();

    reader.addEventListener("load", function () {
        base64 = reader.result
        axios.post('https://cognitive-back.azurewebsites.net/api/person/search', {
            image: base64.split(',')[1]
        })
            .then(function (response) {
                console.log(response)
                imgSupostoFraude.src = reader.result;
                if (response.data.candidates.length > 0) {
                    result_field.textContent = 'Fraudador. Segue a chave do fraudador: ' + response.data.faceId
                } else {
                    result_field.textContent = 'Boa reputação. Segue sua chave gerada na Microsoft: ' + response.data.faceId
                }
            })
    }, false);

    if (file) {
        reader.readAsDataURL(file);
    }
}