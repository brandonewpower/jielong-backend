# 微信接龙小程序 - 后端代码

## Commands

### Run SpringBoot App
```shell script
mvn spring-boot:run
```

### Docker Launch

#### Build App Jar
```shell script
mvn clean install -DskipTests
```

#### Start Cluster
```shell script
docker-compose up --build
```

#### Remove Cluster
```shell script
docker-compose down --volumes --rmi 'all' 
```