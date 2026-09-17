
# Use a lightweight Maven image
FROM maven:3.8.5-openjdk-17-slim

# Set working directory inside a container where things will happen
WORKDIR /app

# Copy pom.xml and download dependencies (Caching layer), It's Trick as It we don't change the dependencies then docker skip
# it downloading so always copy pom.xml
COPY pom.xml .
RUN mvn dependency:go-offline -B

#Once you copy you download the dependencies right
#(Scenario: This ensures that when you actually run your tests, the container doesn't need to reach out to the internet to find Selenium or Cucumber jars; they are already baked in

# Copy your source code
COPY src ./src

# The command will be handled by Docker Compose, but we provide a default
CMD ["mvn", "test"]

# example :- CMD ["mvn", "test","-Dtags=@Smoke"]

# FROM(Base Image) -> On that image which directory -> copy pom.xml -> run -> mvn to download -> copy source code ---> final run --> mvn command (mvn test -Dtags=@Smoke)