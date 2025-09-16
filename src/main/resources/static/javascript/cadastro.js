$(document).ready(function () {
    function cadastrarDespesa(despesa) {
        $.ajax({
            url: "http://localhost:8080/despesas/adicionar",
            method: "POST",
            contentType: "application/json",
            data: JSON.stringify(despesa),
            success: function (data) {
                $("#despesa").val("");
                $("#valor").val("100,00");
                $("#tipo").prop("selectedIndex", 0);
                $("#status").prop("selectedIndex", 0);
            },
            error: function () {
                alert("Erro ao cadastrar despesa.");
            }
        });
    }
    
    $("#voltar").click(function () {
        window.location.href = "tabela";
    });
    
    $("#cadastrar").click(function () {
        let valor = $("#valor").val();
        
        valor = valor.replace(",", ".");
        valor = parseFloat(valor).toFixed(2);

        let despesa = $("#despesa").val();
        let tipo = $("#tipo").val();
        let status = $("#status").val();

        if (!despesa) {
            alert("Por favor, preencha todos os campos para cadastrar a despesa!");
        }
        else if (valor < 1) {
            alert("Valor inválido para cadastrar a despesa.");
        }
        
        else {
            let despesaObjeto = {
                valor: valor,
                nome: despesa,
                tipo: tipo,
                categoria: null,
                status: status
            };
            
            let loginID = Number(getCookie("loginID"));
            
            getUser(loginID).then(login => {
                if (login.tipo === "admin") {
                     cadastrarDespesa(despesaObjeto);
                     alert("Despesa cadastrada com sucesso!");
                }
                else {
                     alert("Não foi possível cadastrar a despesa: é necessário ser administrador do sistema.");
                } 
            });
        }
    });
});