$(document).ready(function(){
    getUsers();

    function getUsers() {
        $.ajax({
            type: "GET",
            url: "http://192.168.0.39:8080/v1/user/all",
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",

            success: function (json) {
                var list = json;
                var listLen = json.length;
                for (var i = 0; i < listLen; i++) {
                    var str = "<tr>" +
                        "<td>" + list[i].id + "</td>" +
                        "<td>" + list[i].pwd + "</td>" +
                        "<td>" + list[i].name + "</td>" +
                        "</tr>";
                    $('#tbody').append(str);
                }
            }
        });
    }
})