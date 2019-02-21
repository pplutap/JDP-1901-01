#1. PROJECT DESCRIPTION#
Project contains backend mechanics for the online store.

#2. DEMO#
Not available yet

#3. REQUIREMENTS#
- Java 8
- MySQL database

#4. RUNNING PROJECT#

#5. ENDPOINTS#

##5.1. PRODUCTS##
Endpoints require ProductDto objects that represent single product in database. ProductDto represents product.spec.json:
>{
>
>"id": 1,
>
>"name": "product name",
>
>"description": "product description",
>
>"price": 1.99,
>
>"groupId": 4
>
>} 

###5.1.1 products (GET)###
Returns a list of ProductDto objects

###5.1.2. products/{id} (GET)###
Returns a ProductDto of a product with provided id number

###5.1.3. products (POST)###
Creates new product in database, requires ProductDto body. Id is generated automatically, so in post method id field can be skipped in json.  

###5.1.4 products/{id} (PATCH)###
Updates existing product. Requires id of the updated product and ProductDto body containing updated information

###5.1.5 products/{id} (DELETE)###
Deletes product of given id from database


##5.2. GROUPS##
Endpoints require GroupDto objects that represent single product group (category) in database. GroupDto represents product.spec.json: 
>{
>
>   "id": 1,
>
>   "name": "Clothes"
>
>}

###5.1.1 groups (GET)###
Returns a list of GroupDto objects

###5.1.2 groups/{id} (GET)###
Returns a GroupDto object of a group with provided id number

###5.1.3 groups (POST)###
Creates new product in database, requires GroupDto body. Id is generated automatically, so in post method id field can be skipped in json.

###5.1.4 products/{id} (PATCH)###
Updates existing product group. Requires id of the updated product and ProductDto body containing updated information.


##5.3. CARTS##


##5.4. ORDERS##


##5.5. USERS##


#6. USAGE#


#7. TROUBLESHOOTING#