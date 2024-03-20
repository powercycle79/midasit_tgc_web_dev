function onSearch() {
    const searchBox = document.querySelector('#search_box');
    let url = 'https://google.com/search?q=' + searchBox.value;
    let newTab = window.open(url, '_blank');
}

function onGmail() {
    alert('Gmail');
}

function onImage() {
    let newTab = window.open('https://www.google.com/imghp?hl=ko&tab=ri&ogbl', '_blank');
}

function onFeelingLucky() {
    alert('I am Feeling Lucky!');
}

window.onload = function () {
}