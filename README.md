# Trabajo práctico cuatrimestral - Orientación a Objetos II
Este proyecto contiene el proyecto backend del trabajo práctico cuatrimestral correspondiente a la materia de Orientación a Objetos II.
### Listado de herramientas/tecnologías que utiliza el proyecto:
- Java SE 17
- Spring Boot 3.2.5
- Spring Data JPA
- Spring Security
- Autenticación con JSON Web Token (JWT)
- Lombok

El Backend está realizado con una arquitectura REST. El mismo expone endpoints, los cuales luego el Frontend los consumirá y obtendrá objetos o colecciones JSONs, que luego utilizará en los diferentes componentes.

### Instalando el proyecto localmente
#### 1. Importando el proyecto
1. Deberás clonar este mismo repositorio, ejecutando por consola el siguiente comando:
    ```bash
    git clone https://github.com/leandroblandi/grupo-21-OO2-2024.git
    ```
2. Deberás dirigirte a tu IDE de preferencia, en este caso, los integrantes del desarrollo, utilizamos Spring Tool Suite. Seleccionas el workspace que suelas utilizar, sino creas uno. 
3. Una vez seleccionado el Workspace, eliges la pestaña:
    a. "File"
    b. Luego la opción "Import"
    c. Y eliges el tipo de proyecto con nombre "Existing Maven Projects"
    d. Finalmente, apretas el botón "Next".
4. Por ultimo, presionas el botón Browse, y buscas la carpeta donde clonaste el repositorio
5. Si todo va bien, verá en el recuadro Projects, verás el `pom.xml` importado correctamente con el nombre `com.unla.grupo21:tpc-oo2-sci:0.0.1-SNAPSHOT.jar`, lo dejas seleccionado.
6. Finish.
#### 2. Levantando el servidor por primera vez
El servidor se iniciará en el puerto `8080`, por lo cual, asegúrate de tener libre ese puerto, o que no haya otro servidor Tomcat corriendo en el mismo puerto.
Para iniciar el servidor, puedes hacer click derecho sobre el proyecto en el Package Explorer, y seleccionar la opción:
    1. "Run As"
    2. Luego, "Spring Boot App".
### 3. Utilizando la aplicación
Una vez iniciaste la aplicación, Spring inicializará todo lo necesario, incluyendo la creación de las tablas, y algunos datos iniciales como para que puedas usar la aplicación normalmente.
#### 3.1. Probando la aplicación
El punto de partida de la aplicación, como para probar que funciona, puede ser el siguiente endpoint:
```bash
GET: http://localhost:8080/api/test
```
El mismo debería responder con un JSON como:
``` json
{
 "status": "on",
 "message": "sci works!"
}
```
Eso significa que la aplicación está corriendo de manera exitosa. El verdadero punto de partida es el login, es decir, el inicio de sesión. El usuario por defecto con los permisos suficientes tiene como username "dummy", y la contraseña es "1234", tal como verás en el siguiente JSON:
``` json
{
 "usuario": "dummy",
 "clave": "1234"
}
```
Si deseas un usuario que solo tenga permisos de cliente, puedes usar el siguiente:
``` json
{
 "usuario": "lblandi",
 "clave": "1234"
}
```

#### 3.1.1 Roles
La aplicación maneja un uso de roles, donde cada usuario puede tener solo un rol. Los roles cargados en el sistema son:
- `ROLE_CLIENTE`: Es el rol que cualquier usuario obtiene al registrarse en la aplicación.
- `ROLE_ADMINISTRADOR`: Unicamente los adminsitradores tienen este rol.
#### 3.1.2 Permisos según roles
Cabe aclarar que los endpoints están restringidos según rol. Es decir, un cliente no puede hacer todo lo que el administrador sí puede. Aquí se lista las cosas que un visitante puede hacer:
- Testear el backend
- Registrarse
- Iniciar sesión

Sin embargo, si el visitante se registra e inicia sesión, obtendrá el rol `ROLE_CLIENTE`, por lo que podrá hacer lo siguiente:
- Ver los artículos
- Realizar una compra de uno/varios artículos

Por último, el usuario con rol `ROLE_ADMINISTRADOR` puede hacer lo siguiente:
- Sección artículos
    - Ver artículos
    - Cargar artículos
    - Modificar artículos
    - Eliminar artículos
- Sección lotes:
    - Ver lotes
    - Cargar lotes
    - Modificar lotes
    - Eliminar lotes
- Sección usuarios:
    - Ver clientes
    - Eliminar clientes
    - Crear administradores
