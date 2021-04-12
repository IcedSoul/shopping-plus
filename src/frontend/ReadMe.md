## 本地搭建前端测试环境
在项目根目录执行如下命令：
```shell
cd ./src/frontend/
docker build -t test-frontend -f ./test/Dockerfile ./
docker run -p 80:8081 -d test-frontend
```

然后即可在浏览器访问http://localhost，可以看到前端页面。

注意，只有各个服务启动时添加"spring.profiles.active=local"时，
前端的请求才会被转发到本地启动的后端服务。

```shell
docker stop test-frontend
```