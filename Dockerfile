FROM openjdk:8u131-jdk

ENV appName cyclopoid-back

COPY ./build/libs/${appName}*.jar /var/${appName}/${appName}.jar

COPY ./docker/wait-for-mysql.sh /var/${appName}/wait-for-mysql.sh

WORKDIR /var/${appName}

ENTRYPOINT ["java", "-jar", "cyclopoid-back.jar"]
