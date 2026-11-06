# Enterprise-Grade Hybrid Automation Framework (Flagship)

A production-ready, enterprise-grade test automation framework built with **Selenium WebDriver + Java + TestNG + Maven**. This is a flagship project designed to demonstrate professional-level framework architecture, CI/CD integration, and reporting capabilities to recruiters.

## Features

- **Page Object Model (POM):** Clean separation of test logic and page structure
- **Cross-Browser Support:** Run tests on Chrome, Firefox, and Edge
- **Headless Mode:** Optimized for CI/CD environments
- **Parallel Execution:** TestNG thread pool for faster test runs
- **Advanced Reporting:** ExtentReports with detailed pass/fail metrics
- **Structured Logging:** Log4j2 for comprehensive execution logs
- **Data-Driven Testing:** Apache POI for Excel-based test data
- **CI/CD Pipeline:** GitHub Actions integration with artifact upload
- **Modular Architecture:** Base, pages, utils, and reports layers

## Project Structure

```
Enterprise-QA-Framework/
├── .github/workflows/
│   └── ci-cd.yml          # GitHub Actions CI/CD pipeline
├── src/
│   ├── main/java/com/saucedemo/
│   │   ├── base/          # BaseTest.java - Driver setup & teardown
│   │   ├── pages/         # Page Object Model classes
│   │   │   ├── LoginPage.java
│   │   │   ├── InventoryPage.java
│   │   │   ├── CartPage.java
│   │   │   └── CheckoutPage.java
│   │   ├── reports/       # ExtentReportManager.java
│   │   └── utils/         # Log.java, ExcelUtils.java
│   └── test/java/com/saucedemo/tests/  # SauceDemoTests.java
│   └── test/resources/   # config.properties, log4j2.xml, testng.xml
├── logs/                  # Runtime logs
└── reports/               # Generated ExtentReport.html
```

## Tech Stack

| Technology | Purpose |
|------------|---------|
| Selenium WebDriver 4.25.0 | Browser automation |
| Java 11 | Core programming language |
| TestNG 7.10.2 | Test framework with parallel execution |
| Maven | Build & dependency management |
| ExtentReports 5.1.2 | Interactive HTML test reports |
| Log4j2 2.23.1 | Structured logging |
| Apache POI 5.2.5 | Excel-based data-driven testing |
| GitHub Actions | CI/CD pipeline |

## Demo Walkthrough

🎬 **[Open the interactive walkthrough](walkthrough.html)** — an animated, self-contained demo that plays the framework's 4-test run step by step: the architecture flow, browser actions, execution log, and a live ExtentReport dashboard. It also has an embedded "Knowledge Check" quiz for interview prep. Just open `walkthrough.html` in any browser (no internet/setup needed).

🎥 **[Cinematic demo video](demo/qa-framework-walkthrough.mp4)** — a 22s, 1080p/30fps H.264 video (1080p) rendered with HyperFrames. It walks through the opening title, the POM architecture pipeline, the 4-test run, and the ExtentReport dashboard. Great for attaching to job applications or the repo's "About" section.

> Note: both are animated reproductions of the framework's behavior, not screen recordings — the real run output lives in `logs/automation.log` and `reports/ExtentReport.html`.

## Quick Start

### Prerequisites
- Java 11 or higher
- Maven 3.6+
- Chrome, Firefox, or Edge installed

### Run Locally

```bash
# Clone the repository
git clone https://github.com/JustInCasesss/Enterprise-QA-Framework.git
cd Enterprise-QA-Framework

# Run tests (default: Chrome headless)
mvn clean test
```

### Run on Specific Browser

```bash
mvn test -Dbrowser=firefox
mvn test -Dbrowser=edge
```

### CI/CD Pipeline

The framework includes a `.github/workflows/ci-cd.yml` workflow that:
1. Triggers on push and pull request to `main` branch
2. Runs tests on Chrome and Firefox in parallel
3. Uploads ExtentReport and logs as build artifacts

## Test Coverage

The framework currently covers:
- **Login:** Valid credentials, locked-out user error handling
- **Inventory:** Product listing verification, add-to-cart functionality
- **Cart:** Item count validation, removal, checkout flow
- **Checkout:** Complete purchase flow with form validation

## Key Architecture Decisions

1. **BaseTest Pattern:** Shared driver initialization and configuration loading
2. **Page Object Model:** Each page is a self-contained class with its locators and methods
3. **ExtentReport Singleton:** Thread-safe report initialization for parallel execution
4. **Externalized Config:** Browser, URL, and timeouts managed via `config.properties`
5. **GitHub Actions:** Matrix build strategy for cross-browser testing

## Security & Best Practices

- All locators are encapsulated as private fields within Page Objects
- Test data is externalized (Excel/properties) — no hardcoded credentials in code
- CI/CD uses `actions/checkout@v4` with explicit ref pinning
- No untrusted inputs are interpolated into shell commands
- Reports are generated locally and uploaded as artifacts (not committed to repo)

## License

MIT