# Token机制

## 一、传统身份认证
   - HTTP是一种没有状态的协议，也就是它并不知道是谁访问应用。
    将用户看成是客户端，客户端使用用户名以及密码通过了身份验证，但下次发送请求时还是需要验证。
   - 解决方案：
      > 用户请求登录时，在服务端生成一条记录，该记录中说明登录的用户是谁，并将该ID发送给客户端，客户端将该ID保存到Cookie，
        下次该用户像服务器发送请求时，携带这个Cookie，这样服务端会验证该Cookie里的信息，并且尝试能否在服务器中找到相对应的记录，
        有，则已通过认证，将请求的数据返回客户端。
   - 该方案是Session：
      > 我们需要在服务端存储登录的用户生成的Session，Session可能会存储在内存、磁盘、或者数据库里。可能需要在服务端定期的清理过期的Session。
   - 问题：
      > 1.session：每次认证用户发起请求时，服务器需要去创建一个记录来存储信息，当越来越多用户发请求时，内存的开销也会不断增加。
        2.可扩展性：在服务端的内存中使用Session存储登录信息，伴随而来的是可扩展问题。
        3.CORS（跨域资源共享）：当我们需要让数据跨多台移动设备上使用时，跨域资源的共享会是一个让人头疼的问题。在使用Ajax抓取另一个域的资源，就可以会出现禁止请求的情况。
        4.CSRF（跨站请求伪造）：用户在访问银行网站时，很容易受到跨站请求伪造的攻击，并且能够被利用其访问其他网站。
   - 可扩展性是最突出的。
    
## 二、Token身份认证
  - 使用基于Token的身份验证方法，在服务端不需要存储用户的登录记录。
  - 流程：
      > 1.客户端使用用户名、密码请求登录
        2.服务端收到请求，去验证用户名、密码
        3.验证成功后，服务端会签发一个Token，再把这个Token发送给客户端
        4.客户端收到Token以后可以把它存储起来，比如放在Cookie或者LocalStorage、Session Storage中。
        5.客户端每次向服务端请求资源的时候需要带着服务端签发的Token
        6.服务端收到请求，然后去验证客户端请求里携带的Token，如果验证成功，就向客户端返回请求数据。
  - 客户端存储方式：
        客户端收到Token以后可以把它存储起来，比如放在Cookie或者LocalStorage、Session Storage中。
  - 原理：
        服务器认证后，生成一个JSON对象，发回给用户，如：{"name":"KEVIN","role":"admin","dateTime":"2019-08-15 00:00:00"}
        之后用户与服务器通信时，都是发送这个对象，服务费只需要认证该JSON，但是避免用户篡改数据，服务器生成JSON时会进行加密。
  - 优势：
        无状态、可扩展
        在客户端存储的Token是无状态的，并且能够被扩展。基于这种无状态和不存储Session信息，
        负载均衡器能够将用户信息从一个服务传到其他服务器上。
  - 安全性：
        请求中发送Token而不是发送cookie能够防止CSRF（跨站请求伪造）。即使在客户端使用cookie存储Token，
        cookie也仅仅是一个存储机制而不是用于认证。不再将数据存储在Session中，让我们少了对session操作。

## 三、JSON WEB TOKEN（JWT）机制    
  - JWT是一种紧凑且自包含的，用于在多方传递JSON对象的技术。传递的数据可以使用数字签名增加其安全性。
    可以抵用HMAC加密算法或RSA公钥/私钥加密方式。
  - 紧凑：
      > 数据小，可以通过URL，POST参数，请求头发送。且数据小代表传输速度快。
  - 自包含：
      > 使用payload数据块记录用户必要且不隐私的数据，可以有效的减少数据库访问次数，提高代码性能。
  - JWT一般用于处理用户身份验证或数据信息交换。
  - 用户身份验证：
      > 一旦用户登录，每个后续请求都包含JWT，允许用户访问该令牌允许的路由，服务和资源。
        单点登录是当今广泛使用JWT的一项功能呢，因为它的开销很小，且能轻松跨不同域使用。
  - 数据信息交换：
      > JWT是一种非常方便的多方传递的载体，因为其可以使用数字签名来保证数据的有效性和安全性。

## 四、JWT数据结构
   - JWT数据结构是：A.B.C，以点'.'来分隔三部分数据。
     A - header 头信息
     B - payload（有效荷载）
     C - Signature 签名  

 ### 4.1 header
   - 数据结构:{"alg":"加密算法名称","typ":"JWT"}
   - alg是加密算法定义内容，如HMAC SHA256或RSA
   - typ是Token类型，这里固定为JWT 
       
 ### 4.2 payload
   - 在payload数据块中一般用于记录实体（通常是用户信息）或其它数据。
   - 主要分为三个部分，分别是：
      > 已注册信息（register claims），公开数据（public claims），私有数据（private claims）。
   - payload中指定的七个默认字段选择：
      > iss（发行者），exp（到期时间），sub（主题），aud（收众）等。该列举的为已注册，且常用的信息。。
      > nbf（生效时间），iat（发布时间），jti（JWT ID用于标识该JWT）
   - 可以自定义私有字段：
      如：{"name":"KEVIN","admin":"true"}
   - 公开数据部分一般都会在JWT注册表中增加定义，避免和已注册信息冲突。
     公开数据和私有数据可以由程序员任意定义。
   > 注意：payload内容都是明文信息，不推荐在其中记录任何敏感数据，除非是加密数据。
     
 ### 4.3 Signature
   - 签名信息。由开发者提供的信息，是服务器验证传递的数据是否有效安全的标准。
   - 在生成JWT最终数据之前，先使用header中定义的加密算法，将header和payload进行加密，并使用点进行连接。
   如：用Header里面指定的签名算法（默认是HMAC SHA256），且按照以下公式产生签名：
        HMAC SHA256(base64UrlEncode(header) + "." +base64UrlEncode(payload),secret)
   算出签名后，将Header、Payload、Signature三部分，每部分使用"."分隔，拼成字符串，返回给用户。 
   例如：eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJkNGVmZjU4ZC0wNDFhLTRjNDQtOGVjZi0xMmM0OGFiZmJkZjMiLCJpc3MiOiJzeHQtdGVzdC1qd3QiLCJzdWIiOiJ7XCJ1c2VybmFtZVwiOlwiYWRtaW4xXCJ9IiwiaWF0IjoxNTY2MjA3NzA2LCJleHAiOjE1NjYyMDc3NjZ9.3_ZGOikASHNGiw9IcfUC0L2wzkOwAVqi0dOS-do4eMw







      