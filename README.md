randomuser.me client
--------------------

A small android client for the randomuser.me API.

You can find a short video of the app [here](https://goo.gl/hHVYr8).

The app loads some users from the API and shows their name and photo in a list. If there is an error (start the app
in airplane mode to try it) the user is shown a message and a button so that they can try again.

When a user is selected from the list:
 - in portrait mode, another screen with their details is presented
 - in landscape mode, their details are shown in a fragment next to the list

Notes
-----

It might be easier to review the project by starting with the classes in the .ui package and then moving to
.services and .api. Finally the .base package includes the base classes that form the backbone of the project.

A good place to start might be the .ui.users.list package and the UserListFragment, UserListPresenter classes.

Architecture wise, presenters are used to extract the logic from fragments and activities and unit test it
using JUnit. Test coverage is provided for the presenters and service and the tests attempt to focus on testing
behaviour than wiring. As a next step we could get extra coverage for the activities, fragments and recycler 
view adapter by adding UI tests.

To run the tests use ./gradlew testDebug
