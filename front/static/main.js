


function previewFile() {
    var preview = document.querySelector('img');
    var file = document.querySelector('input[type=file]').files[0];
    var reader = new FileReader();

    reader.addEventListener("load", function () {
        preview.src = reader.result;
        base64 = preview.src
        axios.get('https://reqres.in/api/users/2')
            .then(function (response) {
                // handle success
                console.log(response);
            })

        console.log('Preview', base64.split(',')[1])
    }, false);

    if (file) {
        reader.readAsDataURL(file);
    }
}