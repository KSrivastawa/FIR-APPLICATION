# FIR-APPLICATION

### Build Rest API for FIR **Application**

**Features of this application:**

1. Users can register themselves.
2. Users can log into the system.
3. The application allows users to file an FIR against multiple users
4. Users can view the past FIRs filed by him
5. Users can withdraw an FIR within 24hrs of filing


Rest API for User Resource
| HTTP Method |           URL Path            |   Status Code   |            Description                    |
| ------------| ----------------------------- | --------------- | ----------------------------------------- |
| POST        | /masaifir/user/register       | 201(CREATED)    | Register a User                           |
| POST        | /masaifir/user/login          | 200(OK)         | Login a User                              |
| GET         | /masaifir/user/{userId}/fir/  | 200(OK)         | get list of all FIRs filed by the user    |
| Delete      | /masaifir/user/{userId}/      | 200(OK)         | User can withdraw FIR within 24hr of filing|

Rest API for Fir Resource
| HTTP Method |           URL Path            |   Status Code   |            Description                    |
| ------------| ----------------------------- | --------------- | ----------------------------------------- |
| POST        | /masaifir/user/fir            | 201(CREATED)    | File an FIR against one or many users     |                      |

### Tasks performed

- Build Rest API for User, FIR
- Use MySQL database
- Use Response Entity depending upon the output.

- Complete the All User and FIR APIs
- Establish a relationship between User and FIR.

- Implement Exception Handling in the project
    - Handle Custom Exception
    - Create Custom Error Structure Response for Client
    - Create Global Exception Handler to handle the exceptions globally: All other exception handled in this single place
- Add Validations
    - First Name must not contain numbers or special characters
    - Last Name must not contain numbers or special characters
    - Mobile number must have 10 digits
    - Age must be above 8 years
    - Gender must be either male or female or transgender
    - Password should be alphanumeric and must contain 6-12 characters having at least one special character, one upper case, one lowercase, and one digit.
    
Using CurrentUserSession

- Implement Authentication (Verifying the User credentials)



