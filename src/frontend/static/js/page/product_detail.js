listEvaluations();

function addToShoppingCar(productId) {
    judgeIsLogin();
    let productCounts = document.getElementById("productCounts");
    let counts = parseInt(productCounts.innerHTML);
    let shoppingCar = {};
    shoppingCar.userId = "${currentUser.id}";
    shoppingCar.productId = productId;
    shoppingCar.counts = counts;
    let addResult = "";
    $.ajax({
        async : false,
        type : 'POST',
        url : '${cp}/addShoppingCar',
        data : shoppingCar,
        dataType : 'json',
        success : function(result) {
            addResult = result.result;
        },
        error : function(result) {
            layer.alert('查询用户错误');
        }
    });
    if(addResult == "success") {
        layer.confirm('前往购物车？', {icon: 1, title:'添加成功',btn:['前往购物车','继续浏览']},
            function(){
                window.location.href = "${cp}/shopping_car";
            },
            function(index){
                layer.close(index);}
        );
    }
}

function judgeIsLogin() {
    if("${currentUser.id}" == null || "${currentUser.id}" === undefined || "${currentUser.id}" ===""){
        window.location.href = "${cp}/login";
    }
}

function subCounts() {
    let productCounts = document.getElementById("productCounts");
    let counts = parseInt(productCounts.innerHTML);
    if(counts>=2)
        counts--;
    productCounts.innerHTML = counts;
}

function addCounts() {
    let productCounts = document.getElementById("productCounts");
    let counts = parseInt(productCounts.innerHTML);
    if(counts < productInventory.number)
        counts++;
    productCounts.innerHTML = counts;
}

function buyConfirm(productId) {
    judgeIsLogin();
    let address = getUserAddress("${currentUser.id}");
    let phoneNumber = getUserPhoneNumber("${currentUser.id}");
    let productCounts = document.getElementById("productCounts");
    let counts = parseInt(productCounts.innerHTML);
    let product = getProductById(productId);
    let html = '<div class="col-sm-1 col-md-1 col-lg-1"></div>'+
        '<div class="col-sm-10 col-md-10 col-lg-10">'+
        '<table class="table confirm-margin">'+
        '<tr>'+
        '<th>商品名称：</th>'+
        '<td>'+product.name+'</td>'+
        '</tr>'+
        '<tr>'+
        '<th>商品单价：</th>'+
        '<td>'+product.price+'</td>'+
        '</tr>'+
        '<tr>'+
        '<th>购买数量：</th>'+
        '<td>'+counts+'</td>'+
        '</tr>'+
        '<tr>'+
        '<th>总金额：</th>'+
        '<td>'+counts*product.price+'</td>'+
        '</tr>'+
        '<tr>'+
        '<th>收货地址：</th>'+
        '<td>'+address+'</td>'+
        '</tr>'+
        '<tr>'+
        '<th>联系电话：</th>'+
        '<td>'+phoneNumber+'</td>'+
        '</tr>'+
        '</table>'+
        '<div class="row">'+
        '<div class="col-sm-4 col-md-4 col-lg-4"></div>'+
        '<button class="btn btn-danger col-sm-4 col-md-4 col-lg-4" onclick="addToShoppingRecords('+productId+')">确认购买</button>'+
        '</div>'+
        '</div>';
    layer.open({
        type:1,
        title:'请确认订单信息：',
        content:html,
        area:['650px','350px'],
    });
}

function getProductById(id) {
    let productResult = "";
    let product = {};
    product.id = id;
    $.ajax({
        async : false, //设置同步
        type : 'POST',
        url : '${cp}/getProductById',
        data : product,
        dataType : 'json',
        success : function(result) {
            productResult = result.result;
        },
        error : function(result) {
            layer.alert('查询错误');
        }
    });
    productResult = JSON.parse(productResult);
    return productResult;
}

function getUserAddress(id) {
    let address = "";
    let user = {};
    user.id = id;
    $.ajax({
        async : false, //设置同步
        type : 'POST',
        url : '${cp}/getUserAddressAndPhoneNumber',
        data : user,
        dataType : 'json',
        success : function(result) {
            address = result.address;
        },
        error : function(result) {
            layer.alert('查询错误');
        }
    });
    return address;
}

function getUserPhoneNumber(id) {
    let phoneNumber = "";
    let user = {};
    user.id = id;
    $.ajax({
        async : false, //设置同步
        type : 'POST',
        url : '${cp}/getUserAddressAndPhoneNumber',
        data : user,
        dataType : 'json',
        success : function(result) {
            phoneNumber = result.phoneNumber;
        },
        error : function(result) {
            layer.alert('查询错误');
        }
    });
    return phoneNumber;
}

function addToShoppingRecords(productId) {
    let productCounts = document.getElementById("productCounts");
    let counts = parseInt(productCounts.innerHTML);
    let shoppingRecord = {};
    shoppingRecord.userId = "${currentUser.id}";
    shoppingRecord.productId = productId;
    shoppingRecord.counts = counts;
    let buyResult = "";
    $.ajax({
        async : false,
        type : 'POST',
        url : '${cp}/addShoppingRecord',
        data : shoppingRecord,
        dataType : 'json',
        success : function(result) {
            buyResult = result.result;
        },
        error : function(result) {
            layer.alert('购买错误');
        }
    });
    if(buyResult === "success") {
        layer.confirm('前往订单状态？', {icon: 1, title:'购买成功',btn:['前往订单','继续购买']},
            function(){
                window.location.href = "${cp}/shopping_record";
            },
            function(index){
                layer.close(index);}
        );
    }
    else if(buyResult === "unEnough"){
        layer.alert("库存不足，购买失败")
    }
}

function listEvaluations() {
    let evaluations = getEvaluations();
    let evaluationTable = document.getElementById("evaluation");
    let html = "";
    for(let i=0;i<evaluations.length;i++){
        let user = getUserById(evaluations[i].userId);
        html+='<tr>'+
            '<th>'+user.nickName+'</th>'+
            '<td>'+evaluations[i].content+'</td>'+
            '</tr>';
    }
    evaluationTable.innerHTML += html;

    if("${currentUser}"!=="" && getUserProductRecord() === "true"){
        let inputArea = document.getElementById("inputArea");
        html= '<div class="col-sm-12 col-md-12 col-lg-12">'+
            '<textarea class="form-control" rows="4" id="evaluationText"></textarea>'+
            '</div>'+
            '<div class="col-sm-12 col-md-12 col-lg-12">'+
            '<div class="col-sm-4 col-md-4 col-lg-4"></div>'+
            '<button class="btn btn-primary btn-lg evaluationButton col-sm-4 col-md-4 col-lg-4" onclick="addToEvaluation()">评价</button>'+
            '</div>';
        inputArea.innerHTML +=html;
    }

}

function getUserProductRecord() {
    let results = "";
    let product = {};
    product.userId = user.id;
    product.productId = product.id;
    $.ajax({
        async : false, //设置同步
        type : 'POST',
        url : 'v1/order?',
        data : product,
        dataType : 'json',
        success : function(result) {
            results = result.result;
        },
        error : function(result) {
            layer.alert('查询错误');
        }
    });
    return results;
}

function getEvaluations() {
    let evaluations = "";
    let product = {};
    product.productId = "${productDetail.id}";
    $.ajax({
        async : false, //设置同步
        type : 'POST',
        url : '${cp}/getShoppingEvaluations',
        data : product,
        dataType : 'json',
        success : function(result) {
            evaluations = result.result;
        },
        error : function(result) {
            layer.alert('查询错误');
        }
    });
    evaluations = eval("("+evaluations+")");
    return evaluations;
}

function getUserById(id) {
    let userResult = "";
    let user = {};
    user.id = id;
    $.ajax({
        async : false, //设置同步
        type : 'POST',
        url : '${cp}/getUserById',
        data : user,
        dataType : 'json',
        success : function(result) {
            userResult = result.result;
        },
        error : function(result) {
            layer.alert('查询错误');
        }
    });
    userResult = JSON.parse(userResult);
    return userResult;
}

function addToEvaluation() {
    let inputText = document.getElementById("evaluationText").value;
    let evaluation = {};
    evaluation.userId = "${currentUser.id}";
    evaluation.productId = "${productDetail.id}";
    evaluation.content = inputText;
    let addResult = "";
    $.ajax({
        async : false,
        type : 'POST',
        url : '${cp}/addShoppingEvaluation',
        data : evaluation,
        dataType : 'json',
        success : function(result) {
            addResult = result.result;
        },
        error : function(result) {
            layer.alert('查询用户错误');
        }
    });
    if(addResult = "success"){
        layer.msg("评价成功",{icon:1});
        window.location.href = "${cp}/product_detail";
    }
}

function productDetail(id) {
    let product = {};
    let jumpResult = '';
    product.id = id;
    $.ajax({
        async : false, //设置同步
        type : 'GET',
        url : 'v1/product/' + id,
        dataType : 'json',
        success : function(result) {
            jumpResult = result.result;
        },
        error : function(result) {
            layer.alert('查询错误' + result);
        }
    });

    if(jumpResult === "success"){
        window.location.href = "./product_detail";
    }
}