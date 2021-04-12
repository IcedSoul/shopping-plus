hiddenElement();
checkLoginStatus();


function hiddenElement(){
    $(".no-login").hide()
    $(".login").hide()
    $(".admin").hide()
}

function checkLoginStatus(){
    let user = getUserInfo();
    if(user === null){
        $(".no-login").show();
    }
    else {
        $(".no-login").show()
        $("#user-name").val(user.nickname);
        if(user.role === 1){
            $(".admin").show();
        }
    }
}


function searchProduct() {
    let search = {};
    search.searchKeyWord = document.getElementById("searchKeyWord").value;
    let searchResult = "";
    $.ajax({
        async : false,
        type : 'POST',
        url : '../searchPre',
        data : search,
        dataType : 'json',
        success : function(result) {
            searchResult = result.result;
        },
        error : function(result) {
            layer.alert('查询错误');
        }
    });
    if(searchResult == "success")
        window.location.href = "../search";
}