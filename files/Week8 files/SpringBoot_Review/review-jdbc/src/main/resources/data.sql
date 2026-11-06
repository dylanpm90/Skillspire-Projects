-- data.sql: runs right after schema.sql, on every startup. Text goes in single quotes.
-- No id column: the database fills in 1, 2, 3, 4. Same four cars as Monday's fleet project.

INSERT INTO vehicles (model, year) VALUES ('Model S', 2019);
INSERT INTO vehicles (model, year) VALUES ('Model S', 2023);
INSERT INTO vehicles (model, year) VALUES ('Model 3', 2021);
INSERT INTO vehicles (model, year) VALUES ('Model Y', 2024);

-- PREDICT: POST a fifth car, check /vehicles, then restart the app. How many cars now?
