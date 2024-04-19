package ru.clevertec.nikonov.androidperformance.data.mock

import ru.clevertec.nikonov.androidperformance.data.dto.Product


private val imageUrls = listOf(
    "https://content2.onliner.by/catalog/device/header/5c7022069df5df9ec0ec8f31d93e45c0.jpeg",
    "https://content2.onliner.by/catalog/device/header/bfc483cd0629e9c08e6b25376049664e.jpg",
    "https://content2.onliner.by/catalog/device/header/635d822fdc6081551d67c8c2963d9641.jpeg",
    "https://content2.onliner.by/catalog/device/header/0482d7ad480984e9959c42b41fd0faca.jpg",
    "https://content2.onliner.by/catalog/device/header/0482d7ad480984e9959c42b41fd0faca.jpg",
    "https://content2.onliner.by/catalog/device/header/5b4d031565755192170ac9ba5b6c56bb.jpeg",
    "https://content2.onliner.by/catalog/device/header/730e5b71ccbb947d5eeab6ec1a3cb0cc.jpg",
    "https://content2.onliner.by/catalog/device/header/d30886a5e4b494e9df5b633cbf9fc539.jpg",
    "https://content2.onliner.by/catalog/device/header/7624788a11fda4266b32b0037ac80ac6.jpeg",
    "https://content2.onliner.by/catalog/device/header/55a3207ee96b2612a6f4345b6f789d3d.jpeg",
    "https://content2.onliner.by/catalog/device/header/06c28ba7bfae3db87605f359ea2c9400.jpeg",
    "https://content2.onliner.by/catalog/device/header/730e5b71ccbb947d5eeab6ec1a3cb0cc.jpg",
    "https://content2.onliner.by/catalog/device/header/f27ec3fd2a5a7005e97223693a8eac32.jpeg",
    "https://content2.onliner.by/catalog/device/header/5c7022069df5df9ec0ec8f31d93e45c0.jpeg",
    "https://content2.onliner.by/catalog/device/header/244b71d833455159c4f9e12cba321ff6.jpeg",
    "https://content2.onliner.by/catalog/device/header/55a3207ee96b2612a6f4345b6f789d3d.jpeg",
    "https://content2.onliner.by/catalog/device/header/7a1493b70d3c90994d6d22f499e8f1a8.jpeg",
    "https://content2.onliner.by/catalog/device/header/3e7f4f7573dd0d6f9f63bc0257deb0d7.jpeg",
    "https://content2.onliner.by/catalog/device/header/0276ce7bb50fd76990ef837b8644e22c.jpeg",
    "https://content2.onliner.by/catalog/device/header/f5a7e22ff8364189286fe7bde3f164cf.jpeg",
    "https://content2.onliner.by/catalog/device/header/7ab75dd34d98704b7d5b89554e2937af.jpg",
    "https://content2.onliner.by/catalog/device/header/199fb4178f29fea03a598da33bce13f8.jpg",
    "https://content2.onliner.by/catalog/device/header/35c0c6c7b06ec259c23b5db821bacd1d.jpg",
    "https://content2.onliner.by/catalog/device/header/f4229b2e76db27ad051371dab44e4190.jpeg",
    "https://content2.onliner.by/catalog/device/header/67e3af64043f2fe3b66f6b385ff126d6.jpeg",
    "https://content2.onliner.by/catalog/device/header/6eacab4ab6a12c8fb64e4ad40c81f2ab.jpeg",
    "https://content2.onliner.by/catalog/device/header/6eacab4ab6a12c8fb64e4ad40c81f2ab.jpeg",
    "https://content2.onliner.by/catalog/device/header/8a66149aad42261f6822ce65de26f41e.jpeg",
    "https://content2.onliner.by/catalog/device/header/ea9f5c3c3cfeb8de55122c78c1f54c0e.jpeg",
    "https://content2.onliner.by/catalog/device/header/50a6b022b655a1cc80f3f6192c5c69de.jpeg",
    "https://content2.onliner.by/catalog/device/header/3ec63950e789d122f0a015e785887012.jpeg",
    "https://content2.onliner.by/catalog/device/header/8f59ec20ba8ea043483882d8b69145e1.jpg",
    "https://content2.onliner.by/catalog/device/header/a91006c8cb52943f649a7dc0a2d5ba1f.jpg",
    "https://content2.onliner.by/catalog/device/header/c964ed3cebe77c941dc85c2d15bcb41f.jpg",
    "https://content2.onliner.by/catalog/device/header/9cab46c5a0b25437bdfbd96725d1ee24.jpg",
    "https://content2.onliner.by/catalog/device/header/6d57ab669cb6f67f3d8e7163ff93159c.jpeg",
    "https://content2.onliner.by/catalog/device/header/5496fb1a6bdf1d21efd48e1abce6fd26.jpeg",
    "https://content2.onliner.by/catalog/device/header/8d4e8b045769fd1faa1d5e05fbfe8bb8.jpeg",
    "https://content2.onliner.by/catalog/device/header/85aa508fdb65d7e702ee1f1e0b7aa32d.jpeg"
)

internal object ProductsMockApi {

    val products: List<Product>

    init {
        products = mutableListOf<Product>().apply {
            for (i in 0..30) {
                val product = Product(
                    id = "$i",
                    title = "Видеокарта №$i",
                    imageUrl = imageUrls[i % imageUrls.size],
                    rate = (100..500).random() * 0.01,
                    description = mutableListOf<String>().apply {
                        repeat((2..10).random()) {
                            add("Описание товара №${it + 1}")
                        }
                    },
                    price = (1000..5000).random().toDouble(),
                    offerDetails = listOf(
                        "Вернем до ${(2..10).random()}% на «Клевер»",
                        "Рассрочка до ${(1..12).random()} месяцев"
                    )
                )
                add(product)
            }
        }
    }
}