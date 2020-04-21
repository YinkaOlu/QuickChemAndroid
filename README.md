# Quick Chem Android App

Simple Android application that uses chemistry data from an Open chemistry API (https://github.com/YinkaOlu/QuickChemAPI). 
The purpose of this application is to practice consumption of an RESTful api and using basic MVVM architecture.

## How to run

1. Install Android Studio (https://developer.android.com/studio)
2. Clone this project
  > Through Github page or through commandline (git clone https://github.com/YinkaOlu/Quick_Chem_Android.git)
3. Open Project in Android studio
4. Sync Gradle and Run application

## App Structure
### Data Layer
The Data layer of this application holds the models and the repository to access to data.
#### Models
The models represents the data that is retrieved and used through the app. 
In this case, the *Element* class is a model of the raw information retreived from the API JSON response.
#### Repository
For a clear separation of responsibilities, having various parts of the application trying to get the data from the source (API) directly is not good practice.
To prevdent this, the repository acts as a single point of access to interact with data layer. The repository manages where the data comes from and where it's stored.


### Business Logic / View Model Layer
The View Model layer acts as the intermediate between the Data and the UI layer. 
This layer determines what to do with user interaction and how to handle flow of data.
In this simple application, ViewModel determines which data source to use (ElementRepository), how to process the data (make a periodic table) and passes display information to UI layer.

### UI / View layer
This layer determines how data should be presented to user as well as passes potential user inputs to business logic layer to react to. In this applciation, View layer is responsible for presenting the list of elements in a scolliing list and presenting Element data in Element list items.
