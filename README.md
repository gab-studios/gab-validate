
Master: [![Build Status](https://travis-ci.org/sysdevone/gab-validate.svg?branch=master)](https://travis-ci.org/sysdevone/gab-validate)
[![codecov.io](https://codecov.io/github/sysdevone/gab-validate/coverage.svg?branch=master)](https://codecov.io/github/sysdevone/gab-validate?branch=master)
[![Coverity Scan](https://scan.coverity.com/projects/8317/badge.svg)](https://scan.coverity.com/projects/sysdevone-gab-validate)
[![Issue Count](https://codeclimate.com/github/sysdevone/gab-validate/badges/issue_count.svg)](https://codeclimate.com/github/sysdevone/gab-validate)
[![Coverage Status](https://coveralls.io/repos/github/sysdevone/gab-validate/badge.svg?branch=master)](https://coveralls.io/github/sysdevone/gab-validate?branch=master)

Integration: [![Build Status](https://travis-ci.org/sysdevone/gab-validate.svg?branch=integration)](https://travis-ci.org/sysdevone/gab-validate)
[![codecov.io](https://codecov.io/github/sysdevone/gab-validate/coverage.svg?branch=integration)](https://codecov.io/github/sysdevone/gab-validate?branch=integration)

GAB-Validate
=======

The GAB Social Validation Library for Java.  The purpose of this project is to analyze and examine how I would create a validation library for Java.  Comments are welcome.  Thank you.


Required
---------
This project requires the following: 

    * Java 7+
    * Maven

Build
---------
Use Maven to build - `mvn package`.

Usage
---------

In order to validate, you need to call a defineXXXXXX() method `Validate.defineString("HelloWorld")`.  Once that is done, you can perform tests by chain calling test methods.

```java
Validate.defineString("HelloWorld").testMaxLength(10).throwExceptionOnFailedValidation().validate();

boolean retVal = Validate.defineInteger(5000).testMaxValue(max).testMinValue(min).validate();

```

More Documentation
------------------
Check the project [wiki] [].


Copyright
-------
[Copyright 2015 Gregory Brown] [copyright]


License
-------
This codebase is licensed under the [Apache v2.0 License] [license].


Feedback
---------
Comments and feedback are greatly appreciated!!!


[copyright]: https://github.com/sysdevone/gab-validate/tree/master/COPYRIGHT
[license]: https://github.com/sysdevone/gab-validate/tree/master/LICENSE
[wiki]: https://github.com/sysdevone/gab-validate/wiki
[examples]: https://github.com/sysdevone/gab-validate/wiki/Examples
