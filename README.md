# oauth2-achieve

> OAuth2 Learning.

![Java CI](https://github.com/aaric/oauth2-achieve/workflows/Java%20CI/badge.svg)

## 1. 授权模式

### 1.1 授权码模式 (`authorization_code`)

- step_1: curl "http://localhost:8080/oauth/authorize?client_id=client&response_type=code"
- step_2: curl -X POST -H "Content-Type: application/x-www-form-urlencoded" -d "grant_type=authorization_code&code=2EIHGt" "http://client:secret@localhost:8080/oauth/token"
- step_3: curl "http://localhost:8080/api/oauth2/hello/sayHi?access_token=1202db6b-bdc3-4348-9dbe-75bd133f7197"

### 1.2 客户端授权模式 (`client_credentials`)

### 1.3 密码授权模式 (`password`)

### 1.4 刷新令牌模式 (`refresh_token`)

### 1.2 默认端点

- `/oauth/authorize`：授权端点
- `/oauth/token`：令牌端点
- `/oauth/confirm_access`：用户确认授权提交端点
- `/oauth/error`：授权服务错误信息端点
- `/oauth/check_token`：用于资源服务访问的令牌解析端点
- `/oauth/token_key`：提供公有密匙的端点，如果你使用 JWT 令牌的话

## 2. 使用access_token访问api

```text
http://localhost:8080/api/oauth2/hello/sayHi?access_token=1202db6b-bdc3-4348-9dbe-75bd133f7197
```
