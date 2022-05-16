$(document).ready(function () {
    $('#btnSignup').click(function () {
        var inputId = $('#id').val();
        var inputPwd = $('#pwd').val();
        var inputName = $('#name').val();
        var query = {
            id: inputId,
            pwd: inputPwd,
            name: inputName
        };
            $.ajax({
                type: "POST",
                url: "http://192.168.0.39:8080/v1/user/signup",
                data: query,
                contentType: "application/x-www-form-urlencoded; charset=UTF-8",

                success: function (json) {
                    var str = json;
                    alert(str);
                }
            });
    })
})