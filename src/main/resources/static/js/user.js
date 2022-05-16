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
                    var str = "<tr class='user_tr'>" +
                        "<td>" + list[i].id + "</td>" +
                        "<td>" + list[i].pwd + "</td>" +
                        "<td>" + list[i].name + "</td>" +
                        "<td><button type='button' class='btn_delete'>삭제</button></td>"
                        "</tr>";
                    $('#tbody').append(str);
                }

                var modifyElement = document.getElementsByClassName('user_tr');
                for (var i = 0; i < modifyElement.length; i++) {
                    modifyElement[i].addEventListener('click', function() {
                        var findTr = $(this);
                        var findId = findTr.find("td:eq(0)").text();
                        var findPWD = findTr.find("td:eq(1)").text();
                        var findName = findTr.find("td:eq(2)").text();
                        $('#id').val(findId);
                        $('#pwd').val(findPWD);
                        $('#name').val(findName);

                    })
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

    $('#btnModify').click(function () {
        var inputId = $('#id').val();
        var inputPwd = $('#pwd').val();
        var inputName = $('#name').val();
        var query = {
            id: inputId,
            newPwd: inputPwd,
            newName : inputName
        };
        $.ajax( {
            type: "POST",
            url:"http://192.168.0.8:8080/v1/user/modify",
            data: query,
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",

            success: function (json) {
                var str = json;
                alert(str);
                getUsers();
            }
        })
    })

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