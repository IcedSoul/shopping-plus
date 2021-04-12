function register() {
    let loading = layer.load(0);
    let user = {};
    user.username = $("#inputUserName").val();
    user.email = $("#inputEmail").val();
    user.nickname = $("#inputNickname").val();
    user.password = $("#inputPassword").val();
    user.phoneNumber = $("#inputPhoneNumber").val();
    user.birthday = $("#birthday").val();
    // user.sex = 0;
    // if($("#woman").checked)
    //     user.sex = 1;
    if(user.username === ''){
        layer.msg('Username cannot be empty!',{icon:2});
        return;
    }
    else if(user.username.length >= 12){
        layer.msg('User Name cannot be longer than 12 characters!',{icon:2});
        return;
    }
    if(user.nickname === ''){
        layer.msg('Nicknames cannot be empty!',{icon:2});
        return;
    }
    else if(user.nickname.length >= 15){
        layer.msg('Username cannot be longer than 15 characters!',{icon:2});
        return;
    }
    else if(user.password === ''){
        layer.msg('Password cannot be empty!',{icon:2});
        return;
    }
    else if(user.password.length>= 20){
        layer.msg('Password cannot be longer than 20 characters!',{icon:2});
        return;
    }
    let registerResult = null;
    $.ajax({
        async : false, //设置同步
        type : 'POST',
        url : 'v1/user',
        data : user,
        dataType : 'json',
        success : function(result) {
            layer.close(loading);
            registerResult = result;
        },
        error : function() {
            layer.close(loading);
            layer.alert('Server Error!');
        }
    });
    if(registerResult.status === 1){
        layer.msg('Sign up success',{icon:1});
        window.location.href="login.html";
    }
    else if(registerResult.status === -1){
        layer.msg(registerResult.msg,{icon:2});
    }
}