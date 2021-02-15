# 授权认证

## cas sso 单点登陆认证

1.安装cas server

```
    
```

2.制作本地证书
```
fandong@fandongdeMacBook-Air cas % keytool -genkey -alias casserver -keyalg RSA -keystore ./keystore
输入密钥库口令:  
再次输入新口令: 
您的名字与姓氏是什么?
  [Unknown]:  test
您的组织单位名称是什么?
  [Unknown]:  test
您的组织名称是什么?
  [Unknown]:  test
您所在的城市或区域名称是什么?
  [Unknown]:  test
您所在的省/市/自治区名称是什么?
  [Unknown]:  test
该单位的双字母国家/地区代码是什么?
  [Unknown]:  test
CN=test, OU=test, O=test, L=test, ST=test, C=test是否正确?
  [否]:  y

输入 <casserver> 的密钥口令
	(如果和密钥库口令相同, 按回车):  
再次输入新口令: 

Warning:
JKS 密钥库使用专用格式。建议使用 "keytool -importkeystore -srckeystore ./keystore -destkeystore ./keystore -deststoretype pkcs12" 迁移到行业标准格式 PKCS12。
fandong@fandongdeMacBook-Air cas % ls
keystore
fandong@fandongdeMacBook-Air cas % keytool -export -trustcacerts -alias casserver -file cas.cer -keystore keystore 
输入密钥库口令:  
存储在文件 <cas.cer> 中的证书

Warning:
JKS 密钥库使用专用格式。建议使用 "keytool -importkeystore -srckeystore keystore -destkeystore keystore -deststoretype pkcs12" 迁移到行业标准格式 PKCS12。
fandong@fandongdeMacBook-Air cas % ls
cas.cer  keystore

# 将证书导入jdk cert证书库中
fandong@fandongdeMacBook-Air cas % which java
/Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/bin/java
fandong@fandongdeMacBook-Air security % pwd
/Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/security
fandong@fandongdeMacBook-Air cas % keytool -import -trustcacerts -alias casserver -file cas.cer -keystore /Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/security/cacerts
输入密钥库口令:  
keytool 错误: java.io.IOException: Keystore was tampered with, or password was incorrect
fandong@fandongdeMacBook-Air cas % keytool -import -trustcacerts -alias casserver -file cas.cer -keystore /Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/security/cacerts
输入密钥库口令:  
所有者: CN=test, OU=test, O=test, L=test, ST=test, C=test
发布者: CN=test, OU=test, O=test, L=test, ST=test, C=test
序列号: 6c531499
有效期为 Sun Feb 14 08:37:29 CST 2021 至 Sat May 15 08:37:29 CST 2021
证书指纹:
	 MD5:  E5:71:EC:2B:0A:56:5E:48:CA:53:29:BD:87:82:4D:55
	 SHA1: 62:D2:67:DA:77:E5:99:DA:FB:F6:E3:A8:19:CC:22:42:69:4A:CB:6E
	 SHA256: DD:14:E1:C8:56:F5:92:4B:08:0F:3D:05:2A:53:0D:82:59:1E:0C:AE:E5:DE:49:6B:2A:9D:5C:96:86:13:4D:7E
签名算法名称: SHA256withRSA
主体公共密钥算法: 2048 位 RSA 密钥
版本: 3

扩展: 

#1: ObjectId: 2.5.29.14 Criticality=false
SubjectKeyIdentifier [
KeyIdentifier [
0000: 8B 0F C3 E0 CD F1 42 77   E0 3D 87 90 2B 24 91 09  ......Bw.=..+$..
0010: A6 61 5D 8E                                        .a].
]
]

是否信任此证书? [否]:  y
证书已添加到密钥库中
keytool 错误: java.io.FileNotFoundException: /Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/security/cacerts (Permission denied)
fandong@fandongdeMacBook-Air cas % 

```