# junit5-surefire-failsafe-demo

JUnit5 and Maven Surefire, Failsafe plugin demo

- run junit5 test cases except `@Tag("tag2")` tagged test cases in maven-surefire-plugin (`mvn test`)
- run junit5 test cases only for `@Tag("tag2")` tagged test cases in maven-failsafe-plugin (`mvn integration-test` or `mvn verify`)
  - with customizing failsafe's `<includes>` configuration for including `**/Test*.java` files.

```
C:\work\SVNWORK\github\msakamoto-sf\junit5-surefire-failsafe-demo>mvnw clean verify

(...)

[INFO] --- maven-surefire-plugin:3.0.0-M3:test (default-test) @ junit5-surefire-failsafe-demo ---
[INFO]
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running demo.TestDemo1
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.028 s - in demo.TestDemo1
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO]
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ junit5-surefire-failsafe-demo ---
[INFO] Building jar: C:\work\SVNWORK\github\msakamoto-sf\junit5-surefire-failsafe-demo\target\junit5-surefire-failsafe-demo-1.0-SNAPSHOT.jar
[INFO]
[INFO] --- maven-failsafe-plugin:3.0.0-M3:integration-test (default) @ junit5-surefire-failsafe-demo ---
[INFO]
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running demo.Demo4IT
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.023 s - in demo.Demo4IT
[INFO] Running demo.TestDemo2
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.002 s - in demo.TestDemo2
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------

(...)
```

(Never run `Demo3IT` test case, because it is annotated as `@Tag("tag1")` and its filename does not match to surefire's target pattern.)

## environment

```
C:\work\SVNWORK\github\msakamoto-sf\junit5-surefire-failsafe-demo>mvnw -version
Apache Maven 3.6.1 (d66c9c0b3152b2e69ee9bac180bb8fcc8e6af555; 2019-04-05T04:00:29+09:00)
Maven home: C:\Users\msakamoto\.m2\wrapper\dists\apache-maven-3.6.1-bin\38pn40mp89t5c94bjdbeod370m\apache-maven-3.6.1
Java version: 11.0.3-BellSoft, vendor: BellSoft, runtime: C:\work\jdk\bellsoft-jdk11.0.3-windows-amd64
Default locale: ja_JP, platform encoding: MS932
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
```

## pom.xml

```
  <properties>
    (...)
    <junit5.version>5.4.2</junit5.version>
  </properties>

  <dependencies>

    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter-api</artifactId>
      <version>${junit5.version}</version>
      <scope>test</scope>
    </dependency>

    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter-engine</artifactId>
      <version>${junit5.version}</version>
      <scope>test</scope>
    </dependency>

  </dependencies>

  <build>
    <plugins>
      (..)
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>3.0.0-M3</version>
        <configuration>
          <excludedGroups>tag2</excludedGroups>
        </configuration>
      </plugin>

      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-failsafe-plugin</artifactId>
        <version>3.0.0-M3</version>
        <configuration>
          <includes>
            <include>**/IT*.java</include>
            <include>**/*IT.java</include>
            <include>**/*ITCase.java</include>
            <include>**/Test*.java</include>
          </includes>
          <groups>tag2</groups>
        </configuration>
        <executions>
          <execution>
            <goals>
              <goal>integration-test</goal>
            </goals>
          </execution>
        </executions>
      </plugin>

    </plugins>
  </build>

```
