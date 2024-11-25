# Bouncer
 
This is a Password Validator. It checks if multiple conditions are met. For that it implements the PasswordValidatorTester

## Programm ausführen / Run The Program

Open "Bouncer" in Terminal:

## 1. Projekt kompilieren / Compile The Project

```
enter: mvn clean package
```

## 2. Projekt ausführen / Run The Project
```
java -cp "target/classes:/c/Users/nberg/.m2/repository/com/cthiebaud/password-validator/1.0-SNAPSHOT/password-validator-1.0-SNAPSHOT.jar" com.cthiebaud.PasswordValidatorTester $PWD/target/bouncer-1.0-SNAPSHOT.jar
```

## 3. Anweisungen des Programms "Bouncer" befolgen / Follow The Directions Of The Program "Bouncer"


## 4. Bedingungen erfüllen / Fulfill The Criteria

### Bedingungen

#### Bedingung 1: Mindestlänge des Passworts
- **Bedingung**: Das Passwort muss mindestens **8 Zeichen lang** sein.
- **Fehlermeldung**: 
  - Deutsch: "Das Passwort ist zu kurz. Es muss mindestens 8 Zeichen enthalten."
  - Englisch: "The password is too short. It must contain at least 8 characters."

#### Bedingung 2: Maximale Länge des Passworts
- **Bedingung**: Das Passwort darf nicht länger als **12 Zeichen** sein.
- **Fehlermeldung**:
  - Deutsch: "Das Passwort ist zu lang. Es darf höchstens 12 Zeichen enthalten."
  - Englisch: "The password is too long. It must not exceed 12 characters."

#### Bedingung 3: Mindestens eine Zahl
- **Bedingung**: Das Passwort muss mindestens **eine Zahl** enthalten.
- **Fehlermeldung**:
  - Deutsch: "Das Passwort muss mindestens eine Zahl enthalten."
  - Englisch: "The password must contain at least one number."

#### Bedingung 4: Mindestens ein Großbuchstabe
- **Bedingung**: Das Passwort muss mindestens **einen Großbuchstaben** enthalten.
- **Fehlermeldung**:
  - Deutsch: "Das Passwort muss mindestens einen Großbuchstaben enthalten."
  - Englisch: "The password must contain at least one uppercase letter."

#### Bedingung 5: Mindestens ein Sonderzeichen
- **Bedingung**: Das Passwort muss mindestens **ein Sonderzeichen** enthalten (z.B. !, @, #, $, %, ^, &, usw.).
- **Fehlermeldung**:
  - Deutsch: "Das Passwort muss mindestens ein Sonderzeichen wie z.B. ? oder ! enthalten."
  - Englisch: "The password must contain at least one special character such as ? or !"

## 5. Programm beenden / End The Programm

Nach erfolgreicher Durchführung zeigt das Programm seine Nachricht. Danach kann es mit quit verlassen werden.

After Using The Programm Correctly, It Can Be Exited Using "quit".

```
quit
```


