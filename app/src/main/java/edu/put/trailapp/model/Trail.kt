package edu.put.trailapp.model

data class Trail(
    val name: String,
    val description: String,
    val stages: List<String>
) {
    companion object {
        fun getSampleTrails(): List<Trail> {
            return listOf(
                Trail(
                    name = "Szlak Górski 1",
                    description = "Opis szlaku górskiego 1...",
                    stages = listOf("asdfhdsflakj", "etap 2", "etap 3")
                ),
                Trail(
                    name = "Szlak Górski 2",
                    description = "Opis szlaku górskiego 2...",
                    stages = listOf("etap 1", "dsaljkjlkads", "etap 3")
                ),
                Trail(
                    name = "GR 20",
                    description = "Najbardziej znany długodystansowy szlak trekkingowy na Korsyce, prowadzący przez góry od północy na południe wyspy.",
                    stages = listOf("etap 1", "etap 2", "etap 3")
                ),
                Trail(
                    name = "Mare a Mare Nord",
                    description = "Szlak 'Morze do Morza Północ', który przechodzi przez różnorodne krajobrazy środkowej Korsyki.",
                    stages = listOf("etap 1", "etap 2", "etap 3")
                ),
                Trail(
                    name = "Mare a Mare Sud",
                    description = "Południowa wersja szlaku 'Morze do Morza', łącząca wschodnią i zachodnią część Korsyki przez jej południowe regiony.",
                    stages = listOf("etap 1", "etap 2", "etap 3")
                ),
                Trail(
                    name = "Sentier du Douanier",
                    description = "Przepiękny przybrzeżny szlak na północy Korsyki, oferujący widoki na Morze Śródziemne i skaliste wybrzeża.",
                    stages = listOf("etap 1", "etap 2", "etap 3")
                ),
                Trail(
                    name = "Tra Mare e Monti",
                    description = "Szlak 'Między morzem a górami' prowadzący przez malownicze wsie i zapierające dech w piersiach krajobrazy między Calvi a Piana.",
                    stages = listOf("etap 1", "etap 2", "etap 3")
                )
            )
        }
    }
}

