function insertDefaultProducts(){
    let products = [];

    let product1 = {};
    product1.name = "Jean jacket & Dress";
    product1.description = "Blue jean jacket and beige dress.";
    product1.tags = "jacket;dress;clothes";
    product1.price = 599;
    product1.type = 1;
    product1.img = "1-1.jpg";
    products[0] = product1;

    let product2 = {};
    product2.name = "Denim jacket";
    product2.description = "Light blue trendy denim jacket.";
    product2.tags = "jacket;shirt;fashion";
    product2.price = 499.0;
    product2.type = 1;
    product2.img = "1-2.jpg";
    products[1] = product2;

    let product3 = {};
    product3.name = "Macbook Pro 16";
    product3.description = "The best for the brightest.";
    product3.tags = "laptop;pc;apple;macos";
    product3.price = 18900.0;
    product3.type = 2;
    product3.img = "2-1.jpg";
    products[2] = product3;

    let product4 = {};
    product4.name = "Iphone 12";
    product4.description = "Blast past fast.";
    product4.tags = "phone;ios;apple";
    product4.price = 8499.0;
    product4.type = 2;
    product4.img = "2-2.jpg";
    products[3] = product4;

    let product5 = {};
    product5.name = "Jane Eyre";
    product5.description = "Jane Eyre is very much the story of a quest to be loved. Jane searches, " +
        "not just for romantic love, but also for a sense of being valued, of belonging.";
    product5.tags = "book;Charlotte Brontë;Jane";
    product5.price = 49.0;
    product5.type = 3;
    product5.img = "3-1.jpg";
    products[4] = product5;

    let product6 = {};
    product6.name = "Working Effectively with Legacy Code";
    product6.description = "Help you improve your work efficiency when you face legacy systems.";
    product6.tags = "software;computer science";
    product6.price = 69.0;
    product6.type = 3;
    product6.img = "3-2.jpg";
    products[5] = product6;

    let product7 = {};
    product7.name = "A Brief History of Time";
    product7.description = "Explain a range of subjects in cosmology, including the Big Bang, " +
        "black holes and light cones to the non-specialist reader.";
    product7.tags = "cosmology;stephen hawking";
    product7.price = 79.0;
    product7.type = 3;
    product7.img = "3-3.jpg";
    products[6] = product7;

    let product8 = {};
    product8.name = "Genshin Impact";
    product8.description = "Genshin Impact is a free-to-play open-world adventure RPG made by miHoYo.";
    product8.tags = "game;f2p;mihoyo";
    product8.price = 648.0;
    product8.type = 4;
    product8.img = "4-1.jpg";
    products[7] = product8;

    let product9 = {};
    product9.name = "Nintendo Switch";
    product9.description = "The Nintendo Switch system transforms from home console to handheld, " +
        "letting you play your favorite games at home or on the go.";
    product9.tags = "game;switch";
    product9.price = 79.0;
    product9.type = 4;
    product9.img = "4-2.jpg";
    products[8] = product9;

    let product10 = {};
    product10.name = "Hatsune Miku 1/7 Scale Figure (Memorial Dress Ver.) ";
    product10.description = "From the past to the future, reaching ever higher. ";
    product10.tags = "miku;gsc;figure";
    product10.price = 2499.0;
    product10.type = 4;
    product10.img = "4-4.jpg";
    products[9] = product10;

    let product11 = {};
    product11.name = "Xiaomi Mi TV LUX Transparent OLED TV";
    product11.description = "Billed as a world's first, the Mi TV LUX features an edge-to-edge transparent display, " +
        "leaving what looks like a simple glass screen, allowing viewers to see through to the other side. ";
    product11.price = 49999.0;
    product11.type = 5;
    product11.img = "5-1.jpg";
    products[10] = product11;

    let success = 0;
    products.forEach(product => success += insertProduct(product));
    layer.msg("Plan to insert " + products.length + "product, success " + success + ", fail " + products.length - success);
}

function insertProduct(product) {
    $.ajax({
        async : false,
        type : 'POST',
        url : 'v1/product',
        data : product,
        dataType : 'json',
        success : function(result) {
            if(result.status === 1){
                return 1;
            }
            else {
                return 0;
            }
        },
        error : function() {
            layer.alert('Server Error' + product.name);
        }
    });
}
