const formulario = document.querySelector("form");
const Iemail = document.querySelector(".email");
const Itel = document.querySelector(".tel");
const Ilogin = document.querySelector(".login");
const Isenha = document.querySelector(".senha");

function cadastrar() {
    fetch("http://localhost:8080/usuario",
        {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "POST",
            body: JSON.stringify({
                email: Iemail.value,
                tel: Itel.value,
                login: Ilogin.value,
                senha: Isenha.value
            })
        })
        .then(function (res) { console.log(res) })
        .catch(function (res) { console.log(res) })

}

function limpar() {
    Iemail.value = "";
    Itel.value = "";
    Ilogin.value = "";
    Isenha.value = "";

}

formulario.addEventListener('submit', function (event) {
    event.preventDefault();

    cadastrar();
    limpar();
});