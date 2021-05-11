[![Made with Java](https://badgen.net/badge/Language/Java/red?icon=kofi)](#)
[![license-MIT](https://img.shields.io/npm/l/markdownlint.svg)](http://opensource.org/licenses/MIT)

<a href="http://opensource.org/licenses/MIT" target="_blank"><img src="https://img.shields.io/npm/l/markdownlint.svg" ></a>

<h1>Comunicación en red por medio de sockets (TCP)</h1>
En este proyecto he construido una aplicación capaz de transmitir el stock de un almacén de chirimoyas entre dos equipos cliente y servidor conectados por red mediante sockets, haciendo uso del protocolo de comunicación TCP.
<p align="center">
  <img src="https://github.com/hotomol/sockets/blob/main/Images%20for%20Readme.md/Figura%200.%20Socket.png?raw=true" alt="Figura 0. Socket">
  <br><i>Figura 0. Socket.</i>
</p>
<br>
<br>
<h2>Demostración de funcionamiento</h2>
<div align="center">
  <img src="https://github.com/hotomol/sockets/blob/main/Images%20for%20Readme.md/demostracion.gif?raw=true">
<i>Video demostrativo.</i>
</div>
<br>
<br>

<h2>Desarrollo de la Aplicación Cliente</h2>
La aplicación Cliente se ha construido siguiendo el patrón de diseño vista-controlador y
usando la librería Java Swing: la clase VistaCliente contiene lo relativo a la interfaz gráfica y el controlador de dicha interfaz gráfica lo hemos desarrollado en la clase HiloCliente.
En la siguiente figura se muestra la interfaz gráfica desarrollada para el Cliente indicando los distintos controles:
<br>
<br>

<p align="center">
  <img src="https://raw.githubusercontent.com/hotomol/sockets/main/Images%20for%20Readme.md/Figura%201.%20Interfaz%20AppCliente.png" alt="Figura 1. Interfaz Aplicación Cliente.">
  <br><i>Figura 1. Interfaz Aplicación Cliente.</i>
</p>
<br>

<b>(1)</b>. Cuadro de texto, cuya variable txtPuerto recibe el número de puerto al que se conectará el socket de la parte del Cliente.

<b>(2)</b>. Cuadro de texto, cuya variable se txtDireccion recibe la dirección del servidor a la que se conectará el socket.

<b>(3)</b>. Botón btnConexionCliente cuyo método ‘click’ creará una instancia de la clase HiloCliente donde creamos el hilo que controlará la creación del socket, conexión con el Servidor y flujos de Entrada/Salida.
<div align="center">
  <img src="https://github.com/hotomol/sockets/blob/main/Images%20for%20Readme.md/Figura%202.%20C%C3%B3digo%20del%20bot%C3%B3n%20btnConexion.png?raw=true" >
 <i>Figura 2. Código del botón btnConexion.</i>
</div>
<br>
<br>
A continuación, se muestra el constructor de la clase HiloCliente, en cuyo código se crea el socket de la parte del cliente mediante el constructor de la clase Socket, el puerto de conexión y la dirección del servidor introducidos por el usuario.
<br>
<br>
<div align="center">
  <img src="https://raw.githubusercontent.com/hotomol/sockets/main/Images%20for%20Readme.md/Figura%203.%20Constructor%20de%20la%20clase%20HiloCliente.png?raw=true" >
 <i>Figura 3. Constructor de la clase HiloCliente.</i>
</div>
<br>
<br>
El método run() comienza a ejecutarse cuando se crea el hilo con la instrucción h.start(). Mirar figura 2. La  parte más importante del método run() es la comunicación del hilo Cliente con el hilo Servidor mediante los flujos de entrada y salida.
<br>
<br>
<div align="center">
  <img src="https://raw.githubusercontent.com/hotomol/sockets/main/Images%20for%20Readme.md/Figura%204.%20M%C3%A9todo%20run()%20del%20hilo%20de%20la%20aplicaci%C3%B3n%20Cliente.png?raw=true" >
 <br>
 <i>Figura 4. Método run() del hilo de la aplicación Cliente.</i>
</div>
<br>
<br>
  (4). Etiqueta, cuya misión es la de informar al usuario del estado de la conexión Cliente-Servidor para brindar una experiencia de usuario agradable. Esta etiqueta tiene 3 estados: 

-Mientras el Servidor permanece sin conectar muestra el mensaje “conexión OFF” como se muestra en la figura 8 del presente documento.
-Cuando se ha creado el socket de la parte del servidor, pero aun no se ha conectado, es decir, la instrucción .accept() aún está en espera de la conexión del cliente. En este caso se  muestra el mensaje “Esperando conexión Cliente” en color naranja. Mirar figura 13.
-Cuando la conexión se ha establecido, el mensaje pasa a ser “conexión OK” en color verde. Mirar figura 14.

De igual modo se han programado mensajes a nivel de entorno consola indicando los pasos que sigue la aplicación. Mirar video adjunto.

</div>
<br>
<br>
<b>(4)</b>. Etiqueta, cuya misión es la de informar al usuario del estado de la conexión Cliente-Servidor para brindar una experiencia de usuario agradable.  Esta etiqueta tiene 2 estados: 
- Mientras el Cliente permanece sin conectar muestra el mensaje “conexión OFF” como aparece en la figura 1 del presente documento.
- Cuando la conexión se ha establecido, el mensaje pasa a ser “conexión OK” en color verde. Mirar figura 5.
<br>
<br>
<div align="center">
  <img src="https://raw.githubusercontent.com/hotomol/sockets/main/Images%20for%20Readme.md/Figura%205.%20Conexi%C3%B3n%20Cliente%20exitosa.png" alt="Figura 5. Conexión Cliente-Servidor exitosa">  
<br>
<i>Figura 5. Conexión Cliente-Servidor exitosa.</i>
</div>
<br>
<br>
<b>(5)</b>. Botón que envía al controlador del servidor (vía socket) el contenido del cuadro de texto que le acompaña (nº6 de figura 1)  para incrementar la variable stock que guarda del lado del servidor el número de chirimoyas.
Cuando el servidor recibe dicha cadena la castea a número entero, se la suma a la variable ‘stock’ manda el resultado de vuelta al cliente que lo muestra en el cuadro de texto txtConsultar (nº10 de figura 1). 
<br>
<br>
<div align="center">
  <img src="https://raw.githubusercontent.com/hotomol/sockets/main/Images%20for%20Readme.md/Figura%206.%20C%C3%B3digo%20del%20bot%C3%B3n%20btnInsertar%20(mirar%20n%C2%BA5%20de%20la%20figura%201).png" >
 <i>Figura 6. Código del botón btnInsertar (mirar nº5 de la figura 1).</i>
</div>
<br>
<br>
<b>(7)</b>.  Ventana informativa que indica al usuario que para retirar chirimoyas del almacén debe introducir un número entero negativo en el cuadro de texto txtRetirar (nº6 de figura 1).
<br>
<br>
<b>(8)</b>. Botón que envía al controlador del servidor (vía socket) el contenido del cuadro de texto que le acompaña (nº9 de figura 1)  para disminuir la variable stock que guarda del lado del servidor el número de aguacates.
Cuando el servidor recibe dicha cadena la castea a número entero, se la resta (es negativo) a la variable ‘stock’ que manda el resultado de vuelta al cliente y lo muestra en el cuadro de texto txtConsultar (nº10 de figura 1).  
<br>
<br>
<div align="center">
  <img src="https://raw.githubusercontent.com/hotomol/sockets/main/Images%20for%20Readme.md/Figura%207.%20C%C3%B3digo%20del%20bot%C3%B3n%20btnRetirar.png" >
 <i>Figura 7. Código del botón btnRetirar.</i>
</div>
<br>
<br>
<b>(10)</b>. Cuadro de texto, que permanece actualizado constantemente con el stock de chirimoyas de la variable ‘stock’ de la aplicación servidor. Su variable en el código es txtConsultar.

<b>(11)</b>. Botón salir que cierra la ventana principal de la aplicación.
<br>
<br>
<div align="center">
  <img src="https://raw.githubusercontent.com/hotomol/sockets/main/Images%20for%20Readme.md/Figura%208.%20C%C3%B3digo%20del%20bot%C3%B3n%20btnSalir.png" >
 <i>
Figura 8. Código del botón btnSalir.</i>
</div>
<br>
<br>
<h2>Desarrollo de la Aplicación Servidor</h2>
La aplicación servidor se ha construido siguiendo el patrón de diseño vista-controlador y usando la librería Java Swing: la clase VistaServidor contiene lo relativo a la interfaz y el controlador de dicha interfaz gráfica lo hemos desarrollado en la clase HiloServidor.

En la siguiente figura se muestra la interfaz desarrollada indicando los distintos controles.
<br>
<br>
<div align="center">
  <img src="https://raw.githubusercontent.com/hotomol/sockets/main/Images%20for%20Readme.md/Figura%209.%20Interfaz%20gr%C3%A1fica%20del%20Servidor.png" >
  <br>
 <i>Figura 9. Interfaz gráfica de la aplicación Servidor.</i>
</div>
<br>
<br>
<b>(1)</b>. Cuadro de texto, cuya variable txtPuerto recibe el número de puerto al que se conectará el socket de la parte del Servidor.
<br><br>
<b>(2)</b>. Cuadro de texto, cuya variable txtStock recibe el stock inicial del almacen introducido por el usuario al arrancar el servidor, según lo indicado en el enunciado de la tarea.
<br><br>
<b>(3)</b>. Botón, cuya variable btnConexionServidor inicia el hilo del servidor que controlará la creación del socket, y flujos de entrada/salida para comunicarse con el Cliente.
<br>
<br>
<div align="center">
  <img src="https://raw.githubusercontent.com/hotomol/sockets/main/Images%20for%20Readme.md/Figura%2010.%20C%C3%B3digo%20del%20bot%C3%B3n%20btnConexionServidor.png" >
  <br>
 <i>Figura 10. Código del botón btnConexionServidor.</i>
</div>
<br>
<br>
A continuación, se muestra el constructor de la clase HiloServidor, en cuyo código se crea el socket de la parte del servidor mediante el constructor de la clase Socket y el puerto de conexión introducido por el usuario.
<br>
<br>
<div align="center">
  <img src="https://github.com/hotomol/sockets/blob/main/Images%20for%20Readme.md/Figura%2011.%20Constructor%20de%20la%20clase%20HiloServidor.png" >
  <br>
 <i>Figura 11. Constructor de la clase HiloServidor.</i>
</div>
<br>
<br>
El método run() comienza a ejecutarse cuando se crea el hilo con la instrucción h.start(). Mirar figura 9. La  parte más importante del método run() es la comunicación del hilo Servidor con el hilo Cliente mediante los flujos de entrada y salida.
<br>
<br>
<div align="center">
  <img src="https://raw.githubusercontent.com/hotomol/sockets/main/Images%20for%20Readme.md/Figura%2012.%20M%C3%A9todo%20run()%20del%20hilo%20de%20la%20aplicaci%C3%B3n%20Servidor.png" >
  <br>
 <i>Figura 12. Método run() del hilo de la aplicación Servidor.</i>
</div>
<br>
<br>
<b>(4)</b>. Etiqueta, cuya misión es la de informar al usuario del estado de la conexión Cliente-Servidor para brindar una experiencia de usuario agradable. Esta etiqueta tiene 3 estados: 
<br>
<br>
<ul>
<li>Mientras el Servidor permanece sin conectar muestra el mensaje “conexión OFF” como se muestra en la figura 8 del presente documento.</li>
<li>Cuando se ha creado el socket de la parte del servidor, pero aun no se ha conectado, es decir, la instrucción .accept() aún está en espera de la conexión del cliente. En este caso se  muestra el mensaje “Esperando conexión Cliente” en color naranja. Mirar figura 13.</li>
<li>Cuando la conexión se ha establecido, el mensaje pasa a ser “conexión OK” en color verde. Mirar figura 14.</li>
</ul>

<br>
<br>
<div align="center">
  <img src="https://raw.githubusercontent.com/hotomol/sockets/main/Images%20for%20Readme.md/Figura%2013.%20Servidor%20a%20espera%20de%20conexion.png" >
  <br>
 <i>Figura 13. Servidor esperando conexión Cliente.</i>
</div>
<br>
<br>
<div align="center">
  <img src="https://raw.githubusercontent.com/hotomol/sockets/main/Images%20for%20Readme.md/Figura%2014.%20Conexi%C3%B3n%20Servidor%20exitosa..png" >
  <br>
 <i>Figura 14. Conexión Servidor-Cliente exitosa.</i>
</div>
<br>
<br>
<b>(5)</b>. Cuadro de texto, que permanece actualizado constantemente con el stock de chirimoyas de la variable ‘stock’ de la aplicación servidor. Su variable en el código es txtConsultar.
<br>
<br>
<b>(6)</b>. Botón salir que cierra la ventana principal de la aplicación.
<br>
<br>
<div align="center">
  <img src="https://raw.githubusercontent.com/hotomol/sockets/main/Images%20for%20Readme.md/Figura%2015.%20C%C3%B3digo%20del%20bot%C3%B3n%20btnSalir.png" >
  <br>
 <i>Figura 15. Código del botón btnSalir.</i>
</div>


<br>
<br>
<h2>License</h2>

[![License][license-image]][license-url]

Released under the MIT License. See the [LICENSE](LICENSE) file
for details.

[license-image]: https://img.shields.io/npm/l/markdownlint.svg
[license-url]: http://opensource.org/licenses/MIT
