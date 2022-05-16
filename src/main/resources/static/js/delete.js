$(document).ready(function () {
    $('#btnDelete').click(function () {
        var inputId = $('#id').val();
        var query = {
            id: inputId,
        };
        $.ajax({
            type: "POST",
            url: "http://192.168.0.8:8080/v1/user/delete",
            data: query,
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",

            success: function (json) {
                var str = json;
                alert(str);
            }
        });
    })
})