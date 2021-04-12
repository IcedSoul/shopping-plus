function startLogin() {
    let loading = layer.load(0);
    let user = {};
    let loginResult = "";
    user.userNameOrEmail = $("#inputEmail").val();
    user.password = $("#inputPassword").val();
    $.ajax({
        async : false,
        type : 'GET',
        url : 'v1/auth',
        data : user,
        dataType : 'json',
        success : function(result) {
            layer.close(loading);
            loginResult = result;
        },
        error : function() {
            layer.close(loading);
            layer.alert('Server error!');
        }
    });

    if(loginResult.status === 1){
        layer.msg('Sign in success.',{icon:1});
        window.location.href = "index.html";
    }
    else {
        layer.msg(loginResult.msg,{icon:2});
    }
}