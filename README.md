<h1>Comunicación en red por medio de sockets (TCP)</h1>
En este proyecto he construido una aplicación capaz de transmitir el stock de un almacén de chirimoyas entre dos equipos cliente y servidor conectados por red mediante sockets, haciendo uso del protocolo de comunicación TCP.
<p align="center">
  <img src="https://github.com/hotomol/sockets/blob/main/Images%20for%20Readme.md/Figura%200.%20Socket.png?raw=true" alt="Figura 0. Socket">
  <br><i>Figura 0. Socket.</i>
</p>
<br>
<br>
<h2>Demostración de comunicación entre la app Cliente y la app Servidor</h2>
<p align="center">
  <img src="https://github.com/hotomol/sockets/blob/main/Images%20for%20Readme.md/demostracion.gif?raw=true">
<i>Video demostrativo.</i>
</p>
<br>
<br>
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

