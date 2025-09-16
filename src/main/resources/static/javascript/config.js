$(document).ready(function () { 
    function configurarDespesaCategoria(id, categoria) {
        $.ajax({
            url: "http://localhost:8080/despesas/atualizar/" + id,
            method: "PUT",
            contentType: "application/json",
            data: JSON.stringify({categoria: categoria}),
            success: function (data) {
                alert("A categoria da despesa foi configurada com sucesso!");
            },
            error: function () {
                alert("Houve um erro ao configurar categoria da despesa");
            }
        });
    }
    
    function deletarDespesa(id) {
        $.ajax({
           url: "http://localhost:8080/despesas/deletar/" + id,
           method: "DELETE",
           success: function (data) {
               alert("A despesa de " + id + " foi deletada com sucesso!");
           },
           error: function () {
               alert("Houve um erro ao deletar a despesa");
           }
        });
    }
    
    function encontrarDespesa(id) {
        return new Promise((resolve, reject) => {
           $.ajax({
                url: "http://localhost:8080/despesas/listar",
                method: "GET",
                success: function (data) {
                    let encontrada = data.find(d => Number(d.id) === Number(id)) || null;
                    resolve(encontrada);
                },
                error: function () {
                    reject("Erro ao buscar despesa");
                }
            });
        });
    }
    
    function notificar(id) {
        encontrarDespesa(id).then(despesa => {
                if (!despesa || despesa.status !== "pendente") {
                    alert("Houve um erro: a despesa não existe ou já foi paga.");
                    return;
                }
                
                let texto = `Você tem para pagar a despesa ${despesa.tipo} ${despesa.nome} de ID ${id}`;
                
                if (despesa.categoria && despesa.categoria.trim() !== "") {
                    texto += `, categoria ${despesa.categoria}`;
                }
                
                texto += ` e valor R$ ${despesa.valor}!`;
                
                const notification = new Notification("SGFP - Notificação sobre suas despesas", {
                    body: texto,
                    icon: "img/icon.png"
                });
                
                notification.onclick = (event) => {
                    event.preventDefault();
                    window.open("config", "_blank");
                };     
        }).catch(err => alert("Erro: " + err));
    }
    
    function iniciarNotificacao(id, minutos) {
        Notification.requestPermission().then(permission => {
           if (permission !== "granted") {
               alert("As notificações estão bloqueadas pelo navegador.");
               return;
           }
           else {
               encontrarDespesa(id).then(despesa => {
                   if (!despesa || despesa.status !== "pendente") {
                        alert("Houve um erro: a despesa não existe ou já foi paga.");
                        return;
                   }
                   else {
                        setInterval(() => {
                            notificar(id, minutos); 
                        }, minutos * 60 * 1000);
                        alert("Notificação configurada com sucesso!");
                   }
               });    
           }      
        });
    }
    
    $("#voltar").click(function () {
        window.location.href = "tabela";
    });
    
    $("#okCategoria").click(function () {
        var id = $("#idDespesaCategoria").val();
        var categoria = $("#categoria").val();
        
        let loginID = Number(getCookie("loginID"));
        
        getUser(loginID).then(login => {
           if (login.tipo === "admin") {
               if (!categoria) {
                   alert("Por favor, preencha todos os campos para configurar a categoria!");
               }
               else {
                   configurarDespesaCategoria(id, categoria);
               }
           } 
           else {
               alert("Não foi possível configurar a despesa: é necessário ser administrador do sistema.");
           }
        });  
        
    });
    
    $("#okNotificar").click(function () {
        var id = $("#idDespesaNotificar").val();
        var minutos = $("#minutos").val();
        iniciarNotificacao(id, minutos);
    });
    
    $("#okExcluir").click(function () {
        let loginID = Number(getCookie("loginID"));
        
        var id = $("#idDespesaExcluir").val();
        
        getUser(loginID).then(login => {
           if (login.tipo === "admin") {
                deletarDespesa(id);
           }
           else {
                alert("Não foi possível excluir a despesa: é necessário ser administrador do sistema.");
           }
        });
    });
    
});