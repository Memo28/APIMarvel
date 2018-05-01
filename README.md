# APIMarvel

Una pequeña implementacion de la API de Marvel en una aplicacion Android

<img src=SS1.jpg width="200" height="400" />   <img src=SS2.jpg width="200" height="400" />

**Prerequisites**
Para que la API funcione se necesita crear una cuenta en:
> https://developer.marvel.com

Y obtener tus llaves privada y publica, una vez teniendolas, haciendo referencia hacia la documentacion de la API encontramos
que para hacer una peticion necesitamos generar un hash utilizando lo siguiente:
>md5(ts+privateKey+publicKey)

Esta hash la puedes generar en la siguiente pagina: 
>http://www.md5.cz

Con todo esto listo ya podemos agregar la informacion en: 
> APIMarvel/app/src/main/java/com/example/"YOURPACKAGENAME"/apimarvel/API/API.java

Y listo ya puedes correr la aplicacion, para mas informacion acerca de las consultas puedes visitar la pagina de los desarrolladores
en donde puedes encontrar toda la informacion que puedes obtener de su API
>https://developer.marvel.com/docs
