# MakeItShort - URL Shortener

MakeItShort is a simple URL shortener API built with Java Spring Boot and MongoDB. It allows users to shorten long URLs into concise and easily shareable links.

## Features

- Shorten URLs: Convert long URLs into short and easy-to-remember links.
- Redirect: Redirect users to the original long URL when they access the shortened link.
- Analytics: Track the number of clicks and other relevant statistics for each shortened link.
- Customizable Short URLs: Customize the short URLs to make them more meaningful and memorable.
- User Authentication: Provide user registration and login functionality to manage shortened links.
- API Integration: Expose APIs for programmatically generating short links and accessing analytics data.

## Technologies Used

- Java: Programming language used for the backend development.
- Spring Boot: Framework for creating Java applications with ease.
- MongoDB: NoSQL database for storing the shortened links and their associated data.
- HTML/CSS: Frontend technologies for creating the user interface.
- RESTful APIs: Communication protocol for interacting with the application programmatically.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed on your machine.
- MongoDB installed and running.
- Any IDE (e.g., IntelliJ IDEA, Eclipse) for Java development.

### Installation

1. Clone the repository:

   ```shell
   git clone https://github.com/casyazmon/makeitshort.git
2. Import the project into your preferred IDE:
3. Configure the MongoDB connection details in application.properties:
4. Build and run the application.

5. Access the application in your browser at `http://localhost:8080`.

## Usage

1. Register a new account or log in to an existing account.

2. On the dashboard, enter a long URL that you want to shorten.

3. Click the "Shorten" button to generate a shortened URL.

4. Copy the shortened URL and share it with others.

5. Users can access the shortened URL, which will redirect them to the original long URL.

6. Visit the analytics section to view the number of clicks and other statistics for each shortened link.

## API Documentation

MakeItShort provides a set of APIs for programmatically generating short links and accessing analytics data. Please refer to the [API documentation](API_DOCUMENTATION.md) for detailed information on how to use the APIs.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request.


## Acknowledgments

- Thanks to the developers and contributors of Spring Boot and MongoDB for their excellent tools and documentation.

