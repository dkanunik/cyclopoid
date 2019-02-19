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
# Build project
$ ./gradlew build

# Launch application
$ ./gradlew appStart 

# Launch unit tests
$ ./gradlew test
```

##### Containerization 
```
# Build and uplopad image
$ ./gradlew image
```
