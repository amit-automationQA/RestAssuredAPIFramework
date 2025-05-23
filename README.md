# 🚀 RestAssured API Automation Framework

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![RestAssured](https://img.shields.io/badge/RestAssured-008000?style=for-the-badge)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![JUnit](https://img.shields.io/badge/JUnit-25A162?style=for-the-badge&logo=junit5&logoColor=white)

> 💡 A robust REST API test automation framework built with RestAssured, Java, and JUnit to simplify API testing.

---

## 🧩 Features

- ✅ Built with **RestAssured** for easy HTTP request testing.
- ⚙️ Supports GET, POST, PUT, DELETE, PATCH methods.
- 🧪 **JUnit 5** integration for structured test execution.
- 🛠️ Maven-based project for dependency management.
- 📊 Generates detailed JUnit reports.
- 📁 Organized folder structure for easy maintenance.
- 🔒 Supports authentication mechanisms (Basic, OAuth, API keys).
- 🌐 Easily extendable to integrate with CI/CD pipelines.

---

<details>
<summary>📁 <strong>Project Structure</strong> (Click to expand)</summary>

```bash
├── src/main/java/             # Main source code (API utilities, clients)
├── src/test/java/             # Test scripts using JUnit
├── TestData/                  # Test data files (JSON, CSV, etc.)
├── Reports/                   # JUnit and custom reports
├── pom.xml                    # Maven project configuration
```

</details>

---

## ⚙️ Getting Started

### 🔧 Prerequisites

- JDK 8 or above
- Maven 3.6+
- Any IDE (IntelliJ IDEA, Eclipse)
- Internet connection to download dependencies

### 🛠️ Installation

```bash
git clone https://github.com/amit-automationQA/RestAssuredAPIFramework.git
cd RestAssuredAPIFramework
mvn clean install
```

### 🚦 Running Tests

```bash
mvn test
```

---

## 📊 Reporting

- JUnit generates reports in the `target/surefire-reports` directory.
- View detailed XML/HTML reports for test results.

---

## 🤝 Contributing

Contributions are welcome! Please:

1. Fork the repo 🍴
2. Create your feature branch ✨
3. Submit a pull request 🚀

---

## 📄 License

MIT License — feel free to use and modify.

---

> Made with ❤️ by [Amit](https://github.com/amit-automationQA)
