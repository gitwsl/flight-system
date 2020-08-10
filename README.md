**flight-system: 飞行模拟系统**
flight-eureka   8081
flight-gateway
flight-provider  
     flight-score   
     flight-user  8091
     flight-persistence
     flight-exercise
flight-provider-api
     flight-score-api 
     flight-user-api 
     flight-persistence-api 
     flight-exercise-api 
flight-common
#     flight-common-base
#     flight-common-util
#     flight-common-constant

日志 slf4j
#####################
技术 springboot + mybatis + feign + eureka + swagger

user用户管理（登陆）
common公共模块(工具类，常量等配置)
flight-exercise（习题编辑)
score评分管理（计算分数，1、落库）
data-persistence持久化管理（落库）

eureka-server 服务注册与发现
hystrix-dashboard 服务熔断
config-server 配置中心
gateway-server 网关

MQ没使用，因为部队使用，并发量小
缓存redis，习题，因为习题基本不变动
入口：
swagger: 
http://localhost:8080/swagger-ui.html
