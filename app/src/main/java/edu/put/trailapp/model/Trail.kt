package edu.put.trailapp.model

import edu.put.trailapp.R

data class Trail(
    val name: String,
    val description: String,
    val difficulty: String,
    val stages: List<String>,
    val imageResourceId: Int
) {
    companion object {
        fun getSampleTrails(): List<Trail> {
            return listOf(
                Trail(
                    "Szlak Górski 1",

                    "Lorem ipsum dolor sit amet. Rem nemo dolorum est explicabo porro qui laborum galisum est perspiciatis ratione! Qui ipsam veritatis rem dolore perspiciatis aut voluptatem quisquam ut accusamus vitae. Et harum inventore in odio fugit est omnis voluptatum.\n" + "\n" + "Ut laborum fugiat id tempore expedita est aspernatur repudiandae. Et laudantium nulla sed quia odit et quis iusto aut quibusdam natus At dignissimos dignissimos est natus modi vel dolores doloribus. Cum doloremque accusantium ut iste internos At nemo recusandae a maiores voluptatem qui vero blanditiis At exercitationem placeat.\n" + "\n" + "Non omnis nobis sit eaque quos ad suscipit voluptas vel error dolores ut illum consectetur est repellat quisquam. Et facilis neque est tempore commodi aut numquam quam aut veniam repellendus ea expedita Quis aut maxime tempore. Sed voluptatem aperiam ut fugiat harum quo deserunt maxime qui molestias laboriosam id esse ullam.",
                    "easy",
                    listOf("asdfhdsflakj", "etap 2 też jest"),
                    R.drawable.trail1_image
                ), Trail(
                    "Szlak Górski 2",

                    "Opis szlaku górskiego 2...",
                    "easy",
                    listOf("etap 1", "dsaljkjlkads"),
                    R.drawable.trail2_image
                ), Trail(
                    "GR 20",

                    "Najbardziej znany długodystansowy szlak trekkingowy na Korsyce, prowadzący przez góry od północy na południe wyspy.",
                    "easy",
                    listOf("etap 1", "etap 2", "etap 3"),
                    R.drawable.trail3_image
                ), Trail(
                    "Mare a Mare Nord",

                    "Szlak 'Morze do Morza Północ', który przechodzi przez różnorodne krajobrazy środkowej Korsyki.",
                    "hard",
                    listOf("etap 1", "etap 2", "etap 3"),
                    R.drawable.trail4_image
                ), Trail(
                    "Mare a Mare Sud",

                    "Południowa wersja szlaku 'Morze do Morza', łącząca wschodnią i zachodnią część Korsyki przez jej południowe regiony.",
                    "medium",
                    listOf("etap 1", "etap 2", "etap 3"),
                    R.drawable.trail5_image
                ), Trail(
                    "Sentier du Douanier",

                    "Przepiękny przybrzeżny szlak na północy Korsyki, oferujący widoki na Morze Śródziemne i skaliste wybrzeża.",
                    "easy",
                    listOf("etap 1", "etap 2", "etap 3"),
                    R.drawable.trail1_image
                ), Trail(
                    "Tra Mare e Monti",

                    "Szlak 'Między morzem a górami' prowadzący przez malownicze wsie i zapierające dech w piersiach krajobrazy między Calvi a Piana.",
                    "hard",
                    listOf("etap 1", "etap 2", "etap 3"),
                    R.drawable.trail1_image
                ), Trail(
                    "Sentier du Douanier",

                    "Przepiękny przybrzeżny szlak na północy Korsyki, oferujący widoki na Morze Śródziemne i skaliste wybrzeża.",
                    "easy",
                    listOf("etap 1", "etap 2", "etap 3"),
                    R.drawable.trail1_image
                ), Trail(
                    "Tra Mare e Monti",

                    "hard",
                    "Szlak 'Między morzem a górami' prowadzący przez malownicze wsie i zapierające dech w piersiach krajobrazy między Calvi a Piana.",
                    listOf("etap 1", "etap 2", "etap 3"),
                    R.drawable.trail1_image
                ), Trail(
                    "Sentier du Douanier",

                    "Przepiękny przybrzeżny szlak na północy Korsyki, oferujący widoki na Morze Śródziemne i skaliste wybrzeża.",
                    "easy",
                    listOf("etap 1", "etap 2", "etap 3"),
                    R.drawable.trail1_image
                ), Trail(
                    "Tra Mare e Monti",

                    "Szlak 'Między morzem a górami' prowadzący przez malownicze wsie i zapierające dech w piersiach krajobrazy między Calvi a Piana.",
                    "hard",
                    listOf("etap 1", "etap 2", "etap 3"),
                    R.drawable.trail1_image
                ), Trail(
                    "Sentier du Douanier",

                    "Przepiękny przybrzeżny szlak na północy Korsyki, oferujący widoki na Morze Śródziemne i skaliste wybrzeża.",
                    "easy",
                    listOf("etap 1", "etap 2", "etap 3"),
                    R.drawable.trail1_image
                ), Trail(
                    "Tra Mare e Monti",

                    "Szlak 'Między morzem a górami' prowadzący przez malownicze wsie i zapierające dech w piersiach krajobrazy między Calvi a Piana.",
                    "hard",
                    listOf("etap 1", "etap 2", "etap 3"),
                    R.drawable.trail1_image
                ), Trail(
                    "Sentier du Douanier",

                    "Przepiękny przybrzeżny szlak na północy Korsyki, oferujący widoki na Morze Śródziemne i skaliste wybrzeża.",
                    "easy",
                    listOf("etap 1", "etap 2", "etap 3"),
                    R.drawable.trail1_image
                ), Trail(
                    "Tra Mare e Monti",

                    "Szlak 'Między morzem a górami' prowadzący przez malownicze wsie i zapierające dech w piersiach krajobrazy między Calvi a Piana.",
                    "hard",
                    listOf("etap 1", "etap 2", "etap 3"),
                    R.drawable.trail1_image
                )
            )
        }
    }
}

