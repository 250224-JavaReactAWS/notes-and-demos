# Rest

REST, or REpresentational State Transfer, is an architectural style for providing standards between computer systems on the web, making it easier for systems to communicate with each other. REST-compliant systems, often called RESTful systems, are characterized by how they are stateless and separate the concerns of client and server. 

The key abstraction of information in REST is a resource. 

Any information that can be named can be a resource: a document or image, a temporal service, a collection of other resources, a non-virtual object (e.g. a person), and so on. 

REST uses a resource identifier to identify the particular resource involved in an interaction between components.

<img src = "https://3.bp.blogspot.com/-hePTSHDMocA/Wy0LgvaeOmI/AAAAAAAACh8/4dLaq8Bw1jw4iLNTX_k3fhliYsGdA49GQCLcBGAs/s1600/REST%2BArchitectural%2BConstraints.png">

## Client- Server

The client-server design pattern enforces the separation of concerns, which helps the client and the server components evolve independently.

By separating the user interface concerns (client) from the data storage concerns (server), we improve the portability of the user interface across multiple platforms and improve scalability by simplifying the server components.

While the client and the server evolve, we have to make sure that the interface/contract between the client and the server does not break.

## Stateless

Statelessness mandates that each request from the client to the server must contain all of the information necessary to understand and complete the request.

The server cannot take advantage of any previously stored context information on the server.

For this reason, the client application must entirely keep the session state.

## Cacheable

The cacheable constraint requires that a response should implicitly or explicitly label itself as cacheable or non-cacheable.

If the response is cacheable, the client application gets the right to reuse the response data later for equivalent requests and a specified period.

## Uniform Interface

By applying the principle of generality to the components interface, we can simplify the overall system architecture and improve the visibility of interactions.

Multiple architectural constraints help in obtaining a uniform interface and guiding the behavior of components.

The following four constraints can achieve a uniform REST interface:

- Identification of resources
- Manipulation of resources through representations
- Self-descriptive messages
- Hypermedia as the engine of application state

### RESTful services should have uniform resource indentifiers, so here are some rules you can follow to conform to this

-   use nouns to name resources
-   begin your uri the plural collection of a particular resource
-   use path parameters to identify a single resource in a specific document/record
-   capitalize on path structure to represent heirarchy
-   Identify stores of resources that are managed by the client (sub-collections)
-   use query parameters to filter resources of a particular type
-   be consistant accross the board

### Hypermedia

Hypertext (or hypermedia) means the simultaneous presentation of information and controls such that the information becomes the affordance through which the user (or automaton) obtains choices and selects actions.

## Layered System

The layered system style allows an architecture to be composed of hierarchical layers by constraining component behavior.

For example, in a layered system, each component cannot see beyond the immediate layer they are interacting with.

## Code On Demand(Optional)

REST also allows client functionality to extend by downloading and executing code in the form of applets or scripts.

The downloaded code simplifies clients by reducing the number of features required to be pre-implemented. Servers can provide part of features delivered to the client in the form of code, and the client only needs to execute the code.

### More Information Here 

- [What is Rest](https://medium.com/extend/what-is-rest-a-simple-explanation-for-beginners-part-1-introduction-b4a072f8740f)
- [Rest Constraints](https://medium.com/extend/what-is-rest-a-simple-explanation-for-beginners-part-2-rest-constraints-129a4b69a582)
- [HATEOAS (Hypermedia as the Engine of Application State)](https://en.wikipedia.org/wiki/HATEOAS#:~:text=Hypermedia%20as%20the%20Engine%20of,provide%20information%20dynamically%20through%20hypermedia.)

# Rest API

## What is an API?

API is the acronym for Application Programming Interface, which is a software intermediary that allows two applications to talk to each other.

An API is a messenger that abides by a contract.  The contract states:

“Give me this information formatted in a particular way, and I will give you a response.”

An API is like a “waiter” between client (guest) and server (kitchen)

## What is a REST API?

- Architectural style for designing networked applications

- Relies on stateless, client/server protocol -- almost always HTTP

- Treats Server objects as resources that can be created or destroyed

    - Think CRUD!

    - HTTP Verbs

A RESTful API is an interface that allows two applications to communicate with each other over the internet and through various devices. Every time you access an app like Facebook or check the weather on your smartphone, an API is used.

### Review - HTTP Methods

- GET
    - Retrieve data from a specified resource
    - https://site.com/api/users OR https://site.com/api/users/1

- POST
    -  Submit data to be processed to a specified resource
    -  https://site.com/api/users (add)

- PUT
    - Update a specified resource
    - https://site.com/api/users/1

- DELETE
    - Delete a specified resource
    - https://site.com/api/users/1

#### Endpoints
The URL/URI where the api/service can be accessed by a client application

## Richardson Maturity Model
Leonard Richardson analyzed a hundred different web service designs and divided these designs into four categories. These categories are based on how much the web services are REST compliant.

<img src = "https://martinfowler.com/articles/images/richardsonMaturityModel/overview.png">

More Information [Here](https://martinfowler.com/articles/richardsonMaturityModel.html)