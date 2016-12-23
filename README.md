gs-commons
==========

Grayshirts' *Java library* with common sets of utility classes to work with strings,
dates, codecs, exceptions, etc.


Build settings
--------------

To add this library to your project, depending of your building
tool, these are the configuration settings you need:

### Maven

Add the following configuration to the `pom.xml` file
of your project:

1. `dependencies` section:

   ```xml
   <dependency>
       <groupId>ar.com.grayshirts</groupId>
       <artifactId>commons</artifactId>
       <version>1.0.0-RC1</version>
   </dependency>
   ```

2. `repositories` section:

   ```xml
   <repository>
       <id>grayshirts-public</id>
       <name>Grayshirts Public Repository</name>
       <url>https://dl.bintray.com/grayshirts/public</url>
   </repository>
   ```

### Gradle

Add the following configuration to the `build.gradle` file
of your project:

1. `dependencies` section:

   ```
   compile 'ar.com.grayshirts:commons:1.0.0-RC1'
   ```

2. `repositories` section:

   ```
   maven() {
       url "https://dl.bintray.com/grayshirts/public"
   }
   ```

If you build this library locally with Maven, and you want
to include in a Gradle project the local build, add
in the `repositories` section:

```
repositories {
  mavenLocal()
  ...
```


Build
-----

To build this library locally, run the tests, generate the _.jar_ file and install
it in your local Maven repo:

    $ mvn


Deploy
------

To deploy the _.jar_ file to the _Bintray Central repository_:

    $ mvn deploy -s settings.xml

Before publish to Bintray, you need to setup your account credentials
as environment variables.

You can configure these variables in your shell startup
file (`~/.bashrc`, `~/.zshrc`, `~/.profile`...) like this:

```sh
# Bintray credentials
export BINTRAY_USERNAME="myusername"
export BINTRAY_PASSWORD="XXXXXXXXXXXXXXXXXXXXXXXX"
```

Also remember to update the _version_ number of the
library before publish a new release from
the `pom.xml` file.


About
-----

Licensed under [Apache Software License 2.0](https://www.apache.org/licenses/LICENSE-2.0).

Developed by [Grayshirts](http://grayshirts.com.ar).
