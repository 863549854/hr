FROM java:8
#项目所依赖的镜像
ADD target/*.jar hr-eureka1.0.jar
#将maven构建好的jar添加到镜像中
EXPOSE 9000
#暴露的端口号
ENTRYPOINT ["java","-jar","/hr-eureka1.0.jar"]
#镜像所执行的命令

