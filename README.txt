Hello and welcome to the Readme of Jaime's project.

You may be wondering how we ended up at this situation, let me walk you through.

1.-Reasons and thoughts behind all the choices made:

Due to the nature of the user requests, it seemed obvious to me that the simplest way to satisfy all the
demands would be to use a database.
So I decided the easiest way to do it would be to use a H2 database.
After that, I googled "java and react application", since my experience with React was with Node.js
This is where the fun began! In short, it seems you need Spring, and Intellij only helps you with that if you pay, which I do not...
So I left it for future Jaime.

While creating the code to add all the elements on the products.xlsx I got bored, and my brain decided it would be
much better for my finger joints to change the xlsx file to a csv and make a CSV Reader to use on both the
categories and products files! Brains!

So I went that way, I created 2 methods to extract the data and insert it in 2 tables, one for products and one for categories.

It all went smoothly, except that I had never done that before, so it took some digging and a bit of cursing.
After that since it is supposed to be RestFul calls I decided to create SQL commands methods that will be
easy to call to use them later on the GET/POST requests.

So I created in the Commands.java class all the commands requested by the users:
    -Show all products
    -Delete a product
    -Update a product
    -Sort by name
    -Add a new product
    -Filter by category

Lastly, after making sure the commands worked as intended, Jaime from the future had to tackle the frontend again.
Which I tried to understand how Spark worked with Java......and kinda failed, so I have created the UI.class,
where it shows and executes the commands depending on the routes, but I didn't have time to make a functional FE.

2.-Things I would like to improve

Well, the most obvious one would be to keep on fighting and crying till I can make at least a list show properly.
Other option would be to say screw it to Java and adapt the all the backend to a system I have with Node.js, React and Mongo.

I would have loved to add some testing to the Commands and the databaseInitializer just cos I spent a few hours
fighting with them to make the SQL commands work as intended so I could have something to proof my struggle.

And finally if my laptop was not as bad as it is, I would have downloaded Eclipse and go with Spring Boot and React.
But I only could work on it 2 evenings due to personal reasons, sorry I couldn't do more.
I hope you enjoy the small project and the README.txt.
