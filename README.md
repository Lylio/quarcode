![](https://github.com/Lylio/image-repo/blob/master/logos/spring-boot.png?raw=true)
![](https://github.com/Lylio/image-repo/blob/master/logos/thymeleaf.png?raw=true)
![](https://github.com/Lylio/image-repo/blob/master/logos/qrcode.png?raw=true)

# Quarcode

### Description
A QR Code generator using Thymeleaf and ZXing.

### Tech Stack
- Spring Boot (JDK 17)
- Thymeleaf
- ZXing
- Maven

### Setup & Launch

#### Docker Launch
1. `docker build -t quarcode .`
2. `docker run -p 8080:8080 quarcode:latest`
3. Navigate to http://localhost:8080/

#### Maven Launch
1. `mvn spring-boot:run`
2. Open browser at http://localhost:8080/

#### QR Code Scanning
Use a free QR Code Reader app to scan a QR code image:

- [Google Play](https://play.google.com/store/apps/details?id=tw.mobileapp.qrcode.banner)
- [Apple Store](https://apps.apple.com/us/app/qr-code-reader/id1200318119)

<br/>

#### Acknowledgements
Based on the qr-code-generator app built by [Kai Saborowski](https://github.com/ksbrwsk/qrcode-generator).

