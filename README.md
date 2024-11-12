Android Clean Architecture MVVM Sample App
This Android project is a sample app showcasing the use of MVVM architecture with Clean Architecture principles, Coroutines for background operations, Room Database for offline storage, Hilt for dependency injection, and a Caching Strategy to efficiently manage data. This structure ensures maintainability, scalability, and efficient data handling.

Features
MVVM Architecture: Clear separation of UI, business logic, and data layers.
Clean Architecture: Enforces separation between the data, domain, and presentation layers.
Coroutines: For asynchronous operations on background threads.
Room Database: For local persistence and caching.
Caching Strategy: Reduces network calls by caching data locally.
Hilt: Simplifies dependency injection for easy management of dependencies.
Project Structure
The app follows Clean Architecture principles, with separate modules for each layer:

Data Layer: Manages data sources (both local and remote) and repository implementations.
Domain Layer: Defines the use cases and repository interfaces that encapsulate business logic.
Presentation Layer: Contains the UI components and ViewModels.
Tech Stack
Kotlin: Main programming language.
Coroutines: For handling background threads and managing concurrency.
Room Database: For local data caching and offline access.
Retrofit: For network calls to a REST API.
Hilt: For dependency injection.
LiveData / StateFlow: For reactive programming between ViewModels and UI.
ViewModel: Manages UI-related data in a lifecycle-aware way.
RecyclerView: For displaying lists of data.
Caching Strategy
The app uses a caching strategy to enhance performance and minimize network requests:

Local Cache: Room Database stores data locally. If data is available and not outdated, it is loaded from the database.
Network Fetch: If local data is outdated or unavailable, the app fetches data from the network (API), stores it in the Room Database, and updates the UI
