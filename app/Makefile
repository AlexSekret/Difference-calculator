install:
	./gradlew installDist

run-dist:
	./build/install/app/bin/app ./src/test/resources/fixtures/file1.json ./src/test/resources/fixtures/file2.json

run-dist-help:
	./build/install/app/bin/app -h

run-dist-version:
	./build/install/app/bin/app -V

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain

test:
	./gradlew test

clean:
	./gradlew clean

clean-install: clean install run-dist
run:
	./gradlew run

.PHONY: build