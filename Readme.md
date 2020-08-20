
## Architecture

###### Database Structure

![](.Readme_images/schema.png)


## Build and start services

###### Build
```bash
./gradlew build
```

###### Start Database

```bash
docker-compose up postgres
```


###### Start Auth Server

```bash
docker-compose up auth-api
```


###### Start Resource Server

```bash
docker-compose up resource-server
``` 

## Usage

###### Get token
![](.Readme_images/postman_get_token_1.png)

![](.Readme_images/postman_get_token_2.png)


If everything is fine, you should receive a response like this:

```json
{
    "access_token": "a23d2b03-3e1b-4221-98e2-8aa7838fdb64",
    "token_type": "bearer",
    "refresh_token": "69f6709f-981a-4900-82c7-9487e0feb37e",
    "expires_in": 192,
    "scope": "read write trust"
}
```

###### Get Resources using token
```bash
curl --location --request GET 'http://localhost:8081/customers/?size=3' \
--header 'Authorization: Bearer a23d2b03-3e1b-4221-98e2-8aa7838fdb64'
```


And the response should be:
````json
{
    "content": [
        {
            "id": 2,
            "name": "customer_2",
            "vendor": {
                "id": 2,
                "username": "user"
            }
        },
        {
            "id": 3,
            "name": "customer_3",
            "vendor": {
                "id": 2,
                "username": "user"
            }
        },
        {
            "id": 6,
            "name": "customer_6",
            "vendor": {
                "id": 2,
                "username": "user"
            }
        }
    ],
    "pageable": {
        "sort": {
            "unsorted": true,
            "sorted": false,
            "empty": true
        },
        "pageSize": 3,
        "pageNumber": 0,
        "offset": 0,
        "unpaged": false,
        "paged": true
    },
    "last": false,
    "totalPages": 89,
    "totalElements": 266,
    "sort": {
        "unsorted": true,
        "sorted": false,
        "empty": true
    },
    "numberOfElements": 3,
    "first": true,
    "size": 3,
    "number": 0,
    "empty": false
}
````