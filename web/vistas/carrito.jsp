<%-- 
    Document   : carrito
    Created on : 6/12/2024, 7:15:57 p. m.
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="../Css/Carrito.css">
    <script src="../js/app.js"></script>
    <title>CARRITO DE COMPRAS </title>
</head>
<body>
<header>
    <div class="title">
        <img src="../Img/lanas.png" alt="Imagen" class="imagen1">
        <h1 class="title"> Michigurumis Creations </h1>
        <img src="../Img/lanas.png" alt="Imagen" class="imagen2">
        <form class="searchbar">
            <input type="search" placeholder="Buscar"/>
            <button type="Submit"> Buscar </button> 

        </form>

    </div>
<div class="name-cart">
    <div class="main-h1">
    <h1>CARRITO MICHIGURUMIS</h1>
</div>
    <div class="menu-banner">
        <a href="./index">Inicio</a>

    </div>
    </div>
</header>


    <section class="contenedor">
        <div class="contenedor-items">
            <div class="item">
                <span class="titulo-item">Chimuelo Blanco</span>
                <img src="../Img/Chimuelo Blanco.jpg.jpg" alt="" class="img-item">
                <span class="precio-item">$20.000</span>
                <button class="boton-item">Añadir a mis selecciones</button>
            </div>
            <div class="item">
                <span class="titulo-item">Deadpool</span>
                <img src="../Img/Deadpool.png" alt="" class="img-item">
                <span class="precio-item">$28.000</span>
                <button class="boton-item">Añadir a mis selecciones</button>
            </div>
            <div class="item">
                <span class="titulo-item">Flores con personaje</span>
                <img src="../Img/Flores.png" alt="" class="img-item">
                <span class="precio-item">$135.000</span>
                <button class="boton-item">Añadir a mis selecciones</button>
            </div>
            <div class="item">
                <span class="titulo-item">Girasol</span>
                <img src="../Img/GIRASOL.PNG" alt="" class="img-item">
                <span class="precio-item">$23.000</span>
                <button class="boton-item">Añadir a mis selecciones</button>
            </div>
            <div class="item">
                <span class="titulo-item">Kirby</span>
                <img src="../Img/Kirby.png" alt="" class="img-item">
                <span class="precio-item">$35.000</span>
                <button class="boton-item">Añadir a mis selecciones</button>
            </div>
            <div class="item">
                <span class="titulo-item">Mapache</span>
                <img src="../Img/Mapache.png" alt="" class="img-item">
                <span class="precio-item">$25.000</span>
                <button class="boton-item">Añadir a mis selecciones</button>
            </div>
            <div class="item">
                <span class="titulo-item">Luffy</span>
                <img src="../Img/Rojo.png" alt="" class="img-item">
                <span class="precio-item">$50.000</span>
                <button class="boton-item">Añadir a mis selecciones</button>
            </div>
            <div class="item">
                <span class="titulo-item">Vaquita</span>
                <img src="../Img/VAQUITA.PNG" alt="" class="img-item">
                <span class="precio-item">$45.000</span>
                <button class="boton-item">Añadir a mis selecciones</button>
            </div>
           
        </div>
        <!-- Carrito de Compras -->
        <div class="carrito" id="carrito">
            <div class="header-carrito">
                <h2>Tus selecciones</h2>
            </div>

            <div class="carrito-items">
                
            </div>
            <div class="carrito-total">
                <div class="fila">
                    <strong>Tu Total</strong>
                    <span class="carrito-precio-total">
                        $120.000,00
                    </span>
                </div>
                <a href="../pagina/factura" class="btn-pagar"> Pagar <i class="fa-solid fa-bag-shopping"></i> </a>
            </div>
        </div>
    </section>

    
</body>
    
</html>
