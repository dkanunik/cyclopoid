#!/usr/bin/env bash
docker exec -i cyclopoid-db /usr/bin/mysql -uroot -proot cyclopoid < $(pwd)/db/testDB.sql
