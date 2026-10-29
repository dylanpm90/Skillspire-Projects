Week 7 Wednesday starter: where each file goes (project: tesla, package net.skillspire.tesla)

1. Vehicle.java, VehicleRepository.java, VehicleController.java
   -> src/main/java/net/skillspire/tesla/      (next to TeslaApplication.java)

2. schema.sql, data.sql
   -> src/main/resources/                      (next to application.properties)

3. new-vehicle.json, update-vehicle.json
   -> the tesla folder itself                  (next to pom.xml)

4. Add this one line to src/main/resources/application.properties:
   spring.datasource.url=jdbc:h2:mem:tesla;DB_CLOSE_DELAY=-1;NON_KEYWORDS=YEAR

Copy the files, not folders: don't drag a whole folder over your project's folders.
Tip: copy a file in File Explorer or Finder, then click the folder in IntelliJ's Project view and paste.

You write TODO 1 and TODO 2 in VehicleRepository.java in class.
