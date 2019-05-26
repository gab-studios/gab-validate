
Master | [![Build Status](https://travis-ci.org/gab-studios/gab-validate.svg?branch=master)](https://travis-ci.org/gab-studios/gab-validate) | [![codecov.io](https://codecov.io/github/gab-studios/gab-validate/coverage.svg?branch=master)](https://codecov.io/github/gab-studios/gab-validate?branch=master)
---: | :---: | :---:
Integration | [![Build Status](https://travis-ci.org/gab-studios/gab-validate.svg?branch=integration)](https://travis-ci.org/gab-studios/gab-validate) | [![codecov.io](https://codecov.io/github/gab-studios/gab-validate/coverage.svg?branch=integration)](https://codecov.io/github/gab-studios/gab-validate?branch=integration)

GAB-Validate
=======

The GAB Studios Validation Library for Java.  The purpose of this project is to analyze and examine how I would create a validation library for Java.  Comments are welcome.  Thank you.

Maven Dependency
---------
```java
<dependency>
  <groupId>com.gabstudios</groupId>
  <artifactId>gab-validate</artifactId>
  <version>1.0.0-SNAPSHOT</version>
</dependency>
```

Build
---------
Use Maven to build - `mvn package`.

Required
---------
This project requires the following: 

    * Java 8
    * Maven

Usage
---------

In order to validate, you need to call a defineXXXXXX() method `Validate.defineString("HelloWorld")`.  Once that is done, you can perform tests by chain calling test methods.

```java
Validate.defineString("HelloWorld").testMaxLength(10).throwValidationExceptionOnFail().validate();

boolean retVal = Validate.defineInteger(5000).testMaxValue(max).testMinValue(min).validate();

```


Example
---------


To validate a Boolean:

```java
   Validate.defineBoolean(name != null && name.length() > 0)
           .testTrue()
           .throwValidationExceptionOnFail()
           .validate();
```

```java
    boolean retVal = Validate.defineBoolean(name != null && name.length() > 0)
                             .testTrue()
                             .validate();
```

To validate a String:

```java
   Validate.defineString("HelloWorld").testEqualsNoCase("hELLOwORLD")
           .testMaxLength(10)
           .throwValidationExceptionOnFail()
           .validate();
```

```java
   boolean retVal = Validate.defineString("HelloWorld")
                            .testMaxLength(10)
                            .testEqualsNoCase("hELLOwORLD")
                            .validate();
```


More Documentation
------------------
Check the project [wiki].


Copyright
-------
[Copyright 2015 Gregory Brown]


License
-------
This codebase is licensed under the [Apache v2.0 License].


Feedback
---------
Comments and feedback are greatly appreciated!!!


[Copyright 2015 Gregory Brown]: https://github.com/gab-studios/gab-validate/tree/master/COPYRIGHT.txt
[Apache v2.0 License]: https://github.com/gab-studios/gab-validate/tree/master/LICENSE.txt
[wiki]: https://github.com/gab-studios/gab-validate/wiki
[examples]: https://github.com/gab-studios/gab-validate/wiki/Examples
