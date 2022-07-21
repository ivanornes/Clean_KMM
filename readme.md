# KMM Clean code case study

This project shows how to share the common core of an iOS and Android project using Kotlin Multiplatform Mobile.

The use cases are incrementing and decrementing a number.

In the shared core you can find:
- Entities: Number.
- Use cases: Increment and decrement interactors.
- Presenters: Adapts the model to what the UI should display.

The `MainActivity.kt` and `NumberFactory.swift` act as composition roots, where the dependencies are instantiated and 
composed. 
The side effects of storing in memory and displaying the updated number are handled by decorators.

Any comments are welcome.
