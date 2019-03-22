#!/usr/bin/env bash
eval "$(docker-machine env cyclopoid)"
docker exec -i cyclopoid-db /usr/bin/mysqldump -uroot -proot cyclopoid > $(pwd)/db/testDB_1.1.sql
