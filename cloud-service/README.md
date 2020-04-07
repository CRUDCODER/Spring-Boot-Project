# Cloud-Service

|            依赖            |      版本     | 说明|
| :-----------------------: | :-----------: | :-----------:|
| spring-boot-dependencies  | 2.2.2.RELEASE | springboot 版本控制      |
| spring-cloud-dependencies |  Hoxton.SR1   |spring cloud版本控制       |
| mybatis-plus-boot-starter |     3.2.0     | mybatis plus版本      |
|           druid           |    1.1.10     | druid数据连接池版本      |
|          lombok           |    1.18.10    | lombok版本      |
|   mysql-connector-java    |    5.1.10     | mysql数据库连接版本      |
|springfox-swagger2|2.9.2|swagger2文档依赖|
|springfox-swagger-ui|2.9.2|swagger2在线文档|
* ### cloud-common-api
    >公共模块，定义公用实体和接口。   
    集成Swagger2，并且写好配置文件，其余模块不需要再次单独集成Swagger2和配置。只需使用Swagger2注解标注接口即可使用   
    Swagger2访问地址: http://ip:port/swagger-ui.html
* ### cloud-provider-service8001
    >服务提供者，主要提供一个测试接口，由于为集成数据库，启动类中排除了Datasource自动配置类
* ### cloud-consumer-service80
    服务消费者，集成Openfeign，主要测试了服务提供者的2个接口。处理了feign调用超时的fallback回调。
* ### cloud-eureka-service7001
    >服务注册中心，未做集群。后期提供一个Dockerfile直接构建成镜像放在虚拟机上运行
* ### cloud-gateway-service9527
    >服务网关。

    ~~调用链路为gateway-->cloud-consumer-service-->cloud-provider-service  
    理由：首先可以用gateway拦截器进行第一步验证，可以验证请求头是否携带token，如果没有则直接响应结果。避免无效请求造成服务器负担   
    第二步为cloud-consumer，此服务可以集成openfeign和hystrix。如果调用超时可以直接在此响应结果，不必一直等待提供者响应。也可以进行服务熔断和服务降级。  
    第三步cloud-provider，服务提供者，尽量将无效请求，以及基本异常拦截在调用提供者之前，避免给服务提供者造成压力。   
    说明：我在学习Spring cloud的时候，zuul和gateway都学习过。但是看别人写的demo都是网关直接去调用服务提供者。   
    如果这么调用的话，那ribbon、feign、hystrix好像就用不上了。所以我就使用了网关去调用消费者，消费者再去调用提供者。
    网关去调用是自带负载均衡的，所以消费者服务也可以做集群。我觉得这样还算比较合理。    
    就算服务消费者是不做业务处理的，但是对服务消费者的请求量太大，也会造成压力。所以使用了网关进行解耦，这样服务消费者，服务提供者都可以进行集群。保证了服务的高可用。~~  

    
    
    
