 <p align="center"><img src="README.assets/ssafy_bus.png" width="400" height="400" /></p>



## ๐ ์ ๊ธฐํ ์ธํผ๋ฒ์ค


- ์งํ ๊ธฐ๊ฐ : 2021.10.11 ~ 2021.11.26
- ๋ชฉํ: ์ธํผ ๊ด์ฃผ ์บ ํผ์ค ๋ฉํ๋ฒ์ค ํ๋ซํผ  


  - Unity๋ฅผ ํ์ฉํ ๊ด์ฃผ ์บ ํผ์ค ํ๊ฒฝ์ ์ฌํํ์ฌ ์ง์์๋ ์บ ํผ์ค๋ฅผ ์ฆ๊ธธ ์ ์์ต๋๋ค.
  - ์คํฐ๋๋ฃธ์ ์์ฝํ๊ณ  ํ์๋ค๊ณผ ๋์  ์คํฐ๋๋ฅผ ์งํํ  ์ ์์ต๋๋ค.
  - ํฌํ๊ฒ์ํ์ ์ด์ฉํ์ฌ ์์ ์ ์ฝ๋๋ฅผ ๊ณต์ ํ์ฌ ๋์์ ๋ฐ์ ์ ์์ต๋๋ค.
  - ๋ชจ๋ ํ์์ ์๋ฃ๋ค์ ํ์๋ค๊ณผ ๊ณต์ ํ  ์ ์๊ณ  ํ์๋ค์ ๋ค์ด๋ฐ์ ๋ณผ ์ ์์ต๋๋ค.
  - '๋ฌด์์ด๋  ๋ฌผ์ด๋ณด์ธ์'  ๋ฌด๋ฌผ ๊ฒ์ํ์์ ์ต๋ช์ผ๋ก QNA๋ฅผ ์งํํ  ์ ์์ต๋๋ค.


- [๊ฐ๋ฐ๋ฌธ์]()

<br>


## โญ๏ธ์ฃผ์ ๊ธฐ๋ฅ

### Unity 3D ์บ ํผ์ค

> ์ธํผ ์บ ํผ์ค๋ฅผ 3D ๋ชจ๋ธ๋งํ์ฌ ํ์ค๊ณผ ๋น์ทํ๊ฒ ์ค๊ณํ์์ต๋๋ค.

![ssafymap](README.assets/ssafymap.png)

### ์คํฐ๋๋ฃธ

> ์คํฐ๋๋ฃธ์ ์์ฝํ๊ณ  ์ฐ๋ฆฌ๋ง์ ๋ฐฉ์ ์์ฑํ์ฌ ํ์ํ์,ํ๋ฉด๊ณต์ , ์ฑํ์ ์ง์ํฉ๋๋ค.

![study](README.assets/study.gif)

### ๊ณต์ ๊ฒ์ํ

> ์ํ๋ ์ฌ๋์๊ฒ ์๋ฃ๋ฅผ ๊ณต์ ํ ์ ์๋ ๊ณต์ ๊ฒ์ํ์๋๋ค.

![share](README.assets/share.gif)

### ์ถ์์ฒดํฌ

> ์ถ์์ธ์ฆ์ ์ํ ์ถ์์ฒดํฌ, ๋ฐฉ๋ช๋ก์ ๋จ๊ธธ ์ ์์ต๋๋ค.

![guestbook](README.assets/guestbook.gif)

### ๋ฌด๋ฌผ 

> '๋ฌด์์ด๋  ๋ฌผ์ด๋ณด์ธ์'
>
> ์ต๋ช์ธ์ ์ ์ด์ฉํ์ฌ ๋น๋๋ฉด ์์์์ ์กฐ๊ธ ๋ ์นํด์ง๊ธฐ ์ํ ์ต๋ช๊ฒ์ํ์๋๋ค.

![locker](README.assets/locker.gif)

### ํฌํ๊ฒ์ํ

> Markdown ๊ธฐ๋ฐ์ ํฌํ๊ฒ์ํ์ ํตํ ๋ฌธ์  ํด๊ฒฐ ์ปค๋ฎค๋ํฐ์๋๋ค.

![help](README.assets/help.gif)




## โ ์๋น์ค ์ํคํ์ณ


![image-20211118142451596](README.assets/image-20211118142451596.png)


## ๐ ์ต์ข์ฐ์ถ๋ฌผ


- [๋ฐํ์๋ฃ](https://drive.google.com/file/d/1utqRM5L9R8FpSjrZKSj8o-H1APt00476/view?usp=sharing)


- [UCC](https://www.youtube.com/watch?v=kF9CiiEl2aw)


## ๐ Installation


- Frontend


```bash
$ cd frontend
$ npm i
$ npm run serve
```


- Backend


```bash
# API server 
$ cd Backend
$ gradle wrap # gradle wrapper ์์ ๊ฒฝ์ฐ ์คํ
$ ./gradlew clean build
$ sudo java -jar build/libs/backend-0.0.1-SNAPSHOT.jar

# openvidu + KMS
$ docker run -p 4443:4443 --rm -e OPENVIDU_SECRET=MY_SECRET openvidu/openvidu-server-kms:2.20.0
```


## ๐ค Server Description


- port (nginx)


- | 443               | server default(https)                                        |
    | ----------------- | ------------------------------------------------------------ |
    | **80**            | server default(http) (redirect to 443)                       |
    | **5443**          | openvidu (Spring boot running)                               |
    | **8080**          | REST API (Spring boot running) (reverse proxy)               |
    | **3306**          | MariaDB                                                      |
    | **9090**          | Jenkins CI/CD                                                |
    | **3478**          | used by TURN server to resolve clients IPs.                  |
    | **40000 - 57000** | used by Kurento Media Server to establish media connections. |
    | **57001 - 65535** | used by TURN server to establish relayed media connections.  |



## โ ๊ฐ๋ฐ ํ๊ฒฝ ๋ฐ IDE


### โจFront-End 


- **์ง์ ํ๊ฒฝ** : Web,Unity
- **๋ด๋น์** : ๊น๋ณด๋ฏผ, ๊น์ฉ์ฌ, ์ก์งํ

<details>
    <summary>Front ์์ธํ ์ดํด๋ณด๊ธฐ ๐</summary>
    <ul>
        <li>๊ธฐ์ ์คํ โ</li>
    </ul>   
    <ul>
      	<li>Vue.js @2.6.11</li>
      	<li>Unity</li>
      	<li>Photon</li>
      	<li>Openvidu</li>
      	<li>WebGL</li>
        <li>JS, HTML, CSS</li>
        <li>SCSS</li>
    </ul>
    <li>--------------------------------------------------------------------------------------</li>
    <ul>
        <li>๋ผ์ด๋ธ๋ฌ๋ฆฌ ๐</li>
    </ul>   
    <ul>
        <li>"@toast-ui/vue-editor": "^3.1.1",</li>
        <li>"axios": "^0.23.0",</li>
        <li>"bootstrap": "^5.1.3",</li>
        <li>"bootstrap-vue": "^2.21.2",</li>
        <li>"core-js": "^3.6.5",</li>
        <li>"inko": "^1.1.1",</li>
        <li>"node-sass": "^6.0.1",</li>
        <li>"openvidu-browser": "^2.20.0",</li>
        <li>"sass-loader": "^10.2.0",</li>
        <li>"simple-code-editor": "^1.0.5",</li>
        <li>vue": "^2.6.14",</li>
        <li>"vue-router": "^3.5.2",</li>
        <li>"vue-unity-webgl": "^1.2.0",</li>
        <li>"vuetify": "^2.5.10",</li>
        <li>"vuex": "^3.6.2",</li>
        <li>"vuex-persistedstate": "^4.1.0"</li>
    </ul>
</details>




### ๐ปBack-End


- **๋ด๋น์** : ๊น์ค๋น, ์๊ดํ
<details>
    <summary>Backend ์์ธํ ์ดํด๋ณด๊ธฐ ๐</summary>
    <ul>
        <li>๊ธฐ์ ์คํ โ</li>
    </ul>   
    <ul>
        <li>Spring-boot</li>
      	<li>Spring-Security</li>
      	<li>Spring Data Jpa</li>
      	<li>Redis</li>
        <li>AWS EC2</li>
        <li>Docker</li>
        <li>Jenkins</li>
        <li>Mariadb</li>
        <li>AWS S3</li>
      	<li>Photon</li>
    </ul>
</details>





## ๐จโ๐ฉโ๐ฆํ์ ์๊ฐ

**์๊ดํ**


- ๐ฎGithub: [@ImGwanghun](https://github.com/Gwanghun-Im)

**์ก์งํ**


- ๐ฐGithub: [@jihyeon-songb](https://github.com/jihyeon-songb)

**๊น๋ณด๋ฏผ**


- ๐งโโ๏ธGithub: [@bomin1](https://github.com/bomin1)

**๊น์ฉ์ฌ**


- ๐Github: [@kimyoungjae](https://github.com/rubetyy)

**๊น์ค๋น**


- ๐ถGithub : [@kimyunbin](https://github.com/kimyunbin)



