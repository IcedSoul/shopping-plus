let loading = layer.load(0);

let productType = [];
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
    let mark = [];
    mark[1] = 0;
    mark[2] = 0;
    mark[3] = 0;
    mark[4] = 0;
    mark[5] = 0;
    mark[6] = 0;
    mark[7] = 0;
    for(let i=0; i<allProduct.length; i++){
        let html = "";
        let imgURL = "img/"+allProduct[i].img;
        html += '<div class="col-sm-4 col-md-4" >'+
            '<div class="boxes pointer" onclick="productDetail('+allProduct[i].id+')">'+
            '<div class="big bigimg">'+
            '<img src="'+imgURL+'">'+
            '</div>'+
            '<p class="product-name">' + allProduct[i].name + '</p>'+
            '<p class="product-price">¥' + allProduct[i].price + '</p>'+
            '</div>'+
            '</div>';
        let id = "productArea" + allProduct[i].type;
        let productArea = document.getElementById(id);
        if(mark[allProduct[i].type] === 0){
            html ='<hr/><h1>'+productType[allProduct[i].type]+'</h1><hr/>'+html;
            mark[allProduct[i].type] = 1;
        }
        productArea.innerHTML += html;
    }
    layer.close(loading);
}
function getAllProducts() {
    let allProducts = null;
    $.ajax({
        async : false, //设置同步
        type : 'GET',
        url : 'v1/product?page=' + 1+ '&number' + 100,
        dataType : 'json',
        success : function(result) {
            if (result.status === 1) {
                allProducts = result.content;
            }
            else{
                layer.alert(result.message);
            }
        },
        error : function(result) {
            layer.alert('Server Error' + result);
        }
    });
    //划重点划重点，这里的eval方法不同于parse方法，外面加括号
    allProducts = eval("("+allProducts+")");
    return allProducts;
}