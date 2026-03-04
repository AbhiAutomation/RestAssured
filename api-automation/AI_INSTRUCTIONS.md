# API Automation Framework Guidelines

## Objective
Build scalable and maintainable API Automation framework using:
- Java 17
- Rest Assured
- TestNG
- Maven

---

## Architecture Rules

1. Follow layered architecture:
   - base → request specification
   - client → API endpoints
   - utils → reusable helpers
   - tests → only test logic

2. Do NOT write API calls directly inside test classes.

3. All request specifications must extend BaseTest.

4. Use ResponseSpecification for validation standards.

---

## Coding Standards

- Use meaningful class names
- Avoid hardcoded URLs
- Base URI must come from config.properties
- Token must be dynamically generated
- Use POJO for request and response mapping

---

## Logging

- Use Rest Assured logging filters
- Log request and response in failure only

---

## Validation Strategy

- Status code validation
- Schema validation (if applicable)
- Field-level assertions
- Response time validation

---

## Environment Handling

- Support DEV, QA, PROD via config file
- Use Maven profiles

---

## Naming Convention

Test Class: UserApiTest
Client Class: UserClient
Base Class: BaseTest
Utils Class: JsonUtils

---

## Prohibited

- No static waits
- No hardcoded tokens
- No duplicate request specifications