# Monday's pages (Week 9), in teaching order: open them in a BROWSER

Restart FleetApplication first: the data resets every run (vehicles 1 Model S, 2 Model 3, 3 Model Y).
Pages are at /vehicles. Friday's JSON API is unchanged at /api/vehicles (the requests further down).

1. localhost:8080/vehicles -> the list page: three links, each with its year
2. localhost:8080/api/vehicles -> the same three vehicles as JSON (Friday's @RestController, same service)
3. Click Model S (localhost:8080/vehicles/1) -> its page: Model S, Year 2019 (after TODO 1: Id 1)
4. localhost:8080/vehicles/99 -> "Vehicle not found" page, status 404 (browser DevTools > Network shows the 404)
5. localhost:8080/api/vehicles/99 -> 404 with an empty body (Friday's)
6. Click "Add vehicle" (localhost:8080/vehicles/new) -> the form; Year shows 0 (a new Vehicle's int year)
7. Fill in Model X, 2025, Save -> before TODO 2: an error page, 405 Method Not Allowed (no POST handler).
   After TODO 2 and a restart: back on the list (the address bar says /vehicles), "Vehicle added!", four vehicles
8. Refresh the list page -> the message is gone, and still four vehicles (Post/Redirect/Get: refresh repeats the GET)
9. localhost:8080/api/vehicles -> four vehicles: the page and the API share one database
Lab reference (complete project only): on a vehicle's page, Edit -> change the year -> Save -> "Vehicle updated!";
   Delete -> the list with "Vehicle 4 deleted."; localhost:8080/vehicles/99/edit -> the not-found page

---

# Friday's requests (the JSON API), in teaching order

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
