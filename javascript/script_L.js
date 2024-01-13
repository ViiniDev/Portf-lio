const formulario = document.querySelector("form");
const Ilogin = document.querySelector(".login");
const Isenha = document.querySelector(".senha");

function login() {
    fetch("http://localhost:8080/usuario",
        {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "GET",
            body: JSON.stringify({
                login: Ilogin.value,
                senha: Isenha.value
            })
        })
        .then(function (res) { console.log(res) })
        .catch(function (res) { console.log(res) })

}

function limpar() {
    Ilogin.value = "";
    Isenha.value = "";
}

formulario.addEventListener('submit', function (event) {
    event.preventDefault();

    login();
    limpar();
});

function onChangeEmail() {
    toggleButtonDisable();
    toggleEmailError();
    

}
function onChangePassowrd(){
    toggleButtonDisable();
    toggleSenhaError();
}

function login_accept(){
    return window.location.href = "Calculadora.html" ;
}

function cadastrar_user(){
    return window.location.href = "Cadastro.html" ;
}

function isEmailValid() {
    const email = Ilogin.value;
    if (!email) {
        return false;
    }
    return validadeLogin(email);
}


function validadeLogin(Ilogin) {
    return /\S+@\S+\.\S+/.test(Ilogin);
}

function isValidPassowrd() {
    const password = Isenha.value;
    if (!password) {
        return false;
    }
    return true;
}

function toggleButtonDisable() {
    const emailValid = isEmailValid();
    form.recoverPassword().disabled = !emailValid;

    const passwordValid = isValidPassowrd();
    form.loginBtn().disabled = !emailValid || !passwordValid;
}

function toggleEmailError() {
    const email = Ilogin.value;
    
    if (!email) {
        document.getElementById('email-error-obg').style.display = "block";
    } else {
        document.getElementById('email-error-obg').style.display = "none";
    }

    if (validadeLogin(email)) {
        document.getElementById('email-error').style.display = "none";
    } else {
        document.getElementById('email-error').style.display = "block";
    }
}

function toggleSenhaError(){
    const password = Isenha.value;

    if(!password){
        document.getElementById('senha-error').style.display = "block";
    }else {
        document.getElementById('senha-error').style.display = "none";
    }
}

const form = {
 recoverPassword : () => document.getElementById('recover-password-button'),
 loginBtn : () => document.getElementById('login-btn'),
 emailErrorObg : () => document.getElementById('email-error-obg'),
 emailError : () => document.getElementById('email-error'),
 senhaError: () => document.getElementById('senha-error')
}

