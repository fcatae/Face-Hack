


function previewFile() {
    let preview = document.querySelector('img');
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
                preview.src = reader.result;
                if (response.data.candidates.length > 0) {
                    result_field.textContent = 'Fraudador'
                }
            })
    }, false);

    if (file) {
        reader.readAsDataURL(file);
    }
}