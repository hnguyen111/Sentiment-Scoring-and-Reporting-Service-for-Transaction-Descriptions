# Sentiment Scoring and Reporting Service for Transaction Descriptions

Requirements: Java 17, Spring Boot 3.1.2, MongoDB Compass, Apache ActiveMQ, Gradle, Docker, Postman

A service to process transaction descriptions for sentiment scoring via API calls.
- Transaction data are pushed to a designated topic based on sentiment analysis results.
- Designed to identify and report offensive content, enhancing user experience and safety.
- Exposes a REST endpoint to provide scoring for a single given transaction.


## Usage
The code can be downloaded by cloning the project.
```
git clone https://github.com/hnguyen111/Sentiment-Scoring-and-Reporting-Service-for-Transaction-Descriptions.git
```

Before running the project, edit your API keys on lines 19 and 30 in `src/main/java/com/example/demo/api/SentimentApi.java`.

Docker commands to download the latest MongoDB and ActiveMQ images:
```
docker pull mongo
docker pull webcenter/activemq
```

To run the project:
```
docker run -d -p 27017:27017 mongo
docker run -d -p 61616:61616 -p 8161:8161 webcenter/activemq
./gradlew bootRun
```


## Contributing
To make contributions to the codebase, you can fork this repository first, and clone your forked repository to your local machine. You then can create your own branch and make changes to it. After finishing your work, push your branch to GitHub and open a pull request for review.

You have to add test cases as part of your changes.

## Code Contributor
Hantha Nguyen


## License
[MIT](https://choosealicense.com/licenses/mit/)

