# spring_string_controller

##### REST endpoint that accepts lists of strings and returns analysis results.

*Template for this project was automatically generated using [Java Project Initializr script](https://github.com/michalakadam/Mantra)*

Example request:
```
{
    "data": [
        [
            "abb",
            "aa",
            "zz"
        ],
        [
            "zz",
            "aa",
            "bba"
        ]
    ]
}
```

Example response:
```
{
    "palindromePresent": true,
    "averageLength": 2.34,
    "concatenated": "abbaazzzzaabba"
}
```

##### How to run this program
1. Clone this repo to the desired location: <br/> ```git clone https://github.com/michalakadam/spring_string_controller.git```
2. Enter directory with the project code: <br/> ```cd spring_string_controller```
3. Compile the project code using Maven build tool: <br/> ```mvn install```
4. Once the project is compiled you can run it: <br/> ```java -jar ./target/spring_string_controller-1.0.jar```
5. Hit localhost:8080/analyze with the example request.

##### Do you have any problems running this program?
##### Do you see any way this project can be improved?
 Please write an email to *adam.michalak.dev@gmail.com*
