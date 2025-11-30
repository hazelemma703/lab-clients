# Use the Eclipse alpine official image
# https://hub.docker.com/_/eclipse-temurin
FROM eclipse-temurin:21-jdk-alpine

# Create and change to the app directory.
WORKDIR /app

# Copy files to the container image
COPY . ./

ENV PORT=9000
ENV DB_URL="jdbc:postgresql://ep-soft-frost-a5jrxwwz-pooler.us-east-2.aws.neon.tech/weather_db?user=weather_db_owner&password=1RKIPdo8uAvT&sslmode=require&channelBinding=require"
ENV DB_USERNAME="weather_db_owner"
ENV DB_PASSWORD="1RKIPdo8uAvT"

# Build the app.
RUN ./mvnw -DoutputFile=target/mvn-dependency-list.log -B -DskipTests clean dependency:list install


# Run the app by dynamically finding the JAR file in the target directory
CMD ["sh", "-c", "java -jar target/*.jar"]