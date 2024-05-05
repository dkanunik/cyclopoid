# Cyclopoid API test

##### Database
```
# Launch MySQL in a docker container
$ ./gradlew envStart

# Stop the container with MySQL
$ ./gradlew envStop

# Perform db restore
$ ./gradlew dbRestore
```

##### Launch Back service
```
$ ./gradlew backStart
```

##### Run test
```
$ ./gradlew test
```
