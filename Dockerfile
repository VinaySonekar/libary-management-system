FROM public.ecr.aws/amazoncorretto/amazoncorretto:17-alpine
WORKDIR /app
COPY target/BookManagementService-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
