$('#img-picker').change(function () {
    getSelectedImages();
});

$('#doc-picker').change(function () {
    getSelectedDocs();
});

$('#video-picker').change(function () {
    getSelectedVideos();
});

$(document).ready(function () {
    getSelectedImages();
    getSelectedDocs();
    getSelectedVideos();
});


function getSelectedImages(){
    var imgPreviewDiv = $('#img-selector');
    imgPreviewDiv.empty();
    $("#img-picker").find("option:selected").each(function () {
        var $this = $(this).text();
        if($this.length > 0){
            var img = "<img src='"+$this+"' alt='No Preview Available' class='img-thumbnail'/>";
            imgPreviewDiv.append(img);
        }
    });
}

function getSelectedDocs(){
    var docPreviewDiv = $('#doc-selector');
    docPreviewDiv.empty();
    $("#doc-picker").find("option:selected").each(function () {
        var $this = $(this).text();
        var $value = $(this).attr('data-img-label');
        var $url = $(this).attr('data-doc-url');
        if($this.length > 0){
            var img = "<a href='"+$url+"' target='_blank'><figure>" +
                "<img src='/images/file-preview.png' alt='No Preview Available' class='img-thumbnail'/>" +
                "<figcaption>"+$value+"</figcaption>" +
                "</figure></a>";
            docPreviewDiv.append(img);
        }
    });
}

function getSelectedVideos(){
    var videoPreviewDiv = $('#video-selector');
    videoPreviewDiv.empty();
    $("#video-picker").find("option:selected").each(function () {
        var $this = $(this).text();
        var $value = $(this).attr('data-img-label');
        var $url = $(this).attr('data-video-url');
        if($this.length > 0){
            var img = "<a href='"+$url+"' target='_blank'><figure>" +
                "<img src='"+$this+"' alt='No Preview Available' class='img-thumbnail'/>" +
                "<figcaption>"+$value+"</figcaption>" +
                "</figure></a>";
            videoPreviewDiv.append(img);
        }
    });
}
