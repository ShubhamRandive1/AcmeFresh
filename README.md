# AcmeFresh
AcmeFresh organization product delivery Restful Api project with admin login, customer login and product selling Api's

**ER(Entity Relationship diagram)**

![Screenshot (798)](https://user-images.githubusercontent.com/57911117/201059921-669405fb-b0d1-42e4-a37e-2a246214eeee.png)


**The Schema**

![Screenshot (785)](https://user-images.githubusercontent.com/57911117/201010014-ea78fca8-5226-4c8b-9621-d1c283527da3.png)
![Screenshot (786)](https://user-images.githubusercontent.com/57911117/201010024-ddb75890-f2fa-49a5-92df-c5db7c3d30c6.png)
![Screenshot (787)](https://user-images.githubusercontent.com/57911117/201010030-c309cf8f-92d1-4168-95fe-8461307c38bb.png)

**AdminLogin and Registration**
**Using Postman**
![Screenshot (782)](https://user-images.githubusercontent.com/57911117/201010096-af61fb62-8f3c-4218-9619-4b7ff16ad2cb.png)

**Same Using Swagger ui**

![Screenshot (790)](https://user-images.githubusercontent.com/57911117/201010215-7657633c-75b2-4d8b-96ef-9ed0e614168d.png)

![Screenshot (791)](https://user-images.githubusercontent.com/57911117/201010329-e19464d0-3e7c-4a2d-bfac-d6bbc17c6a6a.png)

**Admin Login and Unique user identification key generated**

![Screenshot (797)](https://user-images.githubusercontent.com/57911117/201052650-32207951-83c9-403f-9428-20781497c02b.png)


**Mysql Database**

![Screenshot (792)](https://user-images.githubusercontent.com/57911117/201010404-213ca9fa-aa84-4939-8abd-ebcd794c281e.png)

![Screenshot (793)](https://user-images.githubusercontent.com/57911117/201010419-7102aca1-7c7e-4636-9830-1cb446ffb617.png)

![Screenshot (794)](https://user-images.githubusercontent.com/57911117/201010643-c29609dd-6522-4adb-814d-bca0aa1c23b6.png)

```
#changing the server port
server.port=8123


#db specific properties
spring.datasource.url=jdbc:mysql://localhost:3306/asmefresh
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=shubhamcool1$

#ORM s/w specific properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.mvc.pathmatch.matching-strategy = ANT_PATH_MATCHER

```
