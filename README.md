# PROG-03 #
This is a team assignment. You can divide the work among team members, but the goal is for everyone to gain experience with Android UI implementation. So you should make sure that all team members review and understand the code written by other members. This project is based on the exercise tracker you developed in PROG 02. You can use the Figma prototype of any of the team members as the starting point, or start from scratch.

## Android UI Requirements ##
The UI should include the same elements from PROG 02:

## MAIN VIEW: MOBILE ##
A user opens the Exercise Tracker app (you are free to rename this app if you choose). A home screen is shown welcoming the user and showing a summary of recent activities, and the option of starting recording of a new activity. The home screen should show:

* A panel showing estimated calories burned in the past week.
* A panel showing minutes of exercise in the past week.
* A panel showing a summary of up to three recent exercise activities.
* A button to start recording a new exercise activity, leading to the menu below.
* A button to allow entering body details: weight, height, age.

## EXERCISE MENU ##
Clicking the "start recording" button on the main screen should open a menu of exercises including running, biking, rowing, free weights, and stair climbing.

## RUNNING ACTIVITY PAGE ##
If the user selects "Running" in the menu, a new screen should appear that allows recording of running. At the top of the screen there should be a "record" button whose state clearly shows whether the recording is happening or not.

When recording is happening, the display should shows a live display of:

* Steps
* Distance traveled
* Estimate calories burned for this activity
* A map showing the user's path.

## BODY DETAILS PAGE ##
Design the page that allows entry of body details such as weight, height, age....

 

This assignment uses T-shaped design. That is, all of the above pages are accessible by the user, but not all of their functionality is available. For instance, you can pre-define a path for the user's run, and render it on a map - or you can use your device's GPS if it has one to capture a path. That's up to you but remember using GPS/path capture is not part of the spec and will not be graded. However, the map and the path on it should be rendered using the Google maps API for Android.

## Using Google Maps ##
To use google maps in your application, download and install the Maps API for Android (Links to an external site.). You can use the Google cloud credits and instructions that will be emailed to you,

## Submission ##
You should submit the following items. First a pdf file containing the following:

* Short overview of your app (paragraph).
* Screenshots from your web app showing main page, and the steps to record and review an activity.
* A screenshot of the body details page.
* Two sample scenarios (text only) of how the app can be used.