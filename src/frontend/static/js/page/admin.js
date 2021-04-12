let loading = layer.load(0);

listUser(1, 100);

listProduct(1, 100);

layer.close(loading);

//列出所有用户
function listUser(page, number) {
    let userTable = document.getElementById("userTable");
    let allUser = getUser(page, number);
    userTable.innerHTML = '<tr>'+
        '<th> User ID </th>'+
        '<th> Username</th>'+
        '<th> Nickname</th>'+
        '<th> Email</th>'+
        '<th> Operation</th>'+
        '</tr>';
    let html = "";
    for(let i=0;i<allUser.length;i++){
        html += '<tr>'+
            '<td>'+allUser[i].id+'</td>'+
            '<td>'+allUser[i].name+'</td>'+
            '<td>'+allUser[i].nickName+'</td>'+
            '<td>'+allUser[i].email+'</td>'+
            '<td>'+
            '<button class="btn btn-primary btn-sm" type="submit" onclick="deleteUser('+allUser[i].id+')">Delete</button>'+
            '</td>'+
            '</tr>';
    }
    userTable.innerHTML += html;
}

function getUser(page, number) {
    let allUsers = "";
    $.ajax({
        async : false, //设置同步
        type : 'POST',
        url : 'v1/user/' + page + '/' + number,
        dataType : 'json',
        success : function(result) {
            if (result.status === 1) {
                allUsers = result.content;
            }
            else{
                layer.alert('Get user error. ' + result.message);
            }
        },
        error : function() {
            layer.alert('Server error!');
        }
    });
    return allUsers;
}


function listProduct(page, number) {
    let productArea = document.getElementById("productArea");
    let allProduct = getAllProducts(page, number);
    let html="";
    productArea.innerHTML = '';
    for(let i=0;i<allProduct.length;i++){
        let imgURL = "../img/"+allProduct[i].id+".jpg";
        html+='<div class="col-sm-4 col-md-4 pd-5">'+
            '<div class="boxes">'+
            '<div class="big bigimg">'+
            '<img src="'+imgURL+'">'+
            '</div>'+
            '<p class="font-styles center">'+allProduct[i].name+'</p>'+
            '<p class="pull-right">价格：'+allProduct[i].price+'</p>'+
            '<p class="pull-left">库存：'+allProduct[i].counts+'</p>'+
            '<div class = "row">'+
            '<button class="btn btn-primary delete-button" type="submit" onclick="deleteProduct('+allProduct[i].id+')">删除商品</button>'+
            '</div>'+
            '</div>'+
            '</div>';
    }
    productArea.innerHTML+=html;
}
//列出所有商品

function getAllProducts(page, number) {
    let allProducts = null;
    $.ajax({
        async : false, //设置同步
        type : 'POST',
        url : 'v1/product/' + page + '/' + number,
        dataType : 'json',
        success : function(result) {
            if (result.status === 1) {
                allProducts = result.content;
            }
            else{
                layer.alert('Get product error! ' + result.message);
            }
        },
        error : function() {
            layer.alert('Server error!');
        }
    });
    allProducts = eval("("+allProducts+")");
    return allProducts;
}

function deleteUser(id) {
    let user = {};
    user.id = id;
    let deleteResult = "";
    $.ajax({
        async : false,
        type : 'DELETE',
        url : 'v1/user',
        data : user,
        dataType : 'json',
        success : function(result) {
            if(result.status === 1){
                deleteResult = result.message;
            }
            else {
                layer.alert("Delete user error! " + result.message)
            }
        },
        error : function() {
            layer.alert('Server error!');
        }
    });
    listUser(1, 100);
}

function deleteProduct(id) {
    let product = {};
    product.id = id;
    let deleteResult = "";
    $.ajax({
        async : false,
        type : 'DELETE',
        url : 'v1/product',
        data : product,
        dataType : 'json',
        success : function(result) {
            if(result.status === 1){
                deleteResult = result.message;
            }
            else {
                layer.alert("Delete product error! " + result.message)
            }
        },
        error : function() {
            layer.alert('Server error!');
        }
    });
    listProduct(1, 100);
}

function addProduct() {
    let loadings = layer.load(0);
    let product = {};
    product.name = document.getElementById("productName").value;
    product.description = document.getElementById("productDescribe").value;
    product.tags = document.getElementById("tags").value;
    product.price = document.getElementById("productPrice").value;
    product.counts = document.getElementById("productCount").value;
    product.type = document.getElementById("productType").value;
    $.ajax({
        async : false,
        type : 'POST',
        url : 'v1/product',
        data : product,
        dataType : 'json',
        success : function(result) {
            if(result.status === 1){
                fileUpload();
                layer.msg('Add product success.', {icon: 1, time: 1000});
                layer.close(loadings)
            }
            else {
                layer.alert("Add product error! " + result.message)
            }
        },
        error : function() {
            layer.alert('Server Error');
        }
    });
    listProduct(1, 100);
}

function fileUpload() {
    let results = "";
    let name = document.getElementById("productName").value;
    $.ajaxFileUpload({
        url:'v1/image',
        secureuri:false ,
        fileElementId:'productImgUpload',
        type:'POST',
        dataType : 'text',
        success: function (result){
            result = result.replace(/<pre.*?>/g, '');  //ajaxFileUpload会对服务器响应回来的text内容加上<pre style="....">text</pre>前后缀
            result = result.replace(/<PRE.*?>/g, '');
            result = result.replace("<PRE>", '');
            result = result.replace("</PRE>", '');
            result = result.replace("<pre>", '');
            result = result.replace("</pre>", '');
            result = JSON.parse(result);
            results = result.result;
            if(results.status === 1) {
                layer.msg("Image upload success!", {icon: 1});
            }
            else {
                layer.msg("Image upload fail!", {icon: 0});
            }
        },
        error: function ()
        {
            layer.alert("Server error!");
        }}
    );
}