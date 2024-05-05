### MySQL notes

```
# Backup
docker exec cyclopoid-db /usr/bin/mysqldump -u root --password=root cyclopoid > testDB.sql

# Restore
cat testDB.sql | docker exec -i cyclopoid-db /usr/bin/mysql -u root --password=root cyclopoid
``` 