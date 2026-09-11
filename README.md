![](https://github.com/Lylio/image-repo/blob/master/logos/spring-boot.png?raw=true)
![](https://github.com/Lylio/image-repo/blob/master/logos/thymeleaf.png?raw=true)
![](https://github.com/Lylio/image-repo/blob/master/logos/qrcode.png?raw=true)

# Quarcode

|              |                                                                                                                                                                                                                               |
|--------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Demo Link    | [quarcode-production-2d39.up.railway.app](quarcode-production-2d39.up.railway.app)                                                                                                                                                                          |
| Tech Stack   | ![Spring Boot](https://img.shields.io/badge/springboot-000000?style=for-the-badge&logo=springboot&logoColor=green) ![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?logo=thymeleaf) ![ZXing](xing) ![Maven](https://img.shields.io/badge/MAVEN-000000?style=for-the-badge&logo=apachemaven&logoColor=blue) |
| Cloud Deploy | ![Railway](https://img.shields.io/badge/Railway-131415?style=for-the-badge&logo=railway&logoColor=white)|
| Compiler     | ![Node](https://img.shields.io/badge/NODE%20-V.16.13.0-339933?style=for-the-badge)                                                                                                                                            |
| Top Language | ![Github Language](https://img.shields.io/github/languages/top/lylio/tic-tac-toe?style=for-the-badge)                                                                                                                         |
| Last Commit  | ![Github Commit Activity](https://img.shields.io/github/last-commit/lylio/tic-tac-toe/main?style=for-the-badge)                                                                                                               |

### Description
A QR Code generator using Thymeleaf and ZXing. Demo can be found at:  
https://quarcode.lyle.app/

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
Use a free QR Code Reader app to scan a QR code image on your phone:

- [Google Play](https://play.google.com/store/apps/details?id=tw.mobileapp.qrcode.banner)
- [Apple Store](https://apps.apple.com/us/app/qr-code-reader/id1200318119)

<br/>

#### Acknowledgements
Based on the qr-code-generator app built by [Kai Saborowski](https://github.com/ksbrwsk/qrcode-generator).

