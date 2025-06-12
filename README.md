MidExamTamar - Movie List Android App
Description
MidExamTamar is an Android app that displays a list of movies fetched from an API using Retrofit. Movie images are loaded with Picasso. Users can tap on a movie item to view detailed information on a separate screen (AboutActivity). Additionally, items can be swiped to add them to favorites or delete them.

Technologies Used
Kotlin

AndroidX RecyclerView

Retrofit 2

Picasso

Material Design Snackbar

ConstraintLayout & LinearLayout

Features
Fetches movie list data from an API.

Displays movie images and details in a RecyclerView.

Opens detail screen on item click.

Supports swipe gestures to add to favorites or delete movies.

(Optional) Pagination support for infinite scrolling.

Setup Instructions
Clone the repository:

bash
Copy
Edit
git clone https://github.com/yourusername/MidExamTamar.git
Open the project in Android Studio.

Make sure the app has internet permission in AndroidManifest.xml:

xml
Copy
Edit
<uses-permission android:name="android.permission.INTERNET" />
Check your dependencies in build.gradle (Retrofit, Picasso, Material Components).

Confirm API base URLs and endpoints are correctly set up in your Client and service classes.

Run the app on an emulator or device.

Notes
Image URLs must be valid and accessible over the internet.

If images do not load, verify internet permissions and URL correctness.

Swipe functionality allows deleting or adding movies to favorites with visual feedback.

Author
Tamar — MidExam Project
