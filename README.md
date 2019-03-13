### eureka

使用eureka作为服务注册中心



### common

1. 包含如下功能：
   - com.example.demo.exception.GlobalExceptionHandler类：针对ServiceExcption和validation抛出的异常的全局处理
   - com.example.demo.config.Swagger2类：swagger配置文件
   - com.example.demo.constant.ServiceInfo类：后端服务名常量，用于供Feign指定服务
   - com.example.demo.util包：包含工具类和错误码接口，具体错误码的实现可以在各具体的后端微服务中去定义
   - com.example.demo.bean.Response类：用于封装返回给前端的数据，包括状态码和数据
   - com.example.demo.form/com.example.demo.vo包：定义了前端传输给后端的通用表单/后端传给前端的通用数据

2. pom.xml中定义的jar即可供各后端服务使用，后端服务不必重复引用
3. mvn install后，即可在本机上使用common的jar包



### backend-one&backend-two

1. 在pom.xml中引用common包即可使用common包中所提供的功能
2. 使用Feign完成服务间调用，并配置了Fallback
