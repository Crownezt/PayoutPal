# PayoutPal

Welcome to the Payment API for PayoutPal Startup! This API allows you to facilitate card payments and retrieve payment information. As of today, the system supports card payments, but it's designed to be extensible for future payment types. The API is also built to cater to various devices, including mobile and browsers.

## API Endpoints

### 1. Make Payment
#### Description
This endpoint allows you to initiate a payment transaction.
Provide the payment details, including the amount, payment type
(currently supporting "card"), device type (e.g., "mobile" or "browser"), 
the card number, payer and recipient's account number .

- Endpoint: `/api/make_payment`

#### Request
- Method: `POST`
- Content-Type: `application/json`

```json
{
  "amount": 100.00,
  "paymentType": "DEBIT_CARD",
  "deviceType": "POS",
  "cardNumber": "1234-5678-9012-3456",
  "recipientAccount": "2150423810",
  "payerAccount": "2184760402"
}
```
#### Response
- Status: `200 OK`
- Content-Type: `application/json`
```json
{
  "id": 1,
  "amount": 100.00,
  "paymentType": "DEBIT_CARD",
  "deviceType": "POS",
  "cardNumber": "1234-5678-9012-3456",
  "recipientAccount": "2150423810",
  "payerAccount": "2184760402"
}
```
***

### 2. Get Payments
#### Description
This endpoint retrieves a list of payments. The response includes an
array of payment objects with details such as ID, amount, payment type,
device type, recipient account number payer account number and card number.
- Endpoint: `/api/get_all_payments`

#### Request
- Method: `GET`
- Content-Type: `NILL`


#### Response
- Status: `200 OK`
- Content-Type: `application/json`

```json
[
  {
    "id": 1,
    "amount": 100.00,
    "paymentType": "DEBIT_CARD",
    "deviceType": "POS",
    "cardNumber": "1234-5678-9012-3456",
    "recipientAccount": "2150423810",
    "payerAccount": "2184760402"
  },
  {
    "id": 2,
    "amount": 500.00,
    "paymentType": "DEBIT_CARD",
    "deviceType": "POS",
    "cardNumber": "1234-5675-9012-3456",
    "recipientAccount": "2150423810",
    "payerAccount": "2184760402"
  }
]
```
***

## PLEASE NOTE
### Make Payment Endpoint is heavily relying on Account Endpoints 
### (i.e Create Account and Credit Account)
#### Below are Account endpoints

### `CREATE ACCOUNT`
- Endpoint: `/api/create_account`
#### Request
- Method: `POST`
- Content-Type: `Params/form`


#### Response
- Status: `200 OK`
- Content-Type: `application/json`

```json
{
  "id": 2,
  "accountName": "Folami Daniel",
  "accountNumber": "2184760402",
  "balance": 0
}
```
***

### `CREDIT ACCOUNT`
- Endpoint: `/api/credit_account`
#### Request
- Method: `POST`
- Content-Type: `Params/form`


#### Response
- Status: `200 OK`
- Content-Type: `String`

```
Successfully credited
```
****

### `DEBIT ACCOUNT`
- Endpoint: `/api/debit_account`
#### Request
- Method: `POST`
- Content-Type: `application/json`


#### Response
- Status: `200 OK`
- Content-Type: `String`

```
Successfully debited
```




***

### 3. Get Payment by ID
Description
This endpoint retrieves a specific payment by its ID. 
The {id} is to be replaced in the endpoint with the 
actual payment ID to get details for a specific payment.
- Endpoint: `/api/get_payment/{id}`

#### Request
- Method: `GET`
_Replace {id} with the actual payment ID._

#### Response
- Status: `200 OK`
- Content-Type: `application/json`

```json
{
"id": 1,
"amount": 50.00,
"paymentType": "card",
"deviceType": "browser",
"cardNumber": "9876-5432-1098-7654"
}
```

