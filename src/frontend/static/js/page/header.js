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