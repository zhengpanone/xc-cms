## 工程结构
- parent工程: 父工程,提供依赖管理
- common工程: 通用工程,提供各层封装
- model工程:  模型工程,提供统一的模型类管理
- utils工程:  工具类工程,提供本项目所使用的工具类
- Api工程:    接口工程,统一管理本项目的服务接口

## Spring Data mongodb和Spring Data JPA
Spring Data mongodb同Spring Data JPA一样也提供自定义方法的规则,如下:
按照findByXXX,findByXXXAndYYY,countByXXXAndYYY等规则定义方法,实现查询操作。

``` java
public interface ProjectRepository extends MongoRepository<com.zp.model.Project,String >{
    // 根据项目名称查询
    com.zp.model.Project findByProjectName(String projectName);
    //根据项目名称和类型查询
    com.zp.model.Project findByProjectNameAndType(String projectName, String Type);
    // 根据类型和poolingName查询记录数
    int countByTypeAndPoolingName(String Type, String poolingName);
    // 根据类型和projectName分页查询
    Page<com.zp.model.Project> findByTypeAndProjectName(String Type, String projectName, Pageable pageable);
}

//条件查询 

//使用ProjectRepository中的findAll(Example<S> var1, Pageable var2)方法实现
```




# 接口开发规范

## API请求响应规范

- get请求时,采用key/value格式请求,SpringMVC可采用基本变量接收,也可以采用对象接收
- POST请求时,可以提交form表单数据(application/x-www-form-urlencoded)和Json数据(Content-Type=application/json),
文件等多部件类型(multipart/form-data)三种数据格式,SpringMVC接收json数据使用@RequestBody注解解析请求jsons数据
- 响应结果统一信息为: 是否成功、操作代码、提示信息及自定义数据
- 响应结果统一格式为json

## API定义约束

API定义使用SpringMVC来完成,由于此接口后期作为微服务远程调用使用,在定义接口时有如下限制

- @PathVariable 统一指定参数名称，如: @PathVariable("id")
- @RequestParam 统一指定参数名称，如: @RequestParam("id")


# Swagger

http://localhost:8081/swagger-ui.html

Swagger常用注解

- @Api：修饰整个类，描述Controller的作用 

- @ApiOperation：描述一个类的一个方法，或者说一个接口 

- @ApiParam：单个参数描述 

- @ApiModel：用对象来接收参数 

- @ApiModelProperty：用对象接收参数时，描述对 象的一个字段 

- @ApiResponse：HTTP响应其中1个描述 

- @ApiResponses：HTTP响应整体描述 

- @ApiIgnore：使用 该注解忽略这个API 

- @ApiError ：发生错误返回的信息 

- @ApiImplicitParam：一个请求参数 

- @ApiImplicitParams：多个请求参数 

  

- @ApiImplicitParam属性：

