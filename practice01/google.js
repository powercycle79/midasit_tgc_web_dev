function onSearch() {
    const searchBox = document.querySelector('#search_box');
    let url = 'https://google.com/search?q=' + searchBox.value;
    let newTab = window.open(url, '_blank');
}

function onFeelingLucky() {
    alert('I am Feeling Lucky!');
}

window.onload = function () {
    var searchButton = document.getElementById('search_button');
    searchButton.onclick = onSearch;

    var feelluckyButton = document.getElementById('feellucky_button');
    feelluckyButton.onclick = onFeelingLucky;

    var searchBox = document.getElementById('search_box');
    searchBox.onkeyup = function(e) {
        if(e.code == 'Enter') {
            onSearch();
        }
    }
}