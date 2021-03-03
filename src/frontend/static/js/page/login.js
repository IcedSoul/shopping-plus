function register() {
    let loading = layer.load(0);
    let user = {};
    user.userName = $("#inputUserName").val();
    user.email = $("#inputEmail").val();
    user.nickName = $("#inputNickname").val();
    user.password = $("#inputPassword").val();
    user.phoneNumber = $("#inputPhoneNumber").val();
    user.birthday = $("#birthday").val();
    user.postNumber = $("#postcodes").val();
    user.address = $("#address").val();
    user.sex = 0;
    if($("#woman").checked)
        user.sex = 1;
    if(user.userName === ''){
        layer.msg('Username cannot be empty!',{icon:2});
        return;
    }
    else if(user.userName.length >= 12){
        layer.msg('User Name cannot be longer than 12 characters!',{icon:2});
        return;
    }
    if(user.nickName === ''){
        layer.msg('Nicknames cannot be empty!',{icon:2});
        return;
    }
    else if(user.nickName.length >= 15){
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
        url : '/user/register',
        data : user,
        dataType : 'json',
        success : function(result) {
            registerResult = result.result;
        },
        error : function(result) {
            layer.alert('Register Error: ' + result);
        }
    });
    if(registerResult === 'success'){
        layer.close(loading);
        layer.msg('Sign up success',{icon:1});
        window.location.href="${cp}/login";
    }
    else if(registerResult === 'nameExist'){
        layer.close(loading);
        layer.msg('The username has existed!',{icon:2});
    }
    else if(registerResult === 'emailExist'){
        layer.close(loading);
        layer.msg('The e-mail address has existed!！',{icon:2});
    }
    else if(registerResult === 'fail'){
        layer.close(loading);
        layer.msg('Server Error!',{icon:2});
    }
}