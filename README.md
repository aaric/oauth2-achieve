# oauth2-achieve

![Java CI](https://github.com/aaric/oauth2-achieve/workflows/Java%20CI/badge.svg)
![License](https://img.shields.io/badge/License-MIT-green.svg)

> OAuth2 Learning.

## 1. 授权模式

### 1.1 授权码模式 (`authorization_code`)

- step_1: curl "http://localhost:8080/oauth/authorize?client_id=client&response_type=code"  //?code=AQlFHh
- step_2: curl -X POST -H "Content-Type: application/x-www-form-urlencoded" -d "grant_type=authorization_code&code=AQlFHh" "http://client:secret@localhost:8080/oauth/token"
- step_3: curl "http://localhost:8080/api/oauth2/hello/sayHi?access_token=5161fdcb-9363-4669-99e1-2da6f5079b01"

### 1.2 客户端授权模式 (`client_credentials`)

### 1.3 密码授权模式 (`password`)

- step_1: curl -X POST -H "Content-Type: application/x-www-form-urlencoded" -d "grant_type=password&scope=app&username=user&password=123456" "http://client:secret@localhost:8080/oauth/token"
- step_2: curl -H "Authorization: Bearer d0370cfe-ca79-416a-80ab-6f760fd35965" "http://localhost:8080/api/oauth2/hello/sayHi?access_token=d0370cfe-ca79-416a-80ab-6f760fd35965"

### 1.4 刷新令牌模式 (`refresh_token`)

## 2. 默认端点

- `/oauth/authorize`：授权端点
- `/oauth/token`：令牌端点
- `/oauth/confirm_access`：用户确认授权提交端点
- `/oauth/error`：授权服务错误信息端点
- `/oauth/check_token`：用于资源服务访问的令牌解析端点
- `/oauth/token_key`：提供公有密匙的端点，如果你使用 JWT 令牌的话

## 3. 权限控制模型

> RBAC支持三个著名的安全原则:最小权限原则,责任分离原则和数据抽象原则。

- `RBAC`：基于角色
- `ACL`：访问控制列表
- `ABAC`：基于属性
- `PBAC`：基于策略
