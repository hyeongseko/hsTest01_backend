plugins {
    id("org.springframework.boot") version "3.2.2" // 최신 Spring Boot 버전
    id("io.spring.dependency-management") version "1.1.4"
    id("java")
}

group = "com.capybara"
version = "1.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_21

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") } // ✅ Kotlin DSL 문법 적용
    maven { url = uri("https://repo.oracle.com/maven") }
}

dependencies {
    // ✅ Spring Boot Web Starter (필수)
    implementation("org.springframework.boot:spring-boot-starter-web")


    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    runtimeOnly("com.oracle.database.jdbc:ojdbc8:21.1.0.0")
    implementation("org.bgee.log4jdbc-log4j2:log4jdbc-log4j2-jdbc4.1:1.16")
    //  Lombok (자동 코드 생성)
    implementation("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    implementation("org.springframework.boot:spring-boot-starter-webflux")

    // querydsl
    implementation("com.querydsl:querydsl-jpa:5.0.0:jakarta")
    implementation("com.querydsl:querydsl-core")
    implementation("com.querydsl:querydsl-collections")
    annotationProcessor("com.querydsl:querydsl-apt:5.0.0:jakarta")
    annotationProcessor("jakarta.persistence:jakarta.persistence-api")

    // ✅ 테스트 관련

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.test {
    useJUnitPlatform()
}

val querydslDir = "src/main/generated"

// 컴파일시 querydslDir 위치에 Qfile 생성되도록 설정
tasks.withType<JavaCompile> {
    options.generatedSourceOutputDirectory.set(file(querydslDir))
}

sourceSets {
    main {
        java.srcDirs("src/main/java", querydslDir)
    }
}

tasks { // build.clean 하는 경우 Qfile 삭제 될 수 있도록 설정
    getByName<Delete>("clean") {
        delete.add(querydslDir)
    }
}