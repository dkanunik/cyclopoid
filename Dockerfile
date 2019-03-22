FROM openjdk:8u131-jdk

ENV appName cyclopoid-back

COPY ./build/libs/${appName}*.jar /var/${appName}/${appName}.jar

WORKDIR /var/${appName}

ENTRYPOINT ["java", "-jar", "cyclopoid-back.jar"]
