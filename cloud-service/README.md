# Cloud-Service

|            依赖             |      版本       |
| :-----------------------: | :-----------: |
| spring-boot-dependencies  | 2.2.2.RELEASE |
| spring-cloud-dependencies |  Hoxton.SR1   |
| mybatis-plus-boot-starter |     3.2.0     |
|           druid           |    1.1.10     |
|          lombok           |    1.18.10    |
|   mysql-connector-java    |    5.1.10     |
* ### cloud-common-api
    公共模块，定义公用实体和接口。
* ### cloud-provider-service8001
    服务提供者，主要提供一个测试接口，由于为集成数据库，启动类中排除了Datasource自动配置类
* ### cloud-eureka-service7001
    服务注册中心，未做集群。后期提供一个Dockerfile直接构建成镜像放在虚拟机上运行
* ### cloud-gateway-service9527
    服务网关。
