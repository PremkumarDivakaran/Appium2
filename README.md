# Sauce Labs Mobile App Testing (Android & iOS)

This repository contains the configuration and setup for running mobile app tests on Sauce Labs for both **Android** and **iOS** platforms.

## Prerequisites

Before running the tests locally, ensure that the following tools are installed:

- **Java 11** (for Maven)
- **Maven** (for test execution)
- **Appium** (for managing mobile device interactions)
- **Browserstack Account** (for remote testing)
- **Android (Android Studio) and IOS (xcode) Simulators** (for local testing)

## Configuration

The test execution can be configured via the `config.properties` file. This file contains various parameters like **platform** and **runmode**. Follow the instructions below to configure the file based on your needs.

### Steps to Configure `config.properties`:

1. Navigate to the `config.properties` file in the repository.
2. Set `runmode` to `local` to run tests locally.
    ```properties
    runmode=local
    ```
   OR for browserstack:
    ```properties
    runmode=browserstack
    ```
3. Set the platform for which you want to run tests (`android` or `ios`).
    ```properties
    platform=android
    ```
   OR for iOS:
    ```properties
    platform=ios
    ```

## Running Tests Locally

To run the tests locally, follow these steps:

1. **Set up your local environment** by ensuring you have the required dependencies installed.
2. **Configure the `config.properties` file**:
   - Set `runmode=local`
   - Set `platform=android` or `platform=ios` based on your testing requirements.

3. **Run the tests** with Maven by executing the following command:

   ```bash
   mvn clean test

## Running Tests in Browserstack from local (Using Browserstack SDK)

To run the tests in browserstack, follow these steps:

1. **Set Browserstack credentials in Env Variable based on machine OS**
   - Set `BROWSERSTACK_USERNAME`
   - Set `BROWSERSTACK_ACCESS_KEY`
2. **Run Android Test using maven command**:
   ```bash
   mvn clean test -Dbrowserstack.config="browserstack/local_browserstack_android.yml" -Dplatform=ANDROID

3. **Run IOS Test using maven command**:
   ```bash
   mvn clean test -Dbrowserstack.config="browserstack/local_browserstack_ios.yml" -Dplatform=IOS

## Running Tests in Browserstack from github actions (Using Browserstack SDK)

1. Go the Github Repo.
2. Navigate to Actions tab.
3. Click on the `Run Tests on BrowserStack` workflow.
4. Click on the `Run Workflow` button in the top right corner. 
