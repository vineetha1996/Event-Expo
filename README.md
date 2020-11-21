# Project Name: Event-Expo.

## Team Members:
1. Vineetha Yenugula.
2. Annie Samarpitha Chandolu.
3. Alekhya Jaddu.
4. Bhanuprakash Thota.

## Description:
EventExpo app allows users to reserve tickets for all kinds of events which include sports, harvesting, kayaking, painting, and many more. EventExpo allows users to host events. The major advantage of using the EventExpo app is to handle all the events together at one place where users can switch to different pages inside the app rather than opening a different app for each type of event resulting(results in) good user experience by using EventExpo App. Sign-Up the EventExpo and let the events add wings to your daily life.

## Main Feature:
Proposed an oppurtunity to Book different Categories and different kinds of Events like Kayaking, Painting, Cricket Online in single application.

## Risky Components:
##### Uses an outside API:
- The app will be hosted on an external API, i.e., Gennymotion. This will give us clearer idea about layout and navigation of the pages developed.
##### Requires Functionality NOT discussed:
- As we will be using Firebase for real-time data handling, it will be a bit difficult to navigate through this new functionalities, adding and retreiving data.
##### Requires Functionality will be discussed:
- Data base services and handling is yet to be understood and will be discussed later.

## Individual Contributions:

- [Vineetha Yenugula](https://github.com/vineetha1996/event-expo/commits?author=vineetha1996)
- [Annie samarpitha Chandolu](https://github.com/vineetha1996/event-expo/commits?author=annie0sc)
- [Alekhya Jaddu](https://github.com/vineetha1996/event-expo/commits?author=alekhyajaddu)
- [BhanuPrakash Thota](https://github.com/vineetha1996/event-expo/commits?author=BhanuprakashThota)


## Activities/Screens:
The following activities are taken in the device "Nexus 5X API 26".

### Login Screen:

![Login Screen](https://github.com/vineetha1996/event-expo/blob/master/screens/login.png)

- If the user is using this application for the first time he needs to register first by filling all the deails that are asked in the register page.
- The given data will be stored in the firebase so that the user don't need to register everytime,when he want to use the application he can simply login with the username
  and matching password.
- If the user forgot the password to get signin he can reset his password by clicking on the forgot password textView.
- If we click on the forgotpassword? TextView navigates to the reset password page where user can reset his/her password and that gets updated in the database.
- If we click on the Admin? TextView it navigates to the Admin login page where we have given only one admin credentials with password.
- If we click on the login button after giving the correct username and password this page navigates to the user home maintenance activity.
  
### User Maintainence Screen:

![user maintainence](https://github.com/vineetha1996/event-expo/blob/master/screens/userMaintainence.JPG)

- In maintenance page we have provided an few options for the user like List of Events available, user profile, about app and order history where user can see all the events   which he had added in to the cart.
- If we click on List of Events it directly navigates to the events available on that day with necessary details of event.
- If we click on profile text view it navigates to the profile page where user can find details he/she provided and he can also edit details, it gets updated in the database   too. 
- If we click on about app text view it navigates to the about app page where user can find the detail description about the app.
- If we click on order history text view it navigates to the order history page where user can see the list of events he added into his cart.
- User can request an event in this acrivity.

### User Home Page:

![user_home](https://github.com/vineetha1996/event-expo/blob/master/screens/userHome.JPG)

- In the List of Events activity user can see the events available on that day.

### User profile page:
![User Profile](https://github.com/vineetha1996/event-expo/blob/master/screens/profile.JPG)

- User can maintain his profile by modifying and updating the fields it directly reflects in the database.

### About App Page:
![About App](https://github.com/vineetha1996/event-expo/blob/master/screens/about_app.JPG)

- This page describes about our application.

### Order History Page:
![Order History](https://github.com/vineetha1996/event-expo/blob/master/screens/orderHistory.JPG)

- User can see his order history in this page.

### Request Events Page:
![UserRequest](https://github.com/vineetha1996/event-expo/blob/master/screens/userRequest.JPG)

- Through this page user can request admin to host his/her personal event within our app by providing details.

### Individual Events
![IndividualEvents](https://github.com/vineetha1996/event-expo/blob/master/screens/individualEvent.JPG)

- User can see the complete details of the event, add the quantities he is willing and book tickets .

### Payment Page
![Payment](https://github.com/vineetha1996/event-expo/blob/master/screens/payment.JPG)

- User can complete the payment using his card details.
- After the filling the details user will be redirected to the order history page.

### Reset Password Page:
![Reset Password](https://github.com/vineetha1996/event-expo/blob/master/screens/reset_pswd..JPG)

- In this page user can reset his password by giving the unique username and different password.

### Signup page:
![Signup page](https://github.com/vineetha1996/event-expo/blob/master/screens/signUp.JPG)

- If the user is new to the app he should signup first by giving the details which have asked.

### Admin Login Screen:
![AdminLogin Screen](https://github.com/vineetha1996/event-expo/blob/master/screens/admin_login.png)

- Admin should enter username and password to get login.
- When we click on the Login button it navigates to the Admin Home page.

- Admin Credentials:  Id - bhanu
                      Pas - 123456

### Admin Home page:
![Admin Home](https://github.com/vineetha1996/event-expo/blob/master/screens/adminHome.JPG)

- Admin home page where admin can add, delete the events and maintain user details.
- When we click on the Event Management button it navigates to Maintain Event page where we have event details like name, date, time, category and description.
- When we click on the User Registration it navigates to the Registered events data where we can find user registered events data.
- When we click on the Logout button it navigates to the main login page.

### Add events with pre-filled category
![AdminPrefilled](https://github.com/vineetha1996/event-expo/blob/master/screens/imageAdd.JPG)

- On clicking the image button in the admin home page, it redirects to add event page with pre-filled category name.

### Maintain Event Page:

![Maintain Event](https://github.com/vineetha1996/event-expo/blob/master/screens/maintainEvents.JPG)

- Where admin can maintain all the events and their data.

### Requested Events Page:

![Requested Events](https://github.com/vineetha1996/event-expo/blob/master/screens/requestEvents.JPG)

- Where admin can view the events data requested by individual user.

### Add event page:

![User Registration](https://github.com/vineetha1996/event-expo/blob/master/screens/add_event.png)

- Details are added to the database by Admin.


