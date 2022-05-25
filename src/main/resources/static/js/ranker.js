$(document).ready(function() {
    getRankers();

    function getRankers() {
        $.ajax( {
            type: "GET",
            url: "http://172.31.115.244:8080/ranker/all",
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",

            success: function (json) {
                $('#rbody').html("");
                var list = json;
                var listLen = json.length;
                for (var i = 0; i < listLen; i++) {
                    var str = "<tr class='ranker_tr'>" +
                        "<td>" + list[i].id + "</td>" +
                        "<td>" + list[i].record + "</td>" +
                        "<td><button type='button' class='ranker_delete'>삭제</button></td>"
                        "</tr>";
                    $('#rbody').append(str);
                }

                var modifyElement = document.getElementsByClassName('ranker_tr');
                for (var i = 0; i < modifyElement.length; i++) {
                    modifyElement[i].addEventListener('click', function() {
                        var findTr = $(this);
                        var findId = findTr.find("td:eq(0)").text();
                        var findRecord = findTr.find("td:eq(1)").text();
                        $('#id').val(findId);
                        $('#record').val(findRecord);
                    })
                }

                var targetElement = document.getElementsByClassName('ranker_delete');
                for (var i = 0; i < targetElement.length; i++) {
                    targetElement[i].addEventListener('click', function() {
                        var findTr = $(this).parent().parent();
                        var findId = findTr.find("td:eq(0)").text();
                        deleteRanker(findId);
                    })
                }
            }
        })
    }

    $('#rankerModify').click(function () {
        var inputId = $('#id').val();
        var inputRecord = $('#record').val();
        var query = {
            id: inputId,
            newRecord : inputRecord
        };
        $.ajax( {
            type: "POST",
            url: "http://192.168.0.39:8080/ranker/modify",
            data: query,
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",

            success: function (json) {
                var str = json;
                alert(str);
                getRankers();
            }
        })
    })

    function deleteRanker(targetId) {
        var inputId = targetId;
        var query = {
            id: inputId
        }
        $.ajax( {
            type: "POST",
            url: "http://192.168.0.39:8080/ranker/delete",
            data: query,
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",

            success: function (json) {
                var str = json;
                alert(str);
                getRankers();
            }
        })
    }

    $('#rankerInsert').click(function() {
        var inputId = $('#id').val();
        var inputRecord = $('#record').val();
        var query = {
            id: inputId,
            record: inputRecord
        };
        $.ajax( {
            type:"POST",
            url: "http://192.168.0.39:8080/ranker/insert",
            data: query,
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",

            success: function (json) {
                var str = json;
                alert(str);
                getRankers();
            }
        })
    })
})