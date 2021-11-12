// package database.model;


// public class Customer extends Account implements PersonalDetails {
//     private String firstName;
//     private String lastName;
//     private String email;
//     private String phoneNumber;
//     private int uAge;
//     private String uCity;

//     public Customer(String username, String firstName, String lastName, String email, String phoneNumber, int uAge, String uCity) {
//         super(username);

//         this.firstName = firstName;
//         this.lastName = lastName;
//         this.email = email;
//         this.phoneNumber = phoneNumber;
//         this.uAge = uAge;
//         this.uCity = uCity;
//     }

//     @Override
//     public String getFirstName() {
//         return firstName;
//     }

//     @Override
//     public String getLastName() {
//         return lastName;
//     }

//     @Override
//     public String getEmail() {
//         return email;
//     }

//     @Override
//     public String getPhoneNumber() {
//         return phoneNumber;
//     }

//     @Override
//     public void setFirstName(String name) {
//         firstName = name;
//     }

//     @Override
//     public void setLastName(String name) {
//         lastName = name;
//     }

//     @Override
//     public void setEmail(String email) {
//         this.email = email;
//     }

//     @Override
//     public void setPhoneNumber(String phone) {
//         phoneNumber = phone;
//     }

//     @Override
//     public void setAge(int age) {uAge = age; }

//     @Override
//     public void setCity(String city) {
//         uCity = city;
//     }


//     @Override
//     public String toString() {
//         return String.format("Customer: %s, Name: %s %s, Email: %s, Phone: %s", username, firstName, lastName, email,
//                 phoneNumber, uAge, uCity);
//     }
// }
