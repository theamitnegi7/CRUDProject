# CRUDProject
A simple CRUD application built with Spring Boot. This project demonstrates basic operations like Create, Read, Update, and Delete using RESTful APIs and a relational database. Ideal for learning how to implement CRUD functionality in Spring Boot with a clean and maintainable codebase.


**Note:** You must have Java JDK, Tomcat, MySQL, and Spring Tool Suite (or any code editor) installed to run this project.

## Fork the Repository

1. Fork this GitHub repo and clone it to your local system.
2. Use the command to clone the repository:  
   `git clone https://github.com/<username>/CRUDProject.git`

## Installing Docker

1. Install Docker on your system.
2. Open Docker CLI and run the following command to pull the latest MySQL image:  
   `docker pull mysql:latest`
3. Run the Docker container with this command:  
   `docker run -p 3306:3306 --name mysql-container -e MYSQL_ROOT_PASSWORD=12345678 -d mysql:latest`
5. To verify the container is running, use:  
   `docker ps`  
   You should see your `mysql-container` in the list.  
   **Note:** This will use port `3306`, the same as MySQL, so stop your local MySQL server first if it's running.
6. Log in to the Docker MySQL container with:  
   `docker exec -it mysql-container mysql -u root -p`
7. Create a database named `Students` by running:  
   `CREATE DATABASE Students;`
8. Exit the MySQL container.

## Running the Project

1. Open the project in your preferred code editor (Spring Tool Suite is recommended).
2. Run the project as a Spring Boot application.
3. Open your browser and install the [Tabbed Postman extension](https://chromewebstore.google.com/detail/tabbed-postman-rest-clien/coohjcphdfgbiolnekdpbcijmhambjff).
4. Open the extension and test the API by entering the URL:  
   `http://localhost:8080/trial`  
   You should see a message saying `"success its working"`. If this doesn't appear, check if the Spring Boot API and database are running properly.

**Note:** Select the `POST` method for all the operations in Tabbed Postman for the below-mentioned operations.

## To Save Student Data

1. To add student data, enter the following URL:  
   `http://localhost:8080/saveStudent`
2. Select **Raw** from the options below the URL and change the type to **JSON**.
3. Enter the student details in JSON format, like:

   ```json
   {
     "name": "John Doe",
     "course": "Computer Science",
     "specialisation": "Artificial Intelligence"
   }
   ```

4. In the **Headers** tab, add `"Content-Type"` as the key and `"application/json"` as the value.
5. Click **Send**. You should receive a response with a success message.

## To View Student Data

1. To view student data, enter the following URL:  
   `http://localhost:8080/viewStudent`
2. Click **Send**, and you will see the student data.

## To Update Student Data

1. To update student data, enter the following URL:  
   `http://localhost:8080/updateStudent`
2. Select **Raw** from the options below the URL and change the type to **JSON**.
3. Enter the student details in JSON format, including the `studentId` to update:

   ```json
   {
     "studentId": "1",
     "name": "John Doe",
     "course": "Computer Science",
     "specialisation": "Artificial Intelligence"
   }
   ```

4. In the **Headers** tab, add `"Content-Type"` as the key and `"application/json"` as the value.
5. Click **Send**. You should receive a response confirming the update.

## To Delete Student Data

1. To delete student data, enter the following URL:  
   `http://localhost:8080/deleteStudent`
2. Select **Raw** from the options below the URL and change the type to **JSON**.
3. Enter the `studentId` of the student you want to delete in JSON format:

   ```json
   {
     "studentId": "1"
   }
   ```

4. In the **Headers** tab, add `"Content-Type"` as the key and `"application/json"` as the value.
5. Click **Send**. You should receive a response confirming the deletion.

