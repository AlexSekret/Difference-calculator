.DEFAULT_GOAL := build-run

setup:
	./gradlew wrapper --gradle-version 8.5

clean:
	./gradlew clean

build:
	./gradlew build

install:
	./gradlew clean install

run-dist:
	./build/install/app/bin/app src/test/resources/fixtures/file1.json src/test/resources/fixtures/file2.json

run:
	./gradlew run

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain

check-deps:
	./gradlew dependencyUpdates -Drevision=release

install-dist:
	./gradlew installDist

build-run: build run

do-all: clean build install-dist run-dist

.PHONY: build