package com.example.nighteventapp.models

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.nighteventapp.R

data class Event(
    val id: Int,
    val title: String,
    val description: String,
    val date: String,
    val location: String,
    val isFavorite: MutableState<Boolean> = mutableStateOf(false),
    val isSubscribed: MutableState<Boolean> = mutableStateOf(false),
    val imageRes: Int
)
val events = listOf(
    Event(
        id = 1,
        title = "Evento de Artes",
        description = "Explore o universo das artes e tendências contemporâneas.",
        date = "2025-01-15",
        location = "Paris",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.art_event
    ),
    Event(
        id = 2,
        title = "Evento de Astronomia",
        description = "Descubra os segredos do céu noturno e a beleza do cosmos.",
        date = "2025-01-20",
        location = "Sitio Amanaju - Senador Pompeu, CE",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.astro_event
    ),
    Event(
        id = 3,
        title = "Evento Jurídico",
        description = "Discussões sobre as tendências e inovações no campo jurídico.",
        date = "2025-01-25",
        location = "Centro de Feiras e Eventos - Fortaleza, CE",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.law_event
    ),
    Event(
        id = 4,
        title = "Evento de Gastronomia",
        description = "Sabores e aromas: uma jornada pela arte da gastronomia.",
        date = "2025-01-30",
        location = "Espirito Santo",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.gastro_event
    ),
    Event(
        id = 5,
        title = "Evento de Música",
        description = "Descubra novas melodias e experimente a música de forma única.",
        date = "2025-01-18",
        location = "Rio de Janeiro",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.music_event
    ),
    Event(
        id = 6,
        title = "Evento de Tecnologia",
        description = "Inovações e tendências que estão moldando o futuro tecnológico.",
        date = "2025-01-22",
        location = "Rio de Janeiro",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.tech_event
    ),
    Event(
        id = 7,
        title = "Evento de Startup",
        description = "Conheça ideias revolucionárias e o espírito do empreendedorismo.",
        date = "2025-01-28",
        location = "India",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.starup_event
    )
)