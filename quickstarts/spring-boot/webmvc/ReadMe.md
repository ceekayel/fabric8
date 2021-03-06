# Web MVC with Spring-Boot QuickStart

This example demonstrates how you can use Spring Boot and web mvc with a [Java Container](http://fabric8.io/gitbook/javaContainer.html)

The quickstart uses Spring Boot to configure a little Spring MVC application that offers a REST service.

When the application is running, you can use a web browser to access the REST service, as the screenshot below shows:

![Spring Boot MVC](https://raw.githubusercontent.com/fabric8io/fabric8/master/docs/images/spring-boot-mvc.png)


## Building this example

The example comes as source code and pre-built binaries with the fabric8 distribution. 

To build from the source code:

1. Change your working directory to `quickstarts\spring-boot\mvc` directory.
1. Run `mvn clean install` to build the quickstart.

After building from the source code, you can upload the changes to the fabric container:

1. It is assumed that you have already created a fabric and are logged into a container called `root`.
1. Change your working directory to `quickstarts\spring-boot\mvc` directory.
1. Run `mvn fabric8:deploy` to upload the quickstart to the fabric container.

If you run the `fabric:deploy` command for the first then, it will ask you for the username and password to login the fabric container.
And then store this information in the local Maven settings file. You can find more details about this on the fabric8 website about the [Maven Plugin](http://fabric8.io/gitbook/mavenPlugin.html).


## How to run this example

The following information is divded into two sections, whether you are using the command line shell in fabric, or using the web console

### Using the command line shell

You can deploy and run this example at the console command line, as follows:

1. It is assumed that you have already created a fabric and are logged into a container called `root`.
1. Create a new child container and deploy the `quickstarts-spring.boot-mvc` profile in a single step, by entering the
 following command at the console:

        fabric:container-create-child --profile quickstarts-pring.boot-mvc root mychild

1. Wait for the new child container, `mychild`, to start up. Use the `fabric:container-list` command to check the status of the `mychild` container and wait until the `[provision status]` is shown as `success`.

### Using the web console

You can deploy and run this example from the web console, as follows

1. It is assumed that you have already created a fabric and are logged into a container called `root`.
1. Login the web console
1. Click the Wiki button in the navigation bar
1. Select `quickstarts` --> `spring-boot` --> `mvc`
1. Click the `New` button in the top right corner
1. In the Create New Container page, enter `mychild` in the Container Name field, and click the *Create and start container* button


### How to try this example

To use the application be sure to have deployed the quickstart in fabric8 as described above. 

1. Login the web console
1. Click the Runtime button in the navigation bar
1. Select the `mychild` container in the containers list, and click the *open* button right next to the container name.
1. A new window opens and connects to the container.
1. Click the *Tomcat* button, which lists all the WAR applications deployed. Click the url link for the application, which opens a web page, with links to the REST service.


## Undeploy this example

The following information is divded into two sections, whether you are using the command line shell in fabric, or using the web console

### Using the command line shell

To stop and undeploy the example in fabric8:

1. Stop and delete the child container by entering the following command at the console:

        fabric:container-stop mychild
        fabric:container-delete mychild

### Using the web console

To stop and undeploy the example in fabric8:

1. In the web console, click the *Runtime* button in the navigation bar.
1. Select the `mychild` container in the *Containers* list, and click the *Stop* button in the top right corner


