function onSearch() {
    const searchBox = document.querySelector('#search_box');
    let url = 'https://google.com/search?q=' + searchBox.value;
    let newTab = window.open(url, '_blank');
}

function onFeelingLucky() {
    alert('I am Feeling Lucky!');
}

window.onload = function () {
    //////////////////////////////////////////////////////////////////
    // javascript
    /*
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
    */
    //////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////
    // jquery
    $('#search_button').click(onSearch);
    $('#feellucky_button').click(onFeelingLucky);

    var keyupbox = function(e) {
        if(e.code == 'Enter') {
            onSearch();
        }
    };

    $('#search_box').keyup(keyupbox);
    //////////////////////////////////////////////////////////////////

    fetch('https://source.unsplash.com/272x92').then((res) => {
        console.log(res.url);

        var logoImg = document.getElementById('logo');
        logoImg.src = res.url;
    });
}