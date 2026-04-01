exceptions/
│
├── FrameworkException.java        → Base exception (Parent)
├── BrowserException.java          → Driver issues
├── ElementException.java          → Element not found, not clickable
├── WaitException.java             → Wait failures
├── ConfigException.java           → Config file issues
├── DataException.java             → Excel/JSON errors
├── APIException.java              → API failures (optional)
└── AssertionException.java        → Validation failures