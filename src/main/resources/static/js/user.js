$(document).ready(function(){
    getUsers();

    function deleteUser(targetId) {
        var inputId =  targetId;
        var query = {
            id: inputId
        }
        $.ajax( {
            type: "POST",
            url: "http://192.168.0.8:8080/v1/user/delete",
            data: query,
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",

            success: function (json) {
                var str = json;
                alert(str);
                getUsers();
            }
        })
    }
    function getUsers() {
        $.ajax({
            type: "GET",
            url: "http://192.168.0.8:8080/v1/user/all",
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",

            success: function (json) {
                $('#tbody').html("");
                var list = json;
                var listLen = json.length;
                for (var i = 0; i < listLen; i++) {
                    var str = "<tr>" +
                        "<td>" + list[i].id + "</td>" +
                        "<td>" + list[i].pwd + "</td>" +
                        "<td>" + list[i].name + "</td>" +
                        "<td><button type='button' class='btn_delete'>삭제</button></td>"
                        "</tr>";
                    $('#tbody').append(str);
                }

                var targetElement = document.getElementsByClassName('btn_delete');
                for (var i = 0; i < targetElement.length; i++) {
                    targetElement[i].addEventListener('click', function () {
                        var findTr = $(this).parent().parent();
                        var findId = findTr.find("td:eq(0)").text();
                        deleteUser(findId);

                    })
                }
            }
        });
    }

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
            url: "http://192.168.0.8:8080/v1/user/signup",
            data: query,
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",

            success: function (json) {
                var str = json;
                alert(str);
            }
        });
    })
})