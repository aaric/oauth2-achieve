# oauth2-achieve

[![license](https://img.shields.io/badge/license-MIT-green.svg?style=flat&logo=github)](https://www.mit-license.org)
[![java](https://img.shields.io/badge/java-11-brightgreen.svg?style=flat&logo=java)](https://www.oracle.com/java/technologies/javase-downloads.html)
[![gradle](https://img.shields.io/badge/gradle-5.6.2-brightgreen.svg?style=flat&logo=gradle)](https://docs.gradle.org/5.6.2/userguide/installation.html)
[![build](https://github.com/aaric/oauth2-achieve/workflows/build/badge.svg)](https://github.com/aaric/oauth2-achieve/actions)
[![release](https://img.shields.io/badge/release-0.9.3-blue.svg)](https://github.com/aaric/oauth2-achieve/releases)

> OAuth2 Learning.

## 1. 授权模式

### 1.1 授权码模式 (`authorization_code`)

- step_1: curl "http://localhost:8080/oauth/authorize?client_id=client&response_type=code"  //?code=AQlFHh
- step_2: curl -X POST -H "Content-Type: application/x-www-form-urlencoded" -d "grant_type=authorization_code&code=AQlFHh" "http://client:secret@localhost:8080/oauth/token"
- step_3: curl "http://localhost:8080/api/oauth2/hello/sayHi?access_token=5161fdcb-9363-4669-99e1-2da6f5079b01"

### 1.2 客户端授权模式 (`client_credentials`)

> (待完善)

### 1.3 密码授权模式 (`password`)

- step_1: curl -X POST -H "Content-Type: application/x-www-form-urlencoded" -d "grant_type=password&scope=app&username=user&password=123456" "http://client:secret@localhost:8080/oauth/token"
- step_2: curl -H "Authorization: Bearer d0370cfe-ca79-416a-80ab-6f760fd35965" "http://localhost:8080/api/oauth2/hello/sayHi?access_token=d0370cfe-ca79-416a-80ab-6f760fd35965"

### 1.4 刷新令牌模式 (`refresh_token`)

> (待完善)

## 2. OAuth2端点信息

## 2.1 URL地址

- `/oauth/authorize`：授权端点
- `/oauth/token`：令牌端点
- `/oauth/confirm_access`：用户确认授权提交端点
- `/oauth/error`：授权服务错误信息端点
- `/oauth/check_token`：用于资源服务访问的令牌解析端点
- `/oauth/token_key`：提供公有密匙的端点，如果你使用 JWT 令牌的话

## 2.2 Redis存储Token信息示例

```redis
127.0.0.1:6379[8]> keys *
1) "uname_to_access:client:admin"
2) "refresh_to_access:5da217f3-97f5-4c90-a3c7-7da45377a709"
3) "auth_to_access:8502edc3f4c61f1000b1932e6a3756f1"
4) "access:0d7ea7cf-8dc1-4dc6-bbdd-7531ad28f563"
5) "access_to_refresh:0d7ea7cf-8dc1-4dc6-bbdd-7531ad28f563"
6) "client_id_to_access:client"
7) "refresh:5da217f3-97f5-4c90-a3c7-7da45377a709"
8) "refresh_auth:5da217f3-97f5-4c90-a3c7-7da45377a709"
9) "auth:0d7ea7cf-8dc1-4dc6-bbdd-7531ad28f563"
```

## 3. 权限控制模型

> RBAC支持三个著名的安全原则:最小权限原则,责任分离原则和数据抽象原则。

- `RBAC`：基于角色
- `ACL`：访问控制列表
- `ABAC`：基于属性
- `PBAC`：基于策略

### 3.1 提供身份信息

```text
# OAuth2 Server
http://localhost:8080/oauth2/user/info?access_token=4307b5f1-fc04-4891-bcea-c58caf888cd5
```

### 3.2 测试权限

```text
# OAuth2 Client
## has authority
http://localhost:9090/oauth2client/hello/morning?access_token=${access_token}
http://localhost:9090/oauth2client/hello/afternoon?access_token=${access_token}

## not has authority
http://localhost:9090/oauth2client/hello/night?access_token=${access_token}
```

## 4. 创建jks证书

> Win10安装OpenSSL需要下载[Win64OpenSSL-1_1_1e.exe](http://slproweb.com/products/Win32OpenSSL.html)。

```bash
# su - admin
## 创建jks证书
##  - CN: 名字与姓氏（姓名）
##  - OU: 组织单位名称（部门）
##  -  O: 组织名称（公司）
##  -  L: 城市或区域名称（城市）
##  - ST: 省/市/自治区名称（省份）
##  - CN: 双字母国家代码/地区代码（国家代码）
sh> keytool -genkey -alias oauth2 -keyalg RSA -keysize 2048 \
  -dname "CN=OAuth2 Server,OU=Java,O=Aaric,L=Wuhan,ST=Hubei,C=CN" \
  -validity 3650 -keypass admin123 -keystore oauth2.jks -storepass admin123
## 获取公钥信息
sh> keytool -list -rfc -keystore oauth2.jks | openssl x509 -inform pem -pubkey
Enter keystore password:  admin123
-----BEGIN PUBLIC KEY-----
MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAodRsRudmPvKPg/fnHmAw
m2v5Bfr2CmjFCgnuP5XOfmfRZ7VgTXSJEczkBPSgUAYfepYaprZSqOnHxjQZ/koO
s8J1hLWFR4HAeLVjicUEBJi2zSUxb9Sv1KR9VjfTBJphtVUuZT30LPC71DCEoL7R
1aVbe6V4G6bfVKn6p6IbMZceC7k85etFpElPKAtZXwznOzE7z1AL/dgIKlZRMIAA
zFh7p57krXK0X7DCzC0sfexKXTGaMNYjVCytemdBeXZX3ru653K/+3erA1xNU9Pn
qBLGSQbJ221N+MUGERE7X2k3EvQUZDRrcb5cNImr97xGgsNGEmXX2Q43Tx19J4U8
yQIDAQAB
-----END PUBLIC KEY-----
```
