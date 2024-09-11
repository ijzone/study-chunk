# Test Env. Settings
## Test Files
### Input File
#### Change below code
- from
  ```java
  BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
  ```
- to
  ```java
  BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getenv("input")));
  ```
### Output File
```java
BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("output")));
```
- Environment variables
  ```
  input=path/to/file/location;output=path/to/file/location
  ```
  ![img.png](img.png)