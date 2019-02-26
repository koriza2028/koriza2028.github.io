
let cube = document.querySelector('.cube');
let sides = document.querySelectorAll('.side');

window.onload = function() {
    document.querySelector('h1').classList.add('showText');
    document.querySelector('h1').style.opacity = '1';
    setTimeout(function() {
        document.querySelector('h1').classList.add('goingUp');
    }, 1000);
    setTimeout(function() {
        document.querySelector('p').classList.add('showText');
    }, 2000);
};

document.querySelectorAll('.leftArrows').forEach((leftArrow) => {
    leftArrow.onclick = () => {
        sides.forEach((side) => {
            side.classList.add(side.classList[1] + 'Position');
        })
        
        if (leftArrow.parentNode.classList.contains('front')) {
            cube.classList.add('leftRotation1');
            setTimeout(() => {
                cube.style.transform = 'rotateY(90deg)';
            }, 3000)
        }
        else if (leftArrow.parentNode.classList.contains('left')) {
            cube.classList.add('leftRotation2');
            setTimeout(() => {
                cube.style.transform = 'rotateY(180deg)';
            }, 3000)
        }
        else if (leftArrow.parentNode.classList.contains('back')) {
            cube.classList.add('leftRotation3');
            setTimeout(() => {
                cube.style.transform = 'rotateY(270deg)';
            }, 3000)
        }
        else {
            cube.classList.add('leftRotation4');
            setTimeout(() => {
                cube.style.transform = 'rotateY(360deg)';
            }, 3000)
            setTimeout(() => {
                cube.style.transform = 'rotateY(0)';
            }, 4000)
        }

        setTimeout(() => {
            sides.forEach((side) => {
                side.classList.remove(side.classList[1] + 'Position');
            })
            cube.classList.remove('leftRotation1');
            cube.classList.remove('leftRotation2');
            cube.classList.remove('leftRotation3');
            cube.classList.remove('leftRotation4');
        }, 4000)
    };
});

document.querySelectorAll('.rightArrows').forEach((rightArrow) => {
    rightArrow.onclick = () => {
        sides.forEach((side) => {
            side.classList.add(side.classList[1] + 'Position');
        })
        
        if (rightArrow.parentNode.classList.contains('front')) {
            cube.classList.add('rightRotation1');
            setTimeout(() => {
                cube.style.transform = 'rotateY(-90deg)';
            }, 3000)
        }
        else if (rightArrow.parentNode.classList.contains('right')) {
            cube.classList.add('rightRotation2');
            setTimeout(() => {
                cube.style.transform = 'rotateY(-180deg)';
            }, 3000)
        }
        else if (rightArrow.parentNode.classList.contains('back')) {
            cube.classList.add('rightRotation3');
            setTimeout(() => {
                cube.style.transform = 'rotateY(-270deg)';
            }, 3000)
        }
        else {
            cube.classList.add('rightRotation4');
            setTimeout(() => {
                cube.style.transform = 'rotateY(-360deg)';
            }, 3000)
            setTimeout(() => {
                cube.style.transform = 'rotateY(0)';
            }, 4000)
        }

        setTimeout(() => {
            sides.forEach((side) => {
                side.classList.remove(side.classList[1] + 'Position');
            })
            cube.classList.remove('rightRotation1');
            cube.classList.remove('rightRotation2');
            cube.classList.remove('rightRotation3');
            cube.classList.remove('rightRotation4');
        }, 4000)
    };
});