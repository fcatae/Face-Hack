/**
 * Altera o label do botão para facilitar a leitura
 */
$(function () {
    $('#imgFile').change(function() {
         $('.nomeArquivo').html('<b>Arquivo Selecionado:</b>' + $(this).val());
    });
});