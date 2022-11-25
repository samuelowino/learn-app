# Learn
Learn mobile platform for cross discipline education content. Study math, physics, biology, chemistry and other disciplines in one app.

# Features
- Text based education content, curated by subject, topic and chapter
- Curated tests and trivia
- Previous standardized tests and exams
- Simulation
- Video lectures

# Technologies
- Java
- Kotlin
- Android
- Spring Boot
- Retrofit
- HTML 5
- YouTube API
- OpenGL ES

# Technical Specification (How it works)
 > The system will comprise a **web portal** for managing and generating educational content. The content entered on the 
 > web portal will be converted to **HTML 5** content that can later
> be store on the server f**ile system or database**. The HTML 5 content will be downloaded by the mobile platforms and rendered in a **web view**. 
 > The web content can be updated and changed therefore the server will
 > maintain a **version for all content** generated so that the app can download new or updated content and still manage to provide most of the content
 > offline.
 
> The web portal will also provide a section for generating a Q/A or trivial question as well as exam content that can be dynamically loaded to the mobile app.

> The platform will issue certificates, leaderboards and badges as part of gamification.

# Architecture
## Server
- Provide APIs for registration, and user management
- Provide a web portal for content generation and management

## Mobile Apps
- Support registration
- Support subscriptions and subscription managemnt
- Support rendering content 
- Support Q/As, Exams, Practice Tests and trivia
- Support video lectures

## Libraries used
- j2html

## Data Definition

| Model     | Fields                                                 | Description                                            |
|-----------|--------------------------------------------------------|--------------------------------------------------------|
| Subject   | **ID**,**Name**                                        | Defines a subject such as physics, bilogy or chemistry |
| Topic     | **ID**,**Name**,**Subject**                            | The topic under a particular subject                   |
| Section   | **ID, Topic, Name, [paragraphs],coverImageUrl, index** | The section under this topic                           |
| Paragraph | **ID, content, coverImageUrl, index**                  | The parapgraph under a section                         |



## Copyright and License
The code and the platform is available under Apache 2.0 license.
 


