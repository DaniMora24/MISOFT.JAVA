<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=, initial-scale=1.0">
    <title>Misoft</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css"/>
    <link rel="stylesheet" href="./Css/Pagina_Css.css">
    
</head>

<body>

    <header>
        <div class="title">
            <img src="./Img/lanas.png" alt="Imagen" class="imagen1">
            <h1 class="title"> Michigurumis Creations </h1>
            <img src="./Img/lanas.png" alt="Imagen" class="imagen2">
            <form class="searchbar">
                <input type="search" placeholder="Buscar"/>
                <button type="Submit"> Buscar </button> 

            </form>

        </div>
       

        <!--Menu-->
        <div class="menu container">

            <img class="logo-1" src="./Img/Logo-Michi.PNG.png" alt="">
            <input type="radio" class="logomenu" />
            <img class="menulog" src="./Img/menu.png" alt="">
            <nav class="navbar">

                <div class="menu-1">
                    <ul>

                        <li> <button><a href="#">Inicio</a></button> </li>
                        <li> <button><a href="#">Envíos</a></button> </li>
                        <li> <button><a href="#productos">Catálogo</a></button> </li>
                        <li> <button><a href="#Nosotros">Nosotros</a></button></li>


                    </ul>
                </div>

              

                <div class="menu-2">
                    <nav>
                    <ul>
                         <li> <a href="login" class="btn-2" id="Loginbutton">Inicio Sesión</a> </li>
                         <li> <a href="registro"class="btn-2" id="Loginbutton">Registrarse</a></li>

                    </ul>
                </nav>
                </div>
            </nav>
        </div>
        <div class="banner">
            <div class="cuadro">
            <div class="texto">
            <h1> ¡Una michibienvenida a Michigurumis creations! </h1>
            <h3> Aquí, creemos que cada punto de crochet es un recuerdo que se teje con amor. En nuestro taller, nos apasiona crear objetos únicos y personalizados que te permitan llevar un pedacito de nostalgia y cariño contigo. ¡Únete a nosotros y teje recuerdos que durarán toda la vida! Explora nuestra tienda, conoce nuestra historia y descubre cómo podemos ayudarte a crear tus propios recuerdos tejidos con amor. </h3>
            <p>Registrate o inicia sesión para que no te pierdas nuestras increíbles ofertas</p>
        </div>
    </div>
        <div class="Image-button">
        
            <img src="./Img/logo michigurumis.jpg" alt="imagen de bienvenida" class="Image">
        <div class="opciones">
        
            <a href="{{ route('login') }}" class="btn-2" id="Loginbutton">Inicio Sesion</a> 
           <a href="{{ route('registro') }}"class="btn-2" id="Loginbutton">Registrarse</a>

        
        </div>

       
    

        
        </div>
        </div>

        <div class="header-content  container">
            <!--Slide-->
            <div class="swiper mySwiper-1">
                <div class="swiper-wrapper">

                    <div class="swiper-slide">
                        <div class="slide">
                            <div class="slide-txt">
                                <h1> Luffy </h1>
                                <p>
                                    ¡Lleva contigo a tu personaje favorito de One Piece! Este adorable llavero o decoración está confeccionado con lana de alta calidad y 
                                    es perfecto para cualquier fanático del anime. Regálalo a alguien especial o consíguelo para ti mismo, ¡será un detalle que hará sonreír a 
                                    cualquier amante de One Piece!
                                </p>

                                <div class="botones">
                                <a href="./pagina/carrito" class="btn-1">Comprar</a>
                                </div>

                            </div>
                            <div class="slide-img">

                                <img src="./Img/Luffy.jpg.jpg" alt="">
                            </div>
                        </div>
                    </div>

                    <div class="swiper-slide">
                        <div class="slide">
                            <div class="slide-txt">
                                <h1> Kirby </h1>
                                <p>
                                  ¡La estrella de Kirby ha aterrizado en Michigurumis! Este tierno Kirby sentado en su estrella es el compañero perfecto para cualquier 
                                  fanático del videojuego. Confeccionado con lana de alta calidad y detalles precisos, este Kirby es una de arte que te hará sonreír. 
                                  Regálalo a un amigo o personita especial, o también, consíguelo para ti mismo, ¡será un detalle que brillará en tu colección!
                                </p>

                                <div class="botones">
                                <a href="./pagina/carrito" class="btn-1">Comprar</a>
                                </div>

                            </div>
                            <div class="slide-img">

                                <img src="./Img/Kirby.jpg.jpg" alt="">
                            </div>
                        </div>
                    </div>

                    <div class="swiper-slide">
                        <div class="slide">
                            <div class="slide-txt">
                                <h1> Mapache </h1>
                                <p>
                                    ¡Descubre el encanto de la naturaleza con este encantador mapache! Confeccionado con materiales 
                                    de alta calidad, este pequeño mapache es una pieza de arte con la que podrás sentir la magia de la naturaleza. 
                                    Su mirada curiosa y su pelaje suave lo hacen perfecto para decorar tu hohar o regalarlo a una persona especial. 
                                    ¡Un detalle que te recordará la belleza de la naturaleza!
                                </p>

                                <div class="botones">
                                <a href="./pagina/carrito" class="btn-1">Comprar</a>
                                </div>

                            </div>
                            <div class="slide-img">

                                <img src="./Img/Mapache.jpg.jpg" alt="">
                            </div>
                        </div>
                    </div>



                    <!--Botones para el Slide-->
                </div>
                <div class="swiper-button-prev"></div>
                <div class="swiper-button-next"></div>
            
               

            </div>


        </div>


    </header>

    <!--Productos-->
    <main class="products" id="productos">

        <div class="tabs container">
            <!--Tab 1-->
            <input type="radio" name="tabs" id="tab1" checked="checked" class="tabInput" value="1">
            <label for="tab1">Héroes</label>
            <div class="tab">
                <div class="swiper mySwiper-2" id="swiper1">
                    <!--Estan los productos-->
                    <div class="swiper-wrapper">

                        <!--Para Agregar Productos-->
                        <div class="swiper-slide">
                            <div class="product">
                                <div class="product-img">
                                    
                                    <img src="./Img/Deadpool.jpg.jpg" alt="">
                                </div>

                                <div class="product-txt">
                                    <h4 class="h4-2">Deadpool</h4>
                                     <p><b>¡Llegó el mercenario mas loco y divertido a tu llavero!</b></p>
                                    <p>Es Deadpool, confeccionado con lana de la mejor calidad y la mejor técnica en crochet. 
                                        Es perfecto para ese fan de marvel que busca algo diferente.</p>
                                    <p><b>Detalles del producto:</b></p>
                                    <p><b>Tamaño:</b> 15 cm aproximadamente</p>
                                    <p><b>Material:</b> Lana tipo algodón</p>
                                    <p><b>Incluye:</b> Argolla para llavero plateada</p>
                                    <p><b>Precio:</b></p>
                                    <span class="price"> $40.000</span>

                                    <div class="btn-3">
                                    <a href="./pagina/carrito">Comprar</a>
                                    </div>

                                </div>
                            </div>
                        </div>


                        <div class="swiper-slide">
                            <div class="product">
                                <div class="product-img">
                                    
                                    <img src="./Img/wolverine.png" alt="">
                                </div>

                                <div class="product-txt">
                                    <h4 class="h4-2">Wolverine</h4>
                                    <p><b>¡Wolverine en tu poder!</b></p>
                                    <p>Este superhéroe feroz y legendario está confeccionado en lana de alta calidad y hecho con la mejor técnica de crochet. 
                                        Perfecto para esos amantes de los X-men ¡Únete a esta legión de mutantes! </p>
                                    <p><b>Detalles del producto:</b></p>
                                    <p><b>Tamaño:</b> 15 cm aproximadamente</p>
                                    <p><b>Material:</b> Lana tipo algodón</p>
                                    <p><b>Incluye:</b> Argolla para llavero plateada</p>
                                    <p><b>Precio:</b></p>
                                    <span class="price">$40.000</span>

                                    <div class="btn-3">
                                    <a href="./pagina/carrito">Comprar</a>
                                        </div>

                                </div>
                            </div>
                        </div>


                        <div class="swiper-slide">
                            <div class="product">
                                <div class="product-img">
                                    
                                    <img src="./Img/batman.png" alt="">
                                </div>

                                <div class="product-txt">
                                    <h4 class="h4-2">Batman</h4>
                                    <p><b>¡El caballero oscuro de ciudad gótica a tu bolsillo!</b></p>
                                    <p>El legendario señor de las tinieblas, confeccionado con los mejores materiales a 
                                        mano en crochet. Perfecto para regalar a esa personita fan de los cómics DC</p>
                                    <p><b>Detalles del producto:</b></p>
                                    <p><b>Tamaño:</b> 15 cm aproximadamente</p>
                                    <p><b>Material:</b> Lana tipo algodón</p>
                                    <p><b>Incluye:</b> Argolla para llavero plateada</p>
                                    <p><b>Precio:</b></p>
                                    <span class="price"><b>Precio:</b>$40.000</span>

                                    <div class="btn-3">
                                    <a href="./pagina/carrito">Comprar</a>
                                        </div>

                                </div>
                            </div>
                        </div>

                        <!--Se agrega el mismo codigo para mÃ¡s prodcutos-->

                    </div>

                    <!--Botones para productos-->
                    <div class="swiper-button-next"></div>
                    <div class="swiper-button-prev"></div>


                </div>
            </div>
            <!--Tab 2-->
            <input type="radio" name="tabs" id="tab2" checked="checked" class="tabInput" value="2">
            <label for="tab2">Animales</label>
            <div class="tab">
                <div class="swiper mySwiper-2" id="swiper2">
                    <!--Estan los productos-->
                    <div class="swiper-wrapper">

                        <!--Para Agregar Productos-->
                        <div class="swiper-slide">
                            <div class="product">
                                <div class="product-img">
                                    
                                     <img src="Img/vaca.jpg" alt=""/>
                                </div>

                                <div class="product-txt">
                                    <h4 class="h4-2">Vaca fresa</h4>
                                    <p><b>¡No es una vaca cualquiera!</b></p>
                                    <p>Nuestra vaca fresa es de nuestras obras maestras en crochet, con su ropa rosada, sus manchas pastel 
                                        y un hocico de rosa frambuesa. Y para darle un toque aún más especial, ¡lleva fresas como cachos!; 
                                        es un regalo perfecto para la persona fanática de la naturaleza.</p>
                                    <p><b>Detalles del producto:</b></p>
                                    <p><b>Tamaño:</b> 25 cm aproximadamente</p>
                                    <p><b>Material:</b> Lana chenille aterciopelada</p>
                                    <p><b>Incluye:</b> Ropa tejida</p>
                                    <p><b>Precio:</b></p>
                                    <span class="price">$60.000</span>

                                    <div class="btn-3">
                                    <a href="./pagina/carrito">Comprar</a>
                                        </div>

                                </div>
                            </div>
                        </div>


                        <div class="swiper-slide">
                            <div class="product">
                                <div class="product-img">
                                    
                                    <img src="Img/capibara.png" alt=""/>
                                </div>

                                <div class="product-txt">
                                    <h4 class="h4-2">Chigüiro</h4>
                                    <p><b>¡El chiguiro más fashion del llano!</b></p>
                                    <p>Nuestro chiguiro de crochet es muy tierno, con su gorrito adorable y su expresión relajada.
                                         Hecho con amor y detalle, para que puedas disfrutar de su compañía en cualquier momento.</p>
                                    <p><b>Detalles del producto:</b></p>
                                    <p><b>Tamaño:</b> 15 cm aproximadamente</p>
                                    <p><b>Material:</b> Lana chenille aterciopelada o lana de algodón</p>
                                    <p><b>Incluye:</b> Gorrito</p>
                                    <p><b>Precio:</b></p>
                                    <span class="price">$30.000</span>

                                    <div class="btn-3">
                                    <a href="./pagina/carrito">Comprar</a>
                                        </div>

                                </div>
                            </div>
                        </div>


                        <div class="swiper-slide">
                            <div class="product">
                                <div class="product-img">
                                    
                                      <img src="Img/pancake.png" alt=""/>
                                </div>

                                <div class="product-txt">
                                
                                    <h4 class="h4-2">Gato pancake</h4>
                                    <p><b>¡El gatito mas suave y esponjoso!</b></p>
                                    <p>Nuestro gatito pancake de crochet es una delicia, con su cuerpo suave y redondo, y su adorable carita. 
                                        Está confeccionado con materiales de alta calidad y un toque de ternura.</p>
                                    <p><b>Detalles del producto:</b></p>
                                    <p><b>Tamaño:</b> 15 cm aproximadamente</p>
                                    <p><b>Material:</b> Lana chenille aterciopelada o lana de algodón</p>
                                    <p><b>Incluye:</b> Argolla de llavero plateada (Si lo desea)</p>
                                    <p><b>Precio:</b></p>
                                    <span class="price">$20.000</span>

                                    <div class="btn-3">
                                    <a href="./pagina/carrito">Comprar</a>
                                        </div>

                                </div>
                            </div>
                        </div>

                        <!--Se agrega el mismo codigo para mÃ¡s prodcutos-->

                    </div>

                    <!--Botones para productos-->
                    <div class="swiper-button-next"></div>
                    <div class="swiper-button-prev"></div>


                </div>
            </div>
            <!--Tab 3-->
            <input type="radio" name="tabs" id="tab3" checked="checked" class="tabInput" value="3">
            <label for="tab3">Flores</label>
            <div class="tab">
                <div class="swiper mySwiper-2" id="swiper3">
                    <!--Estan los productos-->
                    <div class="swiper-wrapper">

                        <!--Para Agregar Productos-->
                        <div class="swiper-slide">
                            <div class="product">
                                <div class="product-img">
                                    
                                    <img src="Img/spiderman.jpg" alt=""/>
                                </div>

                                <div class="product-txt">
                                    <h4 class="h4-2">Ramo de tulipanes con tématica de Spiderman</h4>
                                    <p><b>¡Un ramo de tulipanes con toque superhéroico!</b></p>
                                    <p>Nuestro ramo de tulipanes es una obra única, inspirada en el icónico Spiderman. 
                                        Unos tulipanes con la araña bordad y otros con los ojos del superhéroe. 
                                        ¡Es el regalo ideal para un fan de marvel!</p>
                                    <p><b>Detalles del producto:</b></p>
                                    <p><b>Tamaño:</b> 40 cm aproximadamente por tulipán</p>
                                    <p><b>Material:</b> Lana chenille aterciopelada o lana de algodón</p>
                                    <p><b>Incluye:</b> Envoltorio y tarjeta</p>
                                    <p><b>Precio:</b></p>
                                    <span class="price">$80.000</span>

                                    <div class="btn-3">
                                    <a href="./pagina/carrito">Comprar</a>
                                        </div>

                                </div>
                            </div>
                        </div>


                        <div class="swiper-slide">
                            <div class="product">
                                <div class="product-img">
                                   
                                    <img src="Img/moto.jpg" alt=""/>
                                </div>

                                <div class="product-txt">
                                    <h4 class="h4-2">Ramo Moto</h4>

                                    <p><b>¡Un ramo de flores con un toque de aventura!</b></p>
                                    <p>Nuestro ramo de flores con un toque bastante único, combina la belleza de las flores con la emoción de la velocidad. 
                                        Girasoles. margaritas y tulipanes se unen en un ramo vibrante y colorido, acompañados de una moto tejida que añade un estilo de aventura y 
                                        libertad. ¡Es perfecto para tu biker favorito! </p>
                                    <p><b>Detalles del producto:</b></p>
                                    <p><b>Tamaño:</b> 40 cm aproximadamente por flor</p>
                                    <p><b>Material:</b> Lana chenille aterciopelada o lana de algodón</p>
                                    <p><b>Incluye:</b> Envoltorio, tarjeta y una moto tejida de un tamaño 20 cm aproximadamente</p>
                                    <p><b>Precio:</b></p>
                                    <span class="price">$120.000</span>

                                    <div class="btn-3">
                                    <a href="./pagina/carrito">Comprar</a>
                                        </div>

                                </div>
                            </div>
                        </div>


                        <div class="swiper-slide">
                            <div class="product">
                                <div class="product-img">
                                   
                                    <img src="Img/dragonball.jpg" alt=""/>
                                </div>

                                <div class="product-txt">
                                    <h4 class="h4-2">Ramo Dragon Ball</h4>
                                    <p><b>¡Un ramo de flores que te llevará a la cima del poder!</b></p>
                                    <p>Nuestro ramo de flores tejido en una obra única, inspirada en el universo de Dragon Ball. Con sus vivos 
                                        colores y su diseño exclusivo, este ramo es perfecto para cualquier fanático de Goku y sus amigos. Incluye las 
                                        esferas del dragón y rosas azules, narajas, negras o amarillas. </p>
                                    <p><b>Detalles del producto:</b></p>
                                    <p><b>Tamaño:</b> 40 cm aproximadamente por flor</p>
                                    <p><b>Material:</b> Lana chenille aterciopelada o lana de algodón</p>
                                    <p><b>Incluye:</b> Envoltorio, tarjeta y las esferas del dragón tejidas</p>
                                    <p><b>Precio:</b></p>
                                    <span class="price">$100.000</span>

                                    <div class="btn-3">
                                    <a href="./pagina/carrito">Comprar</a>
                                        </div>

                                </div>
                            </div>
                        </div>

                        <!--Se agrega el mismo codigo para mÃ¡s prodcutos-->

                    </div>

                    <!--Botones para productos-->
                    <div class="swiper-button-next"></div>
                    <div class="swiper-button-prev"></div>


                </div>
            </div>



        </div>
    </main>

    <section class="info container" id="Nosotros">

        <div class="info-img">
            <img src="./Img/Logo Misoft.png" alt="">
        </div>

        <div class="info-text">

           <h2>Nosotros </h2>
            <p> Somos un equipo de desarrolladores que nos encontramos trabajando en nuestro primer proyecto de diseño web. 
                Nuestro objetivo es diseñar y crear una página web para una marca especializada en manualidades con lana, con el fin
                de potenciar su presencia en línea y mostrar sus productos de manera atractiva.
            </p>
                
        </div>
        <a href="#" class="btn-2">Más Información</a>

<section class="horario">
        <div class="horario-info container">

             <h2>Horario</h2>
            <div class="horario-txt">
                <div class="txt">
                    <h4>Direccion</h4>
                    <p>Cra 98# 2-44</p>
                    <p>Tierra Buena, Kennedy</p>

                </div>
            </div>

                <div class="txt">
                    <h4>Horario</h4>
                    <p>Lunes a Viernes: 8:00 am a 7:00 pm</p>
                    <p>Sábados y Domingos : 8:00 am a 2:00 pm</p>

                </div>
    
                <div class="txt">
                    <h4>Teléfono</h4>
                    <p>xxxxxxxxx</p>
                    

                </div>

                <div class="txt">
                    <h4>Redes Sociales</h4>
                    <div class="socials">
                        <a href="https://wa.me/573174594011">
                            <div class="social" id="Whatsapp">
                                <img src="./Img/whatsapp.png" alt="">
                            </div>
                        </a>
                        
                        <a href="https://www.instagram.com/michigurumis_creations/">
                            <div class="social" id="Instagram">
                                <img src="./Img/instagram.png" alt="">
                            </div>
                        </a>

                        <a href="https://www.facebook.com/share/8UHXYYcHTFKmqU4S/?mibextid=qi2Omg">
                            <div class="social" id="Facebook">
                                <img src="./Img/facebook.png" alt="">
                            </div>
                        </a>
                    </div>
                
                </div>
            </div>
        </div>
    </section>

    </section>


    <footer class="footer container">
    <section class="mapa">
        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d428021.35005904105!2d-74.11633836775412!3d4.663484646662605!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x8e3f9bfd2da6cb29%3A0x239d635520a33914!2zQm9nb3TDoQ!5e0!3m2!1ses!2sco!4v1717728198193!5m2!1ses!2sco" 
            width="100%" 
            height="300" <!-- Ajusta la altura aquÃ­ -->
            style="border:0;" 
            allowfullscreen="" 
            loading="lazy" 
            referrerpolicy="no-referrer-when-downgrade"></iframe>
    </section>
    
    <div class="links">
        <h4>Correos de los creadores</h4>
        <ul>
            <li>Diana: <a href="mailto:brilitosdecoloresahre@gmail.com">Correo</a></li>
            <li>Vanesa: <a href="mailto:vceferino.lesmes@gmail.com">Correo</a></li>
            <li>Nicolas: <a href="mailto:nicolasmorita25@gmail.com">Correo</a></li>
            <li>Daniel: <a href="mailto:moraarce18@gmail.com">Correo</a></li>
        </ul>
    </div>

    
</footer>

<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
<script src="./js/script.js"></script>

</body>
</html>
