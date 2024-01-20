# **PokeWixExplorer**
<p align="center">
<img src="/images/screens.png"/>
</p>
<p align="center">  
An app demonstrates modern Android development using Hilt, Coroutines, Jetpack, Room, ViewModel, MVVM - Clean Architecture, Dark and Ligth Theme, Offline support and others.
</p>
</br>

## 💫 **Features**
* Home, Search, Profile.
* Light and Dark theme
* Offline support
* Error handling

<img src="/images/demo.gif" align="right" width="320"/>

## <img src="https://media2.giphy.com/media/QssGEmpkyEOhBCb7e1/giphy.gif?cid=ecf05e47a0n3gi1bfqntqmob8g9aid1oyj2wr3ds3mg700bl&rid=giphy.gif" width ="25"><b> **Stack**</b>

- Minimum SDK level 24
- Kotlin
- Coroutines
- Jetpack
- Room
- Hilt
- Architecture
  - MVVM Architecture + full  Repository Pattern
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit): Construct the REST APIs and paging network data.
- [Gson](https://github.com/google/gson): A modern JSON library for Kotlin and Java.
- [Material-Components](https://github.com/material-components/material-components-android): Material design components for building ripple animation, and CardView.
- [Glide](https://github.com/bumptech/glide): A fast and efficient open source media management and image loading framework for Android that wraps media decoding, memory and disk caching, and resource pooling into a simple and easy to use interface.
- [Firebase](https://firebase.google.com/): An app development platform that helps you build and grow apps and games users love. Backed by Google and trusted by millions of businesses around the world.
- [Admob](https://admob.google.com/home/): Makes earning revenue easy with in-app ads, actionable insights, and powerful, easy-to-use tools that grow your app business.

## 🚀 **Architecture**
**PokeWixExplorer** has three main features home, search, profile.
Each of them is based on the MVVM architecture and the Repository pattern, which follows the [Google's official architecture guidance](https://developer.android.com/topic/architecture).

<p align="center">
<img src="/images/arquitecture_layer.jpg" align="center" width="550"/>
</p>

The overall architecture is composed of five layers; the UI layer, framework layer, use cases layer, domain layer and data layer.
Each layer has dedicated components and they have each different responsibilities, as defined below:

<p align="center">
<img src="/images/arquitecture_pwe.png" align="center" width="550"/>
</p>
