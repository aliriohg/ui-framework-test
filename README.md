# UI Autometion test  
http://automationpractice.com/index.php

Mini framework to test automationpractice.com

#### Run the tests
`
mvn clean package verify -P local 
`

#### Run the tests by tags

`
mvn clean package verify -P local -Dcucumber.options="--tags @Tag"
`
