window.onload = function() {
    document.querySelector('h1').classList.add('showText');
    document.querySelector('h1').style.opacity = '1';
    setTimeout(function() {
        document.querySelector('h1').classList.add('goingUp');
    }, 3000);
    setTimeout(function() {
        document.querySelector('p').classList.add('showText');
    }, 5000);
};


