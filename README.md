# Booking_API


GET HOTELS - http://localhost:8585/hotel 

POST HOTEL - http://localhost:8585/hotel/add 
{
    "name":"builtmoreeee",
    "address":"rustaveli"
}

GET ROOM - http://localhost:8585/room/not_free   http://localhost:8585/room/free    http://localhost:8585/room

POST ROOM - http://localhost:8585/room/add
{
  "roomNumber": "129",
  "hotel_id": 1,
   "price":100.0
}


GET RESERVATION - http://localhost:8585/reservation

POST RESERVATION - http://localhost:8585/reservation/add
{
  "checkInTime": "2023-06-10T14:00:00",
  "checkOutTime": "2023-06-15T12:00:00",
  "guestName": "ekaterine gurgenidze",
  "roomId": 4,
  "hotelId": 1
}

GET FREE ROOMS AND PRICES -  http://localhost:8585/hotel/free_rooms_prices
[1,2,3]

GET HOTEL REPORT - http://localhost:8585/hotel/hotel_report/1
response: 
{
    "data": {
        "hotel": [
            [
                "namm",
                2023,
                4,
                1,
                3956.2000999450684,
                131
            ]
        ]
    },
    "errors": {}
}

