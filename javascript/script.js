const scrollAnima = document.querySelector('[data-anima="scroll"]');

const metadeWindow = window.innerHeight *5.0;



function animarScroll(){
const topoItem = scrollAnima.getBoundingClientRect().top;
const soma = topoItem + metadeWindow;
console.log(soma);
if(soma >= 3300){
    scrollAnima.classList.remove('show-button');
}else {
   scrollAnima.classList.add('show-button');
}


};

window.addEventListener('scroll',animarScroll)





