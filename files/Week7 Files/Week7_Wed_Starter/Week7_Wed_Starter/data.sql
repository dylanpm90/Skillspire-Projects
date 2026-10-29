-- data.sql: runs right after schema.sql, on every startup. Text goes in single quotes.
-- No id column here: the database fills in 1, 2, 3.

INSERT INTO vehicles (model, year) VALUES ('Model S', 2022);
INSERT INTO vehicles (model, year) VALUES ('Model 3', 2023);
INSERT INTO vehicles (model, year) VALUES ('Model Y', 2024);

-- PREDICT: POST a fourth car and check /vehicles. Then stop the app and run it again.
--          How many cars does /vehicles show now?
