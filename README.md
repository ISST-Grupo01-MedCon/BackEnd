# MedCon - BackEnd
En este repositorio se aloja el BackEnd de nuestro sistema MedCon. Se ha desarrollado en Java utilizando SpringBoot.

A continuación se detallan algunos pasos que se pueden seguir para iniciar el servidor desde un sistema Linux o tipo Unix. También se puede seguir desde Windows utilizando [WSL](https://docs.microsoft.com/es-es/windows/wsl/install), una máquina virtual o emuladores de consolas de Linux como Cygwin.

## Requisitos previos:
### Instalación de OpenJDK 11:
Si no se tiene la versión 11 de OpenJDK previamente instalada, es conveniente instalarla con:

`curl https://download.java.net/java/ga/jdk11/openjdk-11_linux-x64_bin.tar.gz > ~/openjdk-11.tar.gz`

`tar -xzvf open-jdk11.tar.gz`

`echo "export JAVA_HOME=~/jdk-11.0.14.1+1" > ~/.bashrc`

`echo "export PATH=$PATH:$JAVA_HOME/bin" > ~/.bashrc`

`source ~/.bashrc`

## Inicio del servidor
### Automáticamente:
Se puede simplemente ejecutar el script `ejecutarServidor.sh`:

`chmod a+x ejecutarServidor.sh`

`./ejecutarServidor.sh`

### Manualmente:
Tenemos dos casos dependiendo de la existencia o no del directorio frontend:
* Si el directorio frontend contiene el [repositorio del FrontEnd](https://github.com/ISST-Grupo01-MedCon/FrontEnd) porque se clonó anteriormente, simplemente se puede ejecutar:

    `cd frontend && git pull origin && cd ..`

  Para sincronizar los cambios del FrontEnd con los de GitHub.
  Finalmente, se puede iniciar el servidor con:

    `./mvnw clean install -DskipTests=true spring-boot:run`

* Si no existe el directorio frontend, se puede clonar con:

    `git clone https://github.com/ISST-Grupo01-MedCon/FrontEnd`

  Y, finalmente, iniciar el servidor con:

    `./mvnw clean install -DskipTests=true spring-boot:run`
