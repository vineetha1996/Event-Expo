# Project Name: Event-Expo.

## Team Members:
1. Vineetha Yenugula.
2. Annie Samarpitha Chandolu.
3. Alekhya Jaddu.
4. Bhanuprakash Thota.

## Description:
EventExpo app allows users to reserve tickets for all kinds of events which include sports, harvesting, kayaking, painting, and many more. EventExpo allows users to host events. The major advantage of using the EventExpo app is to handle all the events together at one place where users can switch to different pages inside the app rather than opening a different app for each type of event resulting(results in) good user experience by using EventExpo App. Sign-Up the EventExpo and let the events add wings to your daily life.

## Admin credentials
- Username: bhanu
- Password: 123456

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

### User Home Page:

![user_home](https://github.com/vineetha1996/event-expo/blob/master/screens/userHome.JPG)

- In the Home page user can see the list of events.

### User profile page:
![User Profile](https://github.com/vineetha1996/event-expo/blob/master/screens/profile.JPG)

- User can maintain his profile by updating the required fields.

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

- User can see tha complete details of the event and book tickets.

### Payment Page
![Payment](https://github.com/vineetha1996/event-expo/blob/master/screens/payment.JPG)

- User can complete the payment using his card details.
- After the finishing the payment user will be redirected to the order history page.

### Reset Password Page:
![Reset Password](https://github.com/vineetha1996/event-expo/blob/master/screens/reset_pswd..JPG)

- In this page user can reset his password by giving the email address and new password and then click on the update button.

### Signup page:
![Signup page](https://github.com/vineetha1996/event-expo/blob/master/screens/signUp.JPG)

- If a new user wants to register, he/she will have to sign up first.
- By filing all the fields, if not, we have provided warning messages which as to fill in all filed, one can sign up into the application.
- If the user did not enter an email in the email field, it will give a warming message.
- If the user did not give a number in the phone number field, it will give a warming message.
- Similarly, multiple warming messages will appear if the user has not registered properly. This is done to prevent the application from crashing.
- The user details will then be stored in the database and will be redirected to the login page to sign in.


### Admin Login Screen:
![AdminLogin Screen](https://github.com/vineetha1996/event-expo/blob/master/screens/admin_login.png)

- Admin should enter username and passwotd to login as a admin.
- When we click on the Login button it navigates to the Admin Home page.
- The credentials have to match with the ones stored in the database, then only will they get access inside.
- For wrong or empty fields, we have provided messages which pop-up as warnings.

### Admin Home page:
![Admin Home](https://github.com/vineetha1996/event-expo/blob/master/screens/adminHome.JPG)

- Admin home page where admin can add, delete the events and maintain user details.
- When we click on the Event Management button it navigates to Maintain Event page where we have event details like name, date, time, category and description.
- When we click on the User Registration it navigates to the Registered events data where we can find user registered events data.
- When we click on the Logout button it navigates to the main login page.

### Add events with pre-filled category
![AdminPrefilled](https://github.com/vineetha1996/event-expo/blob/master/screens/imageAdd.JPG)

- When the admin clicks on the buttons under the images in the admin home page, it redirects to this page.
- Here, there are pre-filled fields in the type section.
- This is like a quick add event option.
- The admin can edit the type if they need but this is a faster method with pre-filled fields.
- Once, the event details are added, on click, the event gets strored in the database and will reflect in the manage events page and events list page in the user side.
- Then it will redirect to the admin home page.

### Maintain Events Page:

![Maintain Event](https://github.com/vineetha1996/event-expo/blob/master/screens/maintainEvents.JPG)

- This is where the admin can view all the events that have been hosted on the application so far.
- On clicking on individual event, it will redirect to the Add event page which acts as an edit page.
- One can change or modify the exsisting event details when desired.
- Once, the details are edited and the admin clicks on the add button, it redirects to the Maintain events page, where he/she can see the changes made.
- It reflects the changes in the Maintain events page and also changes the data in the database.
- This page returns back to the admin home page.

### Requested Events Page:

![Requested Events](https://github.com/vineetha1996/event-expo/blob/master/screens/requestEvents.JPG)

- This is the page where the admin can view all the requested events by the users.
- Once, he/she reads these event requests, they can host the events by adding the details provided by the user to the database.
- So, this page is a view only page.
- The admin has to go to the Add event page to host/create these requests.
- The admin can go back to the admin home page to create the requested events.

### Add event page:

![User Registration](https://github.com/vineetha1996/event-expo/blob/master/screens/add_event.png)

- The Admin can add new events by filling in the details in the input fields provided.
- The name, time, price, date and details of the event have to specified which will then be added to the database when clicked on the 'Add' button.
- The new event will then be displayed in the user side events list page, displayed below the previous events.
- We have given the maximum and minimum tickets sold in the database. 1-20 tickets can only be sold. 
- Once the admin has added the new event details, the screen will redirecte to the admin home page.


