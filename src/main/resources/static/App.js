const images =
    [
        {
            image_url: "https://cdn.pixabay.com/photo/2023/09/21/11/30/cat-8266486_1280.jpg",
            description: "Cat, Pumpkin"
        },
        {
            image_url: "https://cdn.pixabay.com/photo/2020/08/25/15/25/pumpkin-5517221_1280.png",
            description: "Pumpkin, Autumn, Vegetables"
        },
        {
            image_url: "https://cdn.pixabay.com/photo/2024/05/17/11/24/foxes-8768091_1280.jpg",
            description: "Foxes, Flowers, Nature"
        },
        {
            image_url: "https://cdn.pixabay.com/photo/2023/11/08/22/32/ai-generated-8375918_960_720.png",
            description: "Ai Generated, Butterfly, Flower"
        },
        {
            image_url: "https://cdn.pixabay.com/photo/2024/08/30/10/14/cat-9009011_1280.jpg",
            description: "Cat, Pet, Animal"
        },
        {
            image_url: "https://cdn.pixabay.com/photo/2014/06/21/08/43/rabbit-373691_1280.jpg",
            description: "Rabbit, Bunny, Pet image"
        }
    ]
let currentIndex = 0;
const img = document.createElement("img")
img.src = images[currentIndex].image_url
img.className = "gallery-item"
const galleryWrapper = document.querySelector(".gallery-wrapper")
const arrowRight = document.querySelector(".arrow-right");
const arrowLeft = document.querySelector(".arrow-left");
galleryWrapper.append(img);

function nextImage() {
    let image = document.getElementsByClassName('gallery-item')[0];
    if (currentIndex < images.length - 1) {
        currentIndex++;
        image.src = images[currentIndex].image_url;
    }
    if (currentIndex === images.length - 1) {
        arrowRight.classList.add("de-active");
    }
    if (currentIndex !== 0) {
        arrowLeft.classList.remove("de-active");
    }
}

function previousImage() {
    let image = document.getElementsByClassName('gallery-item')[0];
    if (currentIndex > -1) {
        currentIndex--;
        image.src = images[currentIndex].image_url;
    }
    if (currentIndex !== images.length - 1) {
        arrowRight.classList.remove("de-active");
    }
    if (currentIndex === 0) {
        arrowLeft.classList.add("de-active");
    }
}
