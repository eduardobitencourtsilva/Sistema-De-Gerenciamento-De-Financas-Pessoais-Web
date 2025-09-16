$(document).ready(function () {
    function efetuarLogin() {
        $.ajax({
           url: "http://localhost:8080/login/listar",
           method: "GET",
           success: function (data) {
               let usuario = $("#usuario").val();
               let senha = CryptoJS.MD5($("#senha").val()).toString();
               
               if (!usuario || !senha) {
                    alert("Por favor, preencha todos os campos para efetuar o login!");
               }
               else {
                   let logado = false;
                   for (let i = 0; i < data.length; i++) {
                       let user = data[i];
                       if (usuario === user.nome && senha === user.senha) {
                           setCookie("loginID", user.id, 1);
                           alert("Login efetuado com sucesso!");           
                           logado = true;
                           window.location.href = "tabela";
                       }
                   }
                   if (logado === false)
                       alert("Não foi possível efetuar login.");
               }
           },
           error: function () {
               alert("Houve um erro durante o login.");
           }
        });
    }
    
    $("#bLogin").click(function () {
        efetuarLogin();
    });
});