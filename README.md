# Cyclopoid 

##### Database
```
# Launch MySQL in a docker container
$ ./gradlew envStart

# Stop the container with MySQL
$ ./gradlew envStop

# Perform db restore
$ ./gradlew dbRestore
```

##### App local
```
# Build the project
$ ./gradlew build

# Build the project excludeing unint tests
$ ./gradlew build -x test

# Launch the application
$ ./gradlew localStart 

# Launch unit tests
$ ./gradlew test
```

#### Containerization

##### Build image
```
$ ./gradlew image
```

##### Launch Back service
```
$ ./gradlew backStart
```

#### API
* form/all
* form/by/id/{formId}
