# Friday's requests, in teaching order

Send them with Apidog Fast Request in IntelliJ (or curl). Restart FleetApplication first: the data resets every run.
Data after startup: drivers 1 Alice, 2 Bob. Vehicles 1 Model S (2019, Alice), 2 Model 3 (2021, Alice), 3 Model Y (2024, Bob).
A vehicle's JSON has id, model, year and stations; no driver (Vehicle.driver is the @JsonBackReference side).

## REST Controllers lesson

1. GET /api/vehicles -> 200, the three vehicles
2. GET /api/vehicles/1 -> 200, Model S, stations Seattle and Tacoma
3. GET /api/vehicles/99 -> 404
4. POST /api/vehicles, body {"model": "Model X", "year": 2025} -> 201, the new vehicle with id 4
5. DELETE /api/vehicles/4 -> before TODO 1: 405 Method Not Allowed. After TODO 1 and the restart, send request 4 again first (the restart wiped vehicle 4; it gets id 4 again), then DELETE: 204. Send it again: 404
6. PUT /api/vehicles/99, body {"model": "Model X", "year": 2025} -> 404
7. POST /api/vehicles/1/unlock -> 200, text: Tesla vehicle 1 unlocked. (Optional: class only mentions it.)

## Params and Path Variables lesson

8. GET /api/vehicles/2/model -> 200, text: Model 3.  GET /api/vehicles/99/model -> 404
9. GET /api/vehicles/search -> before TODO 2: 400 (model is required). After TODO 2: 200, all three
10. GET /api/vehicles/search?model=Model%20S -> 200, the Model S (works before and after TODO 2)
11. GET /api/vehicles/search?minYear=2021 -> 200, Model 3 and Model Y
12. GET /api/vehicles/search?model=Model%20S&minYear=2021 -> 200, [] (the only Model S is from 2019)
13. GET /api/vehicles/search?minYear=-5 -> 400, body: minYear can't be negative: -5
14. GET /api/vehicles/search?minYear=abc -> 400
15. GET /api/drivers/1/vehicles -> 200, Model S and Model 3
16. GET /api/drivers/1/vehicles?minYear=2020 -> 200, Model 3
17. GET /api/drivers/99/vehicles -> 200, [] (this endpoint doesn't check that the driver exists)
18. GET /api/drivers/1/vehicles/2 -> 200, Model 3
19. GET /api/drivers/2/vehicles/2 -> 404 (vehicle 2 is Alice's, not Bob's)
20. PATCH /api/vehicles/3, body {"year": 2025} -> 200, Model Y, 2025
21. PUT /api/vehicles/3, body {"year": 2025} -> 200, but model is now null
22. PATCH /api/vehicles/3, body {"model": "Model Y"} -> 200, Model Y, 2025 again

## The same as curl (Git Bash, macOS, Linux)

For an Assignment 3 or 4 README. -i prints the status line. Quote any URL that has &.

    curl -i localhost:8080/api/vehicles/99
    curl -i -X POST localhost:8080/api/vehicles -H "Content-Type: application/json" -d '{"model": "Model X", "year": 2025}'
    curl -i -X DELETE localhost:8080/api/vehicles/4
    curl -i "localhost:8080/api/vehicles/search?model=Model%20S&minYear=2021"
    curl -i -X PATCH localhost:8080/api/vehicles/3 -H "Content-Type: application/json" -d '{"year": 2025}'

In Windows PowerShell, type curl.exe instead of curl; the JSON quoting differs there, so Apidog is easier.
