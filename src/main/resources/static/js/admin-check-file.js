$(document).ready(function () {
    var src = $('#thumbnailSrc').val();
    if(src.length > 0){
        addImage(src);
    }
});

$('#thumbnailSrc').change(function () {
    var src = $('#thumbnailSrc').val();
    addImage(src);
});

$('#check-btn').click(function () {
    var src = $('#cloudSrc').val();
    if(!doesFileExist(src)){
        alert("Invalid file specified");
    } else{
        $('#submit').click();
    }
});

function doesFileExist(urlToFile) {
    var xhr = new XMLHttpRequest();
    xhr.open('HEAD', urlToFile, false);
    xhr.send();

    return xhr.status !== 404;
}

function addImage(coverSrc) {
    var img = "<img src='"+coverSrc+"' alt='No Preview Available' class='img-fluid' id='preview'/>";
    var imgPreviewDiv = $('#img-preview');
    imgPreviewDiv.empty();
    imgPreviewDiv.append(img);
}