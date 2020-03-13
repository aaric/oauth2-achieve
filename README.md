# oauth2-achieve

> OAuth2 Learning.

![Java CI](https://github.com/aaric/oauth2-achieve/workflows/Java%20CI/badge.svg)

## 1. 创建access_token

### 1.1 密码授权模式-client

```text
http://localhost:8080/oauth/token?username=user01&password=123456&grant_type=password&client_id=app&client_secret=app123
```

### 1.2 客户端授权模式-password
```text
http://localhost:8080/oauth/token?grant_type=client_credentials&client_id=app&client_secret=app123
```

### 1.3 授权码模式-code

#### 1.3.1 获取code

```text
http://localhost:8080/oauth/authorize?response_type=code&client_id=app&redirect_uri=http://baidu.com
```

#### 1.3.2 通过code换token

```text
http://localhost:8080/oauth/token?grant_type=authorization_code&code=7UtsBd&client_id=app&client_secret=app123&redirect_uri=http://baidu.com
```

## 2. 使用access_token访问api

```text
http://localhost:8080/api/oauth2/hello/sayHi?access_token=1202db6b-bdc3-4348-9dbe-75bd133f7197
```
