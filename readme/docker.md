```
$ docker build -t cyclopoid-back:latest .

$ docker image tag cyclopoid-back localhost:5000/cyclopoid-back

$ docker-compose -f docker/docker-compose-back.yml up

$ docker push localhost:5000/cyclopoid-back

$ docker-machine create -d virtualbox --virtualbox-cpu-count 2 --virtualbox-memory 9000 cyclopoid

$ docker-machine start cyclopoid

$ eval "$(docker-machine env cyclopoid)"

$ env | grep DOCKER_HOST | egrep -o '([0-9]{1,3}\.){3}[0-9]{1,3}'
```