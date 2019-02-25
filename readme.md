# 1. PROJECT DESCRIPTION

Project contains backend mechanics for the online store.

# 2. DEMO

Not available yet

# 3. REQUIREMENTS

- Java 8
- MySQL database

# 4. ENDPOINTS

## 4.1. PRODUCTS

Endpoints require ProductDto objects. ProductDto represents product.spec.json:
>       {
>           "id": 1,
>           "name": "product name",
>           "description": "product description",
>           "price": 1.99,
>           "groupId": 4
>       } 

### 4.1.1 products (GET)

Returns a list of ProductDto objects

### 4.1.2. products/{id} (GET)

Returns a ProductDto of a product with provided id number

### 4.1.3. products (POST)

Creates new product in database, requires ProductDto body. Id is generated automatically, so in post method id field can be skipped in json.  

### 4.1.4 products/{id} (PATCH)

Updates existing product. Requires id of the updated product and ProductDto body containing updated information

### 4.1.5 products/{id} (DELETE)

Deletes product of given id from database


## 4.2. GROUPS

Endpoints require GroupDto objects. GroupDto represents product.spec.json: 
>
>
>     {
>       "id": 1,
>        "name": "item",
>     }

### 4.1.1 groups (GET)

Returns a list of GroupDto objects

### 4.1.2 groups/{id} (GET)

Returns a GroupDto object of a group with provided id number

### 4.1.3 groups (POST)

Creates new product in database, requires GroupDto body. Id is generated automatically, so in post method id field can be skipped in json.

### 4.1.4 products/{id} (PATCH)

Updates existing product group. Requires id of the updated product and ProductDto body containing updated information.


## 4.3. CARTS

Endpoints require CartDto objects. CartDto represents cart.spec.json:

>
>
>     {
>       "id": 1,
>        "name": "item",
>        "description": "description",
>        "price": 23.23,
>        "groupId": "1"
>     },
>
>     {
>        "id": 2,
>        "name": "item 2",
>        "description": "description 2",
>        "price": 0.99,
>        "groupId": "3"
>     }

### 4.3.1 cart (GET)

Returns a CartDto of a cart. If current cart is null, creates new one. Requires HttpServletRequest.

### 4.3.2 cart (POST)

Adds products to the cart and returns CartDto. Requires a list of ProductDto and HttpServletRequest. 

### 4.3.3 cart/{productId} (DELETE)

Removes product of given id from the cart, returning no value. Requires product id and HttpServletRequest.

## 4.4. ORDERS


### 4.4.1 orders (GET)

Returns a list of OrderDto objects.

### 4.4.2 orders/{id} (GET)

Returns an OrderDto of the order with given id. Requires order id.

### 4.4.3 orders/{cartId}/{userId} (POST)

Creates an order based on provided cart id and user id, no return type. Requires cart id and user id.

### 4.4.4 orders (PATCH)

Updates order, no return type. Requires OrderDto with updated values.

### 4.4.5 orders (DELETE)

Deletes order from database, no return type. Requires OrderDto.

## 4.5. USERS

Endpoints require UserDto objects. UserDto represents users.spec.json:
>
>       {
>        "id": 1,
>        "username": "Piotr",
>        "status": "1",
>        "userKey": 59403
>       }
>

### 4.5.1 users (POST)

Creates new user, no return type. Requires UserDto.

### 4.5.2 users/{id} (PATCH)

Bans user of given id, returns UserDto. Requires user id.

### 4.5.3 users/key/{id} (PATCH)

Generates validation key. Key is valid for 1 hour.

