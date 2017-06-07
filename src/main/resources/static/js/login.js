function login() {
    var user = $("#user").val();
    var pas = $("#pas").val();

    $.ajax({
        url: "/login/login.index",
        type: "POST",
        data: {
            'user': user,
            'pas': pas
        },
        cache: false,
        dataType: "json",
        success: function () {
            window.location.href = "page/index.html"
        }, error: function (xhr) {
            var res = xhr.responseJSON;
            alert(res.message);
        }
    });
}


function keyDown() {
    if (event.keyCode == 13) {
        event.returnValue = false;
        event.cancel = true;
        login();
    }
}

