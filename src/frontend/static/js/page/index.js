let loading = layer.load(0);

let productType = new Array;
productType[1] = "Clothes";
productType[2] = "Electronics";
productType[3] = "Books & Business";
productType[4] = "Game & Toys";
productType[5] = "Home";
productType[6] = "Beauty";
productType[7] = "Sports";


listProducts();

function listProducts() {
    let allProduct = getAllProducts();
    let mark = new Array;
    mark[1] = 0;
    mark[2] = 0;
    mark[3] = 0;
    mark[4] = 0;
    mark[5] = 0;
    mark[6] = 0;
    mark[7] = 0;
    for(let i=0;i<allProduct.length;i++){
        let html = "";
        let imgURL = "./img/"+allProduct[i].id+".jpg";
        html += '<div class="col-sm-4 col-md-4" >'+
            '<div class="boxes pointer" onclick="productDetail('+allProduct[i].id+')">'+
            '<div class="big bigimg">'+
            '<img src="'+imgURL+'">'+
            '</div>'+
            '<p class="product-name">'+allProduct[i].name+'</p>'+
            '<p class="product-price">¥'+allProduct[i].price+'</p>'+
            '</div>'+
            '</div>';
        let id = "productArea"+allProduct[i].type;
        let productArea = document.getElementById(id);
        if(mark[allProduct[i].type] == 0){
            html ='<hr/><h1>'+productType[allProduct[i].type]+'</h1><hr/>'+html;
            mark[allProduct[i].type] = 1;
        }
        productArea.innerHTML += html;
    }
    layer.close(loading);
}
function getAllProducts() {
    let allProducts = null;
    let nothing = {};
    $.ajax({
        async : false, //设置同步
        type : 'POST',
        url : './getAllProducts',
        data : nothing,
        dataType : 'json',
        success : function(result) {
            if (result!=null) {
                allProducts = result.allProducts;
            }
            else{
                layer.alert('查询错误');
            }
        },
        error : function(resoult) {
            layer.alert('查询错误');
        }
    });
    //划重点划重点，这里的eval方法不同于prase方法，外面加括号
    allProducts = eval("("+allProducts+")");
    return allProducts;
}

function productDetail(id) {
    let product = {};
    let jumpResult = '';
    product.id = id;
    $.ajax({
        async : false, //设置同步
        type : 'POST',
        url : './productDetail',
        data : product,
        dataType : 'json',
        success : function(result) {
            jumpResult = result.result;
        },
        error : function(resoult) {
            layer.alert('查询错误');
        }
    });

    if(jumpResult == "success"){
        window.location.href = "./product_detail";
    }
}