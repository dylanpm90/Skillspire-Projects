Week 7 Friday starter: transactions. Everything goes into your tesla project from this week.

1. accounts-schema.sql: copy its lines to the END of src/main/resources/schema.sql
   (keep the vehicles table; add below it).
2. accounts-data.sql: copy its lines to the END of src/main/resources/data.sql.
3. Account.java, BankService.java, TransferController.java: put them next to
   TeslaApplication.java (src/main/java/net/skillspire/tesla).
   If your package is different, change the first line of each file to match TeslaApplication.java.
4. application.properties: add this line at the end:
   logging.level.org.springframework.jdbc=DEBUG
5. Run TeslaApplication. Open localhost:9090/accounts and localhost:9090/accounts/total
   (use 8080 if that's the port your startup log shows).
