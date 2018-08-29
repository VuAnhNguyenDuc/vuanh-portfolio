$(document).ready(function () {
    var coverSrc = $('#coverSrc').val();
    if(coverSrc !== ""){
        addImage(coverSrc);
    }
});

$('#coverSrc').change(function () {
    var coverSrc = $('#coverSrc').val();
    addImage(coverSrc);
});

function addImage(coverSrc) {
    var img = "<img src='"+coverSrc+"' alt='Not A Valid Image' class='img-fluid' id='preview'/>";
    var imgPreviewDiv = $('#img-preview');
    imgPreviewDiv.empty();
    imgPreviewDiv.append(img);
}

$('#check-btn').click(function () {
    var image = new Image();
    image.src = $('#coverSrc').val();
    console.log(image.src);
    if (image.width === 0){
        alert("Invalid image specified");
    } else{
        $('#submit').click();
    }
});