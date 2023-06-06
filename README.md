# Atipera Recruitment Task

Welcome to the Atipera Recruitment Task repository! This project is a coding exercise designed to assess programming skills. The task involves building an API consumer that interacts with the GitHub API to retrieve information about a user's repositories.
## Technologies
- Java 17
- Maven
- Spring Boot 3
- Lombok

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [GettingStarted](#GettingStarted)
- [API Documentation](#API-Documentation)

## Introduction

The Atipera Recruitment Task requires building an API consumer that interacts with the GitHub API to retrieve specific information about a user's repositories. The API consumer should be able to handle various scenarios, such as listing repositories, handling non-existing users.

## Features

The key features of the Atipera Recruitment Task API consumer include:

1. **Listing User Repositories**: Given a username and the header "Accept: application/json," the API consumer should retrieve a list of the user's GitHub repositories that are not forks. The required information in the response includes the repository name, owner login, and for each branch, its name and the last commit SHA.

2. **Handling Non-existing Users**: If a non-existing GitHub user is provided, the API consumer should return a 404 response with a specific format. The response should include the status code and a message explaining why the user does not exist.

## GettingStarted

To get started with the Atipera Recruitment Task, follow these steps:

1. **Clone the repository to your local machine using Git:**

    git clone https://github.com/Luzu4/AtiperaRecruitmentTask.git
    
2. **Change into the project directory:**

    cd AtiperaRecruitmentTask
    
3. **Start the application:**

    mvn spring-boot:run
    
4.  **Open your preferred API testing tool (e.g., Postman or cURL) and make requests to the provided endpoints (see API Documentation for details).**


## API-Documentation

1. **GET /repositories/:username**: Retrieves all non-fork repositories for the specified GitHub user.

Parameters:

    :username (required): The GitHub username of the user.

Headers:

    Accept: application/json (required): The desired response format.

Example Response:

    {
        "name": "AtiperaRecruitmentTask",
        "ownerLogin": "Luzu4",
        "branches": [
            {
                "name": "master",
                "sha": "3b93d729bd8e511b0a7cffdd937739b3b71937a2"
            }
        ]
    },

2. **Error Response: 404 - User Not Found** 

Example response:

    {
    "status": 404,
    "message": "Not Found"
    }
    
3. **Error Response: 406 - Not Acceptable**

Example response:

    {
    "status": 406,
    "message": "Invalid Accept header. Only 'application/json' is allowed."
    }
  
