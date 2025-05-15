# Use uma imagem base do Java (Escolha a versão apropriada)
FROM openjdk:21-jdk-slim

# Defina o diretório de trabalho dentro do container
WORKDIR /app

# Copie o arquivo JAR da sua aplicação para o container
COPY target/api-googlebooks-0.0.1-SNAPSHOT.jar app.jar

# Exponho a porta em que sua aplicação String Boot está rodando (geralmente 8080)
EXPOSE 8080

# Comando para executar a aplicação quando o container iniciar
ENTRYPOINT ["java", "-jar", "app.jar"]