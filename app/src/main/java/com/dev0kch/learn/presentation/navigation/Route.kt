package com.dev0kch.learn.presentation.navigation


sealed class Route(val route: String) {

    object HomeScreen : Route(route = "HomeScreen")
    object DetailsScreen : Route(route = "DetailsScreen")


}
