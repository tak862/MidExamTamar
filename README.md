FinalExamT - Movie List Android App
FinalExamT is an Android application that displays a list of movies retrieved from a remote API using Retrofit. Movie images are loaded efficiently with Picasso. Users can tap on any movie item to view detailed information on a separate screen (AboutActivity). Additionally, users can swipe movie items to either add them to favorites or delete them from the list, with immediate visual feedback.

Technologies Used
Kotlin

AndroidX RecyclerView

Retrofit 2

Picasso

Material Design Snackbar

ConstraintLayout & LinearLayout

Features
Fetches movie list data dynamically from a REST API.

Displays movie images and details in a RecyclerView.

Opens a detail screen with extended movie information on item click.

Supports swipe gestures to add movies to favorites or delete them.

(Optional) Supports pagination for infinite scrolling of movie list.

Setup Instructions
Clone the repository:

bash
Copy code
git clone https://github.com/tak862/FinalExamT.git
Open the project in Android Studio.

Ensure the app has internet permission in AndroidManifest.xml:

xml
Copy code
<uses-permission android:name="android.permission.INTERNET" />
Verify that all necessary dependencies (Retrofit, Picasso, Material Components) are included in your build.gradle.

Confirm that the API base URL and endpoints are properly configured in your Client and service classes.

Run the app on an emulator or a physical device.

Notes
Image URLs must be valid and accessible over the internet for proper loading.

If images fail to load, double-check internet permissions and URL correctness.

Swipe gestures provide smooth interaction for deleting movies or adding them to favorites, with user feedback via Snackbar.

Author
Tamar — Final Exam Android Project
