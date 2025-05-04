📱 Android Clean Architecture MVVM Sample App
This Android project is a sample app showcasing modern development practices using MVVM architecture and Clean Architecture principles. It demonstrates how to build scalable, maintainable, and testable apps using Kotlin, Coroutines, Room, Hilt, and a smart caching strategy.

🚀 Features
MVVM Architecture – Clear separation between UI, business logic, and data layers.

Clean Architecture – Divides the app into well-defined layers: data, domain, and presentation.

Coroutines – For performing background operations efficiently.

Room Database – Local persistence for offline support and data caching.

Caching Strategy – Reduces unnecessary network calls by using local data when possible.

Hilt – Simplified dependency injection for better modularity and testability.

🧱 Project Structure
The app follows Clean Architecture with a modularized approach:

Data Layer
Handles data operations, including local (Room) and remote (API) sources. Contains repository implementations.

Domain Layer
Contains business logic, including use cases and repository interfaces.

Presentation Layer
Contains UI logic (ViewModels), state management, and composables/fragments/activities.

🛠️ Tech Stack
Kotlin – Primary programming language.

Coroutines – For background tasks and concurrency.

Room – Local database for caching and offline access.

Retrofit – For networking and REST API integration.

Hilt – Dependency injection framework.

LiveData / StateFlow – For reactive UI updates.

ViewModel – Lifecycle-aware UI logic holder.

RecyclerView – To display lists of data efficiently.

🧠 Caching Strategy
The app uses a local-first strategy for better performance and offline support:

Local Cache (Room)

Loads data from Room if available and fresh.

Network Fetch (Retrofit)

If cache is missing or outdated, fetches fresh data from the network.

Saves the data to Room and updates the UI.
