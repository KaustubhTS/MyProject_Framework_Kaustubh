Project_Name
│
├── src/main/java
│   ├── base/                       → Base setup (driver init, teardown)
│   │      └── BaseTest.java
│   │
│   ├── factory/                    → Driver management (ThreadLocal)
│   │      └── DriverFactory.java
│   │
│   ├── pages/                      → Page Object Model (POM)
│   │      ├── LoginPage.java
│   │      ├── HomePage.java
│   │      ├── ProductPage.java
│   │      └── CheckoutPage.java
│   │
│   ├── pageObjects/ (optional)     → Page interfaces / abstraction layer
│   │
│   ├── actions/                    → Business actions layer
│   │      └── LoginActions.java
│   │
│   ├── utils/                      → Common reusable utilities
│   │      ├── ExcelUtil.java
│   │      ├── WaitUtil.java
│   │      ├── ConfigReader.java
│   │      ├── DateUtil.java
│   │      ├── ScreenshotUtil.java
│   │      └── JavaScriptUtil.java
│   │
│   ├── constants/                  → Framework constants
│   │      └── FrameworkConstants.java
│   │
│   ├── enums/                      → Enum classes (browser, environment)
│   │      └── BrowserType.java
│   │
│   ├── exceptions/                 → Custom exceptions
│   │      └── FrameworkException.java
│   │
│   ├── reports/                    → Report manager (Extent wrapper)
│   │      └── ExtentManager.java
│   │
│   ├── listeners/                  → TestNG listeners
│   │      └── TestListener.java
│   │
│   ├── logger/                     → Logging wrapper (Log4j)
│   │      └── LoggerUtil.java
│   │
│   └── api/ (optional)             → API layer (RestAssured integration)
│
│
├── src/test/java
│   ├── stepDefinitions/            → Cucumber step definitions
│   │      └── LoginSteps.java
│   │
│   ├── hooks/                      → Before/After hooks
│   │      └── Hooks.java
│   │
│   ├── runner/                     → Test runner class
│   │      └── TestRunner.java
│   │
│   ├── tests/ (optional)           → TestNG classes (hybrid use)
│   │
│   └── retry/                      → Retry logic
│          └── RetryAnalyzer.java
│
│
├── src/test/resources
│   ├── features/                   → Cucumber feature files
│   │      ├── login.feature
│   │      ├── checkout.feature
│   │
│   ├── testdata/                   → Data Driven files
│   │      ├── TestData.xlsx
│   │      ├── TestData.json
│   │
│   ├── config/                     → Configuration files
│   │      ├── config.properties
│   │      ├── qa.properties
│   │      ├── uat.properties
│   │
│   ├── log4j2.xml                  → Logging configuration
│   │
│   └── schemas/ (optional)         → JSON schema validation
│
│
├── reports/
│   ├── extent-reports/             → HTML reports
│   ├── screenshots/                → Failure screenshots
│   └── logs/                       → Execution logs
│
├── test-output/                    → TestNG default reports
│
├── logs/                           → Log4j logs (external)
│
├── .github/                        → CI/CD pipelines (GitHub Actions)
│
├── Jenkinsfile                     → Jenkins pipeline config
│
├── docker/ (optional)              → Docker setup for execution
│
├── pom.xml                         → Maven dependencies
│
├── testng.xml                      → Parallel execution config
│
└── README.md                       → Project documentation