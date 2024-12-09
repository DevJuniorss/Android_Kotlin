package com.example.zooapp.Models

import com.example.zooapp.R

data class Animal (
    val id: Int,
    val name: String,
    val species: String,
    val imageRes: Int,
    val description: String,
    val curiosities: String,
    val isFavorite: Boolean = false
)


    val animalList = listOf(
        Animal(
            id = 1,
            name = "Ant",
            species = "Formicidae",
            imageRes = R.drawable.ant,
            description = "As formigas são insetos sociais conhecidos por sua organização em colônias.",
            curiosities = "As formigas conseguem carregar até 50 vezes o seu peso corporal."
        ),
        Animal(
            id = 2,
            name = "Bear",
            species = "Ursidae",
            imageRes = R.drawable.bear,
            description = "Os ursos são mamíferos de grande porte encontrados em diversos habitats.",
            curiosities = "Os ursos polares têm pelos translúcidos, que parecem brancos devido à luz refletida."
        ),
        Animal(
            id = 3,
            name = "Cat",
            species = "Felis catus",
            imageRes = R.drawable.cat,
            description = "O gato doméstico é conhecido por sua agilidade e independência.",
            curiosities = "Gatos passam cerca de 70% do dia dormindo."
        ),
        Animal(
            id = 4,
            name = "Dog",
            species = "Canis lupus familiaris",
            imageRes = R.drawable.dog,
            description = "O cão é um dos animais mais antigos domesticados pelo homem.",
            curiosities = "Os cães têm um olfato cerca de 40 vezes mais potente que o dos humanos."
        ),
        Animal(
            id = 5,
            name = "Eagle",
            species = "Accipitridae",
            imageRes = R.drawable.eagle,
            description = "As águias são aves de rapina conhecidas por sua visão aguçada.",
            curiosities = "Uma águia pode avistar uma presa a mais de 3 km de distância."
        ),
        Animal(
            id = 6,
            name = "Frog",
            species = "Anura",
            imageRes = R.drawable.frog,
            description = "Os sapos são anfíbios encontrados em quase todos os continentes.",
            curiosities = "Algumas espécies de sapos podem mudar de cor para camuflagem."
        ),
        Animal(
            id = 7,
            name = "Giraffe",
            species = "Giraffa camelopardalis",
            imageRes = R.drawable.giraffe,
            description = "As girafas são os animais terrestres mais altos do mundo.",
            curiosities = "Uma girafa pode medir até 5,5 metros de altura."
        ),
        Animal(
            id = 8,
            name = "Horse",
            species = "Equus ferus caballus",
            imageRes = R.drawable.horse,
            description = "Os cavalos são conhecidos por sua velocidade e relação próxima com os humanos.",
            curiosities = "Os cavalos podem dormir em pé graças a um sistema de bloqueio nas pernas."
        ),
        Animal(
            id = 9,
            name = "Iguana",
            species = "Iguana iguana",
            imageRes = R.drawable.iguana,
            description = "As iguanas são répteis herbívoros encontrados em regiões tropicais.",
            curiosities = "Iguanas podem regenerar a cauda se ela for perdida."
        ),
        Animal(
            id = 10,
            name = "Jaguar",
            species = "Panthera onca",
            imageRes = R.drawable.jaguar,
            description = "O jaguar é o maior felino das Américas.",
            curiosities = "Os jaguares possuem uma mordida poderosa capaz de quebrar ossos."
        ),
        Animal(
            id = 11,
            name = "Kangaroo",
            species = "Macropodidae",
            imageRes = R.drawable.kangaroo,
            description = "Os cangurus são marsupiais nativos da Austrália.",
            curiosities = "Cangurus podem saltar até 9 metros em um único salto."
        ),
        Animal(
            id = 12,
            name = "Lion",
            species = "Panthera leo",
            imageRes = R.drawable.lion,
            description = "O leão é conhecido como o rei da selva.",
            curiosities = "Leões podem dormir até 20 horas por dia."
        ),
        Animal(
            id = 13,
            name = "Monkey",
            species = "Cercopithecoidea",
            imageRes = R.drawable.monkey,
            description = "Os macacos são primatas inteligentes e sociais.",
            curiosities = "Macacos utilizam ferramentas para obter alimentos."
        ),
        Animal(
            id = 14,
            name = "Narwhal",
            species = "Monodon monoceros",
            imageRes = R.drawable.narwhal,
            description = "O narval é conhecido como o unicórnio do mar devido à sua longa presa.",
            curiosities = "A presa do narval pode crescer até 3 metros de comprimento."
        ),
        Animal(
            id = 15,
            name = "Owl",
            species = "Strigiformes",
            imageRes = R.drawable.owl,
            description = "As corujas são aves noturnas com excelente visão e audição.",
            curiosities = "Corujas podem girar a cabeça até 270 graus."
        ),
        Animal(
            id = 16,
            name = "Penguin",
            species = "Spheniscidae",
            imageRes = R.drawable.penguin,
            description = "Os pinguins são aves aquáticas que não voam.",
            curiosities = "Pinguins podem nadar a velocidades de até 25 km/h."
        ),
        Animal(
            id = 17,
            name = "Quail",
            species = "Coturnix",
            imageRes = R.drawable.quail,
            description = "As codornas são aves pequenas e velozes.",
            curiosities = "Codornas têm um canto característico usado para comunicação."
        ),
        Animal(
            id = 18,
            name = "Rabbit",
            species = "Oryctolagus cuniculus",
            imageRes = R.drawable.rabbit,
            description = "Os coelhos são conhecidos por sua reprodução rápida.",
            curiosities = "Os dentes dos coelhos nunca param de crescer."
        ),
        Animal(
            id = 19,
            name = "Snake",
            species = "Serpentes",
            imageRes = R.drawable.snake,
            description = "As cobras são répteis sem pernas encontradas em todo o mundo.",
            curiosities = "Algumas cobras podem ingerir presas maiores do que a própria cabeça."
        ),
        Animal(
            id = 20,
            name = "Tiger",
            species = "Panthera tigris",
            imageRes = R.drawable.tiger,
            description = "Os tigres são os maiores felinos do mundo.",
            curiosities = "Cada tigre tem um padrão único de listras."
        ),
        Animal(
            id = 21,
            name = "Umbrella Bird",
            species = "Cephalopterus",
            imageRes = R.drawable.umbrella_bird,
            description = "O pássaro-umbrelha é conhecido por sua crista em forma de guarda-chuva.",
            curiosities = "A crista do pássaro-umbrelha é usada para exibição durante o acasalamento."
        ),
        Animal(
            id = 22,
            name = "Vulture",
            species = "Cathartidae",
            imageRes = R.drawable.vulture,
            description = "Os abutres são aves necrófagas encontradas em diversos habitats.",
            curiosities = "Abutres possuem ácido estomacal extremamente forte para digerir carne em decomposição."
        ),
        Animal(
            id = 23,
            name = "Wolf",
            species = "Canis lupus",
            imageRes = R.drawable.wolf,
            description = "Os lobos são predadores sociais que vivem em alcateias.",
            curiosities = "Os lobos comunicam-se por meio de uivos, expressões faciais e posturas corporais."
        ),
        Animal(
            id = 24,
            name = "Xerus",
            species = "Xerus erythropus",
            imageRes = R.drawable.xerus,
            description = "Os xerus são esquilos terrestres encontrados na África.",
            curiosities = "Xerus vivem em tocas comunitárias para proteção contra predadores."
        ),
        Animal(
            id = 25,
            name = "Yak",
            species = "Bos grunniens",
            imageRes = R.drawable.yak,
            description = "Os yaks são bovinos adaptados a altitudes elevadas.",
            curiosities = "Yak selvagens podem suportar temperaturas de até -40°C."
        ),
        Animal(
            id = 26,
            name = "Zebra",
            species = "Equus zebra",
            imageRes = R.drawable.zebra,
            description = "As zebras são equídeos conhecidos por suas listras únicas.",
            curiosities = "As listras das zebras ajudam a confundir predadores."
        )
    )