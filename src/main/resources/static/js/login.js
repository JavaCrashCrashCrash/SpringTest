$(document).ready(function(){
    $('#btn').click(function() {
        var inputId = $('#id').val();
        var inputPwd = $('#pwd').val();
        alert("id : " + inputId);
        alert("pwd : " + inputPwd);
        var query = {
            id : inputId,
            pwd : inputPwd
        };
        $.ajax({
            type: "GET",
            url: "http://192.168.0.8/v1/user/login",
            data: query,
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",

            success: function (res) {
                alert(res);
            }
        });
    });
})