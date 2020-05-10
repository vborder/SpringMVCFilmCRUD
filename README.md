# SpringMVCFilmCRUD

## Team AwesomeSauce:

* Vince Borden, Back-End and Boss
* Jacob Zieleniewski, Front-End and Debugger of the Year
* Mike Matosky, Middle-End and Gorgeous README creator

## About SpringMVCFilmCRUD
As the name suggests, this is a SpringMVC adaptation of a previous FilmQuery
project from a previous week. It is a deployable web-based interface for a local
database filled with film and actor objects and fields. The implementation also
upgrades the capabilities of the previous assignment by C.R.U.D. functionality
as well as an extra connection to a film's genre category.

## How to Use:
1. **Create**- to create a new film for the database, you must fill in the
required fields on the homepage including *Title*, *Description*, *Release Year*,
*Rental Duration*, *Rental Cost*, *Film Length*, and the *Cost to Replace*. A successful
creation results in a results page with the ability to view the new film's details and
options to delete and edit the fields of this created movie. A FilmId greater than
1000 is a sign of a successful add.
2. **Read**- to see the details of a film or films you can search by Id or keyword
from the homepage. A successful query results in a landing page with the returned
search result including the *Film Actors for each movie* and the newly displayed
*Category* fields.
2. **Update**- the user is capable of changing the adjustable fields and alter
the database entries. I like the term Edit
better, but for some reason we like CRUD better than CRED. Updating entries sounds
like editing to me. To *"update"* an entry, you must search and return it and
edit it from the results page.
3. **Delete**- self-explanatory. You can delete entries after searching from the
homepage and re-inputting the FilmID and selecting delete.


## Notes
- Early testing shows creation and deletion sometimes does not affect new ID creation.
- Displaying Actors for multiple movies was too cluttered in a web browser, so for
keyword searches we opted to not list all of the actors, but an individual movie return
displays the actors in their own separate section below the film details.
- We cannot edit the Actors... yet
- All film entries with IDs less than 1000 are read only by design. They cannot be
edited or deleted.
- To input a new film, you must enter each of the fields. Our front-end genie, Jacob,
designed it that way so we can enjoy seamless film creations in our database.
- Check out that reset on the Edit Film section. Neat, right?

## Hindsight / Lessons / What I Learned / Reflections
- Refactoring is exponentially important when working with a group. Including
making the final code readable and maintainable.
- For best results with git, work on one file at a time to avoid merge conflicts.
- Pair programming was .1 the Pair/Team debugging time.
- The portion of the code we ended up working on enhanced and built new knowledge
in that expertise. I'm writing this README as I'm watching Jacob readjust the jsp's
and thinking to myself, "man, I'm really glad I don't have to do that!"
- Full-Stack describes the knowledge and the ability to muck your way through all
of the tasks unevenly.
- Communication is key. The most work got done as we were all together and alerting
each other to pulls and pushes and looking for solutions.
- There are no more weekends.


# Lessons Learned and Reinforced
+ CRUD operations
+ Incorporating mySQL Queries into a Java Application
+ Local mySQL Database
+ Database Access Objects (DAO's)
+ Controllers
+ Java Server Pages
+ Group Git interactions
+ Java- Interface
+ Web Forms and HTML
+ Web Project structure and functionality


# Technology Used
* Eclipse- Spring Tools Suite
* Gradle
* Git
* Atom
* MAMP
* mySQL
* Google/StackOverflow
