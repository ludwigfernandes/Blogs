# Blog Reader App

This is a Android application that allows users to view and read blog posts from an API. It follows the **MVVM architecture** and is built using **Jetpack Compose** for the UI. Users can view a list of blogs and read individual blog content through the app.

## Features

- **List of Blogs**: Displays a list of blog posts retrieved from the [Vrid Blog API](https://blog.vrid.in/wp-json/wp/v2/posts?per_page=10&page=1).
- **Blog Details**: Users can click on a blog post to read its content using **WebView**.
- **Smooth Navigation**: Easy and seamless navigation between the list of blogs and blog details.
- [IN PROGRESS]**Offline Handling**: Manages offline scenarios to ensure the app remains functional even without an internet connection.
- **Efficient Data Loading**: 
  - **Shimmer Effect**: A shimmer effect is used while images load, enhancing the user experience.
  - **Loading Animation**: A Lottie animation is displayed until the blog post is fully loaded.

## Tech Stack

- **Kotlin**: The app is entirely developed in Kotlin.
- **Jetpack Compose**: UI is built using Jetpack Compose, providing a modern and reactive UI framework.
- **MVVM Architecture**: Follows the Model-View-ViewModel architecture pattern to separate concerns and create a clean, maintainable codebase.
- **Coil**: For efficient image loading with support for the shimmer effect.
- **Apache HTML Entities Cleaner**: To sanitize and clean HTML content from the API responses.
- **ViewModel**: For managing UI-related data in a lifecycle-conscious way.
- **Java DateTime Formatter**: Used to format dates in a readable and user-friendly way.


## API

The app fetches blog data from the following API:
- **URL**: [https://blog.vrid.in/wp-json/wp/v2/posts?per_page=10&page=1](https://blog.vrid.in/wp-json/wp/v2/posts?per_page=10&page=1)
- **Method**: GET
- **Response**: JSON containing blog post details (title, content, images, etc.)
