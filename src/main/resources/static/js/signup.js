$(document).ready(function(){
    $('#btn').click(function() {
        var inputId = $('#id').val();
        var inputPwd = $('#pwd').val();
        var inputName = $('#name').val();
        var query = {
            id : inputId,
            pwd : inputPwd,
            name : inputName
        };
        $.ajax( {
            type: "POST",
            url: "http://192.168.0.39:8080/v1/user/signup",
            data: query,
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",

            success: function (res) {
                alert(res);
            }
        })
    })

    function singUp() {
        $.ajax( {
            type: "POST",
            url: "http://192.168.0.39:8080/v1/user/signup",
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",

            success: function (json) {
                var list = json;
                var listLen =json.length;
                for (var i = 0; i < listLen; i++) {
                    var str = "<tr>" +
                        "<td>" + list[i].id + "</td>" +
                        "<td>" + list[i].pwd + "</td>" +
                        "<td>" + list[i].name + "</td>" +
                        "</tr>";
                    $('#tbody').append(str);
                }
            }
        })
    }

})