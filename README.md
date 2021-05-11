<h1>Comunicación en red por medio de sockets usando protocolo TCP</h1>
<hr>
En este proyecto he construido una aplicación capaz de transmitir el stock de un almacén de chirimoyas entre dos equipos cliente y servidor conectados por red mediante sockets, haciendo uso del protocolo de comunicación TCP.
<p align="center">
  <img src="https://github.com/hotomol/sockets/blob/main/Images%20for%20Readme.md/Figura%200.%20Socket.png?raw=true" alt="Figura 0. Socket">
  <br><i>Figura 0. Socket.</i>
</p>
<br>
<br>
<h3>Demostración de comunicación entre la app Cliente y la app Servidor</h2>
<p align="center">
  <img src="https://github.com/hotomol/sockets/blob/main/Images%20for%20Readme.md/demostracion.gif?raw=true">
<i>Video demostrativo.</i>
</p>
La aplicación Cliente se ha construido siguiendo el patrón de diseño vista-controlador y
usando la librería Java Swing: la clase VistaCliente contiene lo relativo a la interfaz gráfica y el controlador de dicha interfaz gráfica lo hemos desarrollado en la clase HiloCliente.
En la siguiente figura se muestra la interfaz gráfica desarrollada para el Cliente indicando los distintos controles:

<p align="center">
  <img src="https://github.com/hotomol/sockets/blob/main/Images%20for%20Readme.md/Figura%201.%20Interfaz%20Aplicaci%C3%B3n%20Cliente.png?raw=true" >
 <i>Figura 1. Interfaz Aplicación Cliente.</i>
</p>
</br>
<b>(1)</b>. Cuadro de texto, cuya variable txtPuerto recibe el número de puerto al que se conectará el socket de la parte del Cliente.

<b>(2)</b>. Cuadro de texto, cuya variable se txtDireccion recibe la dirección del servidor a la que se conectará el socket.

<b>(3)</b>. Botón btnConexionCliente cuyo método ‘click’ creará una instancia de la clase HiloCliente donde creamos el hilo que controlará la creación del socket, conexión con el Servidor y flujos de Entrada/Salida.
<p align="center">
  <img src="https://github.com/hotomol/sockets/blob/main/Images%20for%20Readme.md/Figura%202.%20C%C3%B3digo%20del%20bot%C3%B3n%20btnConexion.png?raw=true" >
 <i>Figura 2. Código del botón btnConexion.</i>
</p>
