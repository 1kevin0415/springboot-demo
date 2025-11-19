# 基础镜像
# FROM openjdk:17-jdk-alpine  <-- 删掉这一行

# 换用 MCR 提供的 OpenJDK 镜像 (更稳定，绕过 Docker Hub 软封锁)
FROM mcr.microsoft.com/openjdk/jdk:17-ubuntu

# 设置工作目录
WORKDIR /app

# 复制构建好的 jar 包
COPY target/demo99-1.0-SNAPSHOT.jar app.jar

# 暴露端口
EXPOSE 18080

# 启动命令
ENTRYPOINT ["java", "-jar", "app.jar"]