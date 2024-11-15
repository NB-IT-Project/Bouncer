# Bouncer
 
This is a Password Validator

## Programm ausführen

Im Terminal:

1. Projekt kompilieren

```
mvn clean package
```

2. Projekt ausführen
```
java -cp "target/classes:/c/Users/nberg/.m2/repository/com/cthiebaud/password-validator/1.0-SNAPSHOT/password-validator-1.0-SNAPSHOT.jar" com.cthiebaud.PasswordValidatorTester $PWD/target/bouncer-1.0-SNAPSHOT.jar
```