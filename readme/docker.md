```

$ docker build -t cyclopoid-back:latest .

$ docker image tag cyclopoid-back localhost:5000/cyclopoid-back

$ docker-compose -f docker/docker-compose-back.yml up

$ docker push localhost:5000/cyclopoid-back
```