# Pancake

# Database setup

Download a GlassFish application:
https://glassfish.java.net/download.html (Java EE X Full Platform)

Configuration:
	- Resolve the problem of missing derbyclient.jar by adding it. It usually is in the JDK's install directory
	  under db/lib.
	- Add the javadb directory's path in the previously downloaded GlassFish package to Java DB Installation.
	  (For example: C:\Program Files\GlassFish 4.1\glassfish4\javadb)
	- Start Java DB Server
	- Connect to the Pancake database (If it doesn't exist, create it first with root as admin and root as password)