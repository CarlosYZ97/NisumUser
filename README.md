# H2 + Spring Boot

### Visión General

 Desarrolle una aplicación que exponga una API RESTful de creación de usuarios.
 
 Todos los endpoints deben aceptar y retornar solamente JSON, inclusive al para los mensajes de error.
 
 ### Configurar CodyStyle
 
  - Importar el archivo ubicado en la ruta users\user-boot\src\main\resources\codeStyle
	
	[![Imagen1.png](https://i.postimg.cc/139dsvST/Imagen1.png)](https://postimg.cc/ZCMHLFCF)

 ### H2 Base de Datos
 
  Para ingresar a la base de datos H2 se debe ingresar los siguientes valores:
  - Link: http://localhost:8080/h2
  - JDBC URL: jdbc:h2:mem:nisum
  - UserName: sa
  - Password: password
 
 ### Credenciales para API Rest
 
  Para ingresar al API Rest deberá configurar la autorización a "Basic Auth" donde los datos son:
  
  - UserName: admin
  - Password: thisismypassword
 
 ### Link Swagger
 
  Para validar la api rest de creación deberá ingresar al siguiente link 
  - http://localhost:8080/swagger-ui/index.html


### Diagrama de Solución
  
  [![Nisum-Reto-drawio.png](https://i.postimg.cc/MHYkqTP2/Nisum-Reto-drawio.png)](https://postimg.cc/Cndr4Fpm)
